/*
 * Part of the ROBOID project
 * Copyright (C) 2016 Kwang-Hyun Park (akaii@kw.ac.kr) and Kyoung Jin Kim
 * https://github.com/roboidstudio/embedded
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
*/

package org.roboid.audio.epd.hci;

import hcilab.HciEpdLib;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.roboid.audio.Activator;
import org.roboid.audio.AudioUtil;
import org.roboid.audio.epd.Epd;


/**
 * <p>
 * 마이크로부터 음성이 나오는 부분만 추출해서 반환합니다.
 * </p>
 * <b>사용방법:</b>
 * <p>
 * <ul>
 * <li><i>(optional)</i> <code>{@link HciEpd#configEPD()}</code>로 EPD 옵션을
 * 지정합니다. 지정하지 않을 경우 기본 값으로 자동 지정됩니다.</li>
 * <li><code>{@link HciEpd#detectEpd(AudioInputStream)}</code>로 음성의 일부분 또는
 * 전체를 입력합니다. 일부분을 쪼개서 이 함수를 호출한다면, 음성의 일부분인 경우 실패 결과를 반환하고 마지막 음성이 끝나면, 쪼개진
 * 음성들을 합쳐서 추출한 전체 음성 데이터를 반환합니다 </li>
 * </ul>
 * </li>
 * </p>
 * 
 * @author Tae-hoon Kim
 */
public class HciEpd extends Epd
{
	/**
	 * EPD의 결과를 나타내는 enum
	 * 
	 * @author 김태훈(<a href="mailto:zyint.com@gmail.com">zyint.com@gmail.com</a>)
	 */
	public static enum HciEpdResultCode
	{

		/** EPD 추출을 실패하였을 때 */
		FAILED(-1),
		/** EPD 추출을 성공하였을 때 */
		SUCCESS(1);

		/** HCI Epd Library에서 나타내는 코드 */
		private int epdResultCode;

		HciEpdResultCode(int epdResultCode)
		{
			this.epdResultCode = epdResultCode;
		}

		/**
		 * HCI Epd Library에서 나타내는 결과 코드를 반환 합니다.
		 * 
		 * @return HCI Epd Library에서 나타내는 코드
		 */
		public int getEpdResultCode()
		{
			return epdResultCode;
		}
	}

	/**
	 * EPD 라이브러리에서 처리할 수 있는 포맷
	 */
	public static final AudioFormat EPD_FORMAT = new AudioFormat(8000, 16, 1, true, false);

