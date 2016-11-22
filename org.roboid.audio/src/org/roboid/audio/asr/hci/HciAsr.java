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

package org.roboid.audio.asr.hci;

import hcilab.AsrLib;
import hcilab.ResultInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.roboid.audio.AudioUtil;
import org.roboid.audio.asr.Asr;
import org.roboid.audio.epd.hci.HciEpd;

/**
 * @author Tae-hoon Kim
 * @see HciAsrResult
 * @see HciEpd
 */
public class HciAsr extends Asr
{
	class ASRThread extends Thread
	{

		private byte[] audioByteArray;
		private List<Exception> exceptionList = new ArrayList<Exception>();
		private HciAsrOnCompleteListener onCompleteListener = null;
		private String words;

		public ASRThread(String name,
				String words,
				byte[] audioByteArray,
				HciAsrOnCompleteListener onCompleteListener)
		{
			super(name);
			this.words = words;
			this.audioByteArray = audioByteArray;
			this.onCompleteListener = onCompleteListener;
		}

		/*
		 * ASR 부분 (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			if (audioByteArray == null)
			{
				exceptionList
						.add(new NullPointerException("EPD AudioInputStream을 지정하지 않았습니다"));
			}
			if (words == null || words == "")
			{
				exceptionList.add(new NullPointerException("인식 단어를 설정하지 않았습니다."));
			}

			HciAsrResult result = null;

			synchronized (audioByteArray)
			{

				AsrLib lib = new AsrLib();
				try
				{

					lib.ASR_SVC_OPEN(	ASR_SERVER_IP,
										ASR_SERVER_PORT);

					if (lib.ASR_SVC_RECG_OPEN() != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_RECG_OPEN_FAILED,
													null,
													null,
													0);

						throw new hcilab.HciException("ASR_SVC_RECG_OPEN() Failed");
					}

					if (lib.ASR_SVC_RECG_WLST(words) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_RECG_WLST_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("ASR_SVC_RECG_WLST() Failed");
					}

					if (lib.ASR_SVC_RECG_RJCT(	4.82,
												2) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_RECG_RJCT_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("ASR_SVC_RECG_RJCT() Failed");
					}

					// init;
					if (lib.ASR_SVC_DATA(	null,
											0,
											0,
											0) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_DATA_INITIALIZE_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("ASR_SVC_DATA() init Failed");
					}

					// 데이터,길이, 데이터작성:1, 잡음제거1, 심할경우:2
					if (lib.ASR_SVC_DATA(	audioByteArray,
											audioByteArray.length,
											1,
											noiseFiltering.getFilteringCode()) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_DATA_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("ASR_SVC_DATA() Failed");
					}

					if (lib.ASR_SVC_RECG_PROC(	audioByteArray,
												audioByteArray.length) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_RECG_PROC_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("lib.ASR_SVC_RECG_PROC() Failed");
					}

					ResultInfo ri = new ResultInfo();
					if (lib.ASR_SVC_RECG(ri) != AsrLib.ASR_PROC_SUCS)
					{
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.ASR_SVC_RECOG_FAILED,
													null,
													null,
													0);
						throw new hcilab.HciException("ASR_SVC_RECOG() : Fail");
					}

					if (lib.getFSCOR()[0] != 0.01)
					{ // 제대로 인식됐을경우
						// 결과 저장
						result = new HciAsrResult(HciAsrResult.HciAsrErrorCode.SUCCESS, lib
								.getCRECG()[0], lib.getCOUTS()[0], lib.getFSCOR()[0]);

					}
					else
					{ // 인식이 실패했을경우
						// 결과 저장
						result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.RECOGNIZE_FAILED,
													null,
													null,
													0);

					}

				}
				catch (hcilab.HciException e)
				{
					// e.printStackTrace();
					exceptionList.add(new org.roboid.audio.hci.HciOuterException(e));

				}
				finally
				{

					// 가장 최근에 만들어진 스레드만이 유효하므로, 스레드 유효성을 검사한다.
					if (HciAsr.this.threadHashcode == ASRThread.this.hashCode())
					{
						// 재생 종료
						// HciAsr.this.setTargetFrame(currentFrame);

						// 결과값 저장
						if (result == null)
						{
							result = new HciAsrResult(	HciAsrResult.HciAsrErrorCode.UNKNOWN_FAILED,
														null,
														null,
														0);
						}

						if (onCompleteListener != null)
						{
							onCompleteListener.onComplete(	result,
															exceptionList);
						}
					}

					try
					{
						lib.ASR_SVC_RECG_CLOS();
					}
					catch (hcilab.HciException e)
					{
						exceptionList.add(new org.roboid.audio.hci.HciOuterException(e));
					}
					try
					{
						lib.ASR_SVC_CLOS();
					}
					catch (hcilab.HciException e)
					{
						exceptionList.add(new org.roboid.audio.hci.HciOuterException(e));
					}

				}

			} // end synchronized
		} // end run()

	}

	/** NoiseFilteringLevel */
	public static enum HciAsrNoiseFilteringLevel
	{
		/** 잡음이 심한경우 이 옵션을 설정합니다. 음성인식 성공률이 낮아질 수 있지만, 잡음이 심한경우 효과적입니다. */
		EXTREAM(2),