	static
	{
		try
		{
			File file = new File(Activator.findLibraryPath("HciEpdPc.dll"));
			Activator.addLibraryPath(file.getParentFile().getCanonicalPath());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		System.loadLibrary("HciEpdPc");
		System.loadLibrary("HciEpdLib");

	}

	/**
	 * <dl>
	 * <dt>시작점 기준으로 앞으로 몇 프레임까지 음성구간에 포함할 것인가</dt>
	 * <dd>프레임은 Action의 프레임이 아닌 마이크 Sampling rate에 따른 프레임을 말합니다.</dd>
	 * </dl>
	 */
	private int begin_margin_frame = 15;

	private final boolean DEBUG = false;

	/**
	 * <dl>
	 * <dt>끝점 기준으로 뒤로 몇 프레임까지 음성구간에 포함할 것인가 </dt>
	 * <dd>프레임은 Action의 프레임이 아닌 마이크 Sampling rate에 따른 프레임을 말합니다.</dd>
	 * </dl>
	 */
	private int end_margin_frame = 15;

	/** HCI Lab Epd Library */
	private HciEpdLib epd = new HciEpdLib();

	/**
	 * <dl>
	 * <dt>시작점 검출 이후, 이 시간보다 긴 시간 동안 음성신호가 없다면 끝점을 검출함</dt>
	 * <dd>프레임은 Action의 프레임이 아닌 마이크 Sampling rate에 따른 프레임을 말합니다.</dd>
	 * </dl>
	 */
	private int pause_th_frame = 40;

	/** 발성하지 않는 구간으로 간주되는 에너지 임계값 */
	private float silence_gain_th = 2.0f;

	/** 발성구간으로 간주되는 에너지 임계값 */
	private float speech_gain_th = 4.0f;

	/**
	 * <dl>
	 * <dt>음성으로 간주되기 위한 최소한의 길이</dt>
	 * <dd>프레임은 Action의 프레임이 아닌 마이크 Sampling rate에 따른 프레임을 말합니다.</dd>
	 * </dl>
	 */
	private int speech_length_frame = 20;

	/**
	 * <dl>
	 * <dt>최초 입력되는 음성 중 몇 프레임을 버릴 것인가</dt>
	 * <dd>프레임은 Action의 프레임이 아닌 마이크 Sampling rate에 따른 프레임을 말합니다.</dd>
	 * </dl>
	 */
	private int useless_margin_frame = 0;

	public HciEpd()
	{
		if (DEBUG)
		{
			System.out.printf("configuration...");
		}
		int r = epd.ConfigEPD(	useless_margin_frame,
								begin_margin_frame,
								speech_length_frame,
								pause_th_frame,
								end_margin_frame,
								silence_gain_th,
								speech_gain_th);
		if (DEBUG)
		{
			System.out.printf(	"%d \n",
								r == 1 ? "SUCCESS" : "FAILED");
		}
		epd.InitializeEpd(true);
	}

	/**
	 * <p>
	 * 음성 검출시 사용되는 각 threshold 값을 설정한다. 객체 생성이후 호출하여 파라미터를 세팅하며, 객체 소멸이나 재 호출하지
	 * 않으면 그 설정값이 유지된다.
	 * </p>
	 * <p>
	 * 여기서 프레임은 마이크의 Sampling rate에 따른 프레임 수를 말합니다.
	 * </p>
	 * 
	 * @param useless_margin_frame
	 *            최초 입력되는 음성 중 몇 프레임을 버릴 것인가
	 * @param begin_margin_frame
	 *            시작점 기준으로 앞으로 몇 프레임까지 음성구간에 포함할 것인가
	 * @param speech_length_frame
	 *            음성으로 간주되기 위한 최소한의 길이
	 * @param pause_th_frame
	 *            시작점 검출 이후, 이 시간보다 긴 시간 동안 음성신호가 없다면 끝점을 검출함
	 * @param end_margin_frame
	 *            끝점 기준으로 뒤로 몇 프레임까지 음성구간에 포함할 것인가
	 * @param silence_gain_th
	 *            발성하지 않는 구간으로 간주되는 에너지 임계값
	 * @param speech_gain_th
	 *            발성구간으로 간주되는 에너지 임계값
	 * @return 0 입력값이 범위를 벗어난 관계로 설정 실패, 1 올바로 설정됨
	 */
	public int configEPD(	int useless_margin_frame,
							int begin_margin_frame,
							int speech_length_frame,
							int pause_th_frame,
							int end_margin_frame,
							float silence_gain_th,
							float speech_gain_th)
	{

		this.useless_margin_frame = useless_margin_frame;
		this.begin_margin_frame = begin_margin_frame;
		this.speech_length_frame = speech_length_frame;
		this.pause_th_frame = pause_th_frame;
		this.end_margin_frame = end_margin_frame;
		this.silence_gain_th = silence_gain_th;
		this.speech_gain_th = speech_gain_th;

		int ret = epd.ConfigEPD(useless_margin_frame,
								begin_margin_frame,
								speech_length_frame,
								pause_th_frame,
								end_margin_frame,
								silence_gain_th,
								speech_gain_th);
		epd.InitializeEpd(true);
		return ret;
	}

	/**
	 * 음성의 일부분 또는 전체를 입력합니다. 일부분을 쪼개서 이 함수를 호출한다면, 음성의 일부분인 경우 실패 결과를 반환하고 마지막
	 * 음성이 끝나면, 쪼개진 음성들을 합쳐서 추출한 전체 음성 데이터를 반환합니다
	 * 
	 * @param audio
	 * @return
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public synchronized HciEpdResult detectEpd(AudioInputStream audio) throws UnsupportedAudioFileException, IOException, IllegalArgumentException
	{
		AudioInputStream convAudio = AudioUtil.getAudioInputStream(	EPD_FORMAT,
																		audio);

		HciEpdResultCode resultCode = null;
		AudioInputStream epdData = null;

		// convAudio byte 수
		int sizeOfConvAudio = (int) (convAudio.getFrameLength() * convAudio.getFormat()
				.getFrameSize());

		for (int i = 0; i < (int) Math.ceil((double) sizeOfConvAudio / 160); i++)
		{
			byte[] buf = new byte[160];
			convAudio.read(buf);

			// 결과
			int resultOfEpdLib = epd.DetectEPD(buf); // EPD Detect
			resultCode = (resultOfEpdLib == HciEpdResultCode.SUCCESS.getEpdResultCode())
																						? HciEpdResultCode.SUCCESS
																						: HciEpdResultCode.FAILED;

			if (resultCode == HciEpdResultCode.SUCCESS)
			{
				// 성공
				if (DEBUG)
				{
					System.out.println("epd success");
				}

				byte[] epdByteData = epd.getEpdData();
				epdData = AudioUtil.getAudioInputStream(EPD_FORMAT,
														epdByteData);
				epd.InitializeEpd(true);

				// 파일에 저장하는 소스코드
				// try
				// {
				// FileOutputStream fout = new
				// FileOutputStream(System.nanoTime()+".wav");
				// fout.write(epdByteData);
				// fout.close();
				// } catch (FileNotFoundException e){ e.printStackTrace();
				// } catch (IOException e){ e.printStackTrace(); }

				break;

			}
			else if (resultCode == HciEpdResultCode.FAILED)
			{
				// 실패
				if (DEBUG)
				{
					System.out.println("epd failed");
				}
				epdData = null;
			}
		} // end for

		return new HciEpdResult(resultCode == HciEpdResultCode.SUCCESS ? true : false, epdData);
	}

	/**
	 * 새로운 epd를 추출하기 위해 저장되어있던 음성 데이터를 초기화합니다.
	 */
	public void reset()
	{
		epd.InitializeEpd(true);
	}
}