		/** ASR 내부에서 노이즈 필터링을 하지 않습니다. */
		NONE(0),

		/** 일반적인 수준에서의 노이즈 필터링을 합니다. */
		NORMAL(1);

		private int filteringCode;

		HciAsrNoiseFilteringLevel(int code)
		{
			this.filteringCode = code;
		}

		/** @return HCILAB Library에서의 노이즈 필터링 코드를 반환합니다. */
		public int getFilteringCode()
		{
			return filteringCode;
		}
	}

	/** ASR 서버 IP 주소 */
	private final String ASR_SERVER_IP = "roboid.co.kr";

	/** ASR 서버 포트 번호 */
	private final int ASR_SERVER_PORT = 9000;

	/** epd로부터 추출된 음성 데이터 */
	volatile private byte audioByteArray[];

	private final AudioFormat EPD_FORMAT = new AudioFormat(8000, 16, 1, true, false);

	/** 노이즈 필터링 수준 설정 */
	private HciAsrNoiseFilteringLevel noiseFiltering = HciAsrNoiseFilteringLevel.NORMAL;

	private HciAsrOnCompleteListener onCompleteListener = null;

	/** 현재 실행중인 Thread의 고유 hashcode */
	private long threadHashcode = 0;

	/** 인식할 단어 목록 */
	private String words;

	public HciAsr()
	{
	}

	/**
	 * EPD를 통해 처리된 음성 스트림을 설정합니다.
	 * 
	 * @param ain
	 *            EPD를 통해 처리된 음성 스트림
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public void setAudioStream(AudioInputStream ain) throws IOException, IllegalArgumentException
	{
		AudioInputStream converted = AudioUtil.getAudioInputStream(EPD_FORMAT, ain);

		if (audioByteArray != null)
		{
			synchronized (audioByteArray)
			{
				audioByteArray = AudioUtil.getByteArrayHeaderless(converted);
			}
		}
		else
		{
			audioByteArray = AudioUtil.getByteArrayHeaderless(converted);
		}

	}

	/**
	 * 음성인식이 완료되었을 때 실행할 리스너를 설정합니다.
	 * 
	 * @param onCompleteListener
	 */
	public void setOnCompleteListener(HciAsrOnCompleteListener onCompleteListener)
	{
		this.onCompleteListener = onCompleteListener;
	}

	/**
	 * <p>
	 * 인식할 단어 목록을 설정합니다. ASR에서 인식할 단어와 결과를 보여줄 심볼을 설정할 수 있습니다.
	 * </p>
	 * <p>
	 * <b>주!</b> 인식단어와 심볼에는 공백을 넣을 수 없으며 <b>인식단어와 ,(콤마)와 ;(세미콜론)</b>은 필수입니다.
	 * 심볼을 입력하지 않을 경우 결과에서 심볼은 인식단어를 반환합니다.
	 * </p>
	 * 
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 *  
	 * 사용법: 인식단어1,심볼1;인식단어2,심볼2;  ...
	 * 예) 홍길동,01012345678;세종대왕,;김철수,;
	 * </pre>
	 * 
	 * </blockquote>
	 * </p>
	 * 
	 * @param words
	 *            인식할 단어 목록
	 */
	public void setWords(String words)
	{
		this.words = words;
	}

	/**
	 * 음성 인식을 시작합니다.
	 */
	public void start()
	{
		ASRThread thread = new ASRThread("ASR", words, audioByteArray, onCompleteListener);
		threadHashcode = thread.hashCode();
		thread.start();
	}
}
