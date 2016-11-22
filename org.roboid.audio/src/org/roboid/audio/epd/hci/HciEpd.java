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
 * ����ũ�κ��� ������ ������ �κи� �����ؼ� ��ȯ�մϴ�.
 * </p>
 * <b>�����:</b>
 * <p>
 * <ul>
 * <li><i>(optional)</i> <code>{@link HciEpd#configEPD()}</code>�� EPD �ɼ���
 * �����մϴ�. �������� ���� ��� �⺻ ������ �ڵ� �����˴ϴ�.</li>
 * <li><code>{@link HciEpd#detectEpd(AudioInputStream)}</code>�� ������ �Ϻκ� �Ǵ�
 * ��ü�� �Է��մϴ�. �Ϻκ��� �ɰ��� �� �Լ��� ȣ���Ѵٸ�, ������ �Ϻκ��� ��� ���� ����� ��ȯ�ϰ� ������ ������ ������, �ɰ���
 * �������� ���ļ� ������ ��ü ���� �����͸� ��ȯ�մϴ� </li>
 * </ul>
 * </li>
 * </p>
 * 
 * @author Tae-hoon Kim
 */
public class HciEpd extends Epd
{
	/**
	 * EPD�� ����� ��Ÿ���� enum
	 * 
	 * @author ������(<a href="mailto:zyint.com@gmail.com">zyint.com@gmail.com</a>)
	 */
	public static enum HciEpdResultCode
	{

		/** EPD ������ �����Ͽ��� �� */
		FAILED(-1),
		/** EPD ������ �����Ͽ��� �� */
		SUCCESS(1);

		/** HCI Epd Library���� ��Ÿ���� �ڵ� */
		private int epdResultCode;

		HciEpdResultCode(int epdResultCode)
		{
			this.epdResultCode = epdResultCode;
		}

		/**
		 * HCI Epd Library���� ��Ÿ���� ��� �ڵ带 ��ȯ �մϴ�.
		 * 
		 * @return HCI Epd Library���� ��Ÿ���� �ڵ�
		 */
		public int getEpdResultCode()
		{
			return epdResultCode;
		}
	}

	/**
	 * EPD ���̺귯������ ó���� �� �ִ� ����
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
	 * <dt>������ �������� ������ �� �����ӱ��� ���������� ������ ���ΰ�</dt>
	 * <dd>�������� Action�� �������� �ƴ� ����ũ Sampling rate�� ���� �������� ���մϴ�.</dd>
	 * </dl>
	 */
	private int begin_margin_frame = 15;

	private final boolean DEBUG = false;

	/**
	 * <dl>
	 * <dt>���� �������� �ڷ� �� �����ӱ��� ���������� ������ ���ΰ� </dt>
	 * <dd>�������� Action�� �������� �ƴ� ����ũ Sampling rate�� ���� �������� ���մϴ�.</dd>
	 * </dl>
	 */
	private int end_margin_frame = 15;

	/** HCI Lab Epd Library */
	private HciEpdLib epd = new HciEpdLib();

	/**
	 * <dl>
	 * <dt>������ ���� ����, �� �ð����� �� �ð� ���� ������ȣ�� ���ٸ� ������ ������</dt>
	 * <dd>�������� Action�� �������� �ƴ� ����ũ Sampling rate�� ���� �������� ���մϴ�.</dd>
	 * </dl>
	 */
	private int pause_th_frame = 40;

	/** �߼����� �ʴ� �������� ���ֵǴ� ������ �Ӱ谪 */
	private float silence_gain_th = 2.0f;

	/** �߼��������� ���ֵǴ� ������ �Ӱ谪 */
	private float speech_gain_th = 4.0f;

	/**
	 * <dl>
	 * <dt>�������� ���ֵǱ� ���� �ּ����� ����</dt>
	 * <dd>�������� Action�� �������� �ƴ� ����ũ Sampling rate�� ���� �������� ���մϴ�.</dd>
	 * </dl>
	 */
	private int speech_length_frame = 20;

	/**
	 * <dl>
	 * <dt>���� �ԷµǴ� ���� �� �� �������� ���� ���ΰ�</dt>
	 * <dd>�������� Action�� �������� �ƴ� ����ũ Sampling rate�� ���� �������� ���մϴ�.</dd>
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
	 * ���� ����� ���Ǵ� �� threshold ���� �����Ѵ�. ��ü �������� ȣ���Ͽ� �Ķ���͸� �����ϸ�, ��ü �Ҹ��̳� �� ȣ������
	 * ������ �� �������� �����ȴ�.
	 * </p>
	 * <p>
	 * ���⼭ �������� ����ũ�� Sampling rate�� ���� ������ ���� ���մϴ�.
	 * </p>
	 * 
	 * @param useless_margin_frame
	 *            ���� �ԷµǴ� ���� �� �� �������� ���� ���ΰ�
	 * @param begin_margin_frame
	 *            ������ �������� ������ �� �����ӱ��� ���������� ������ ���ΰ�
	 * @param speech_length_frame
	 *            �������� ���ֵǱ� ���� �ּ����� ����
	 * @param pause_th_frame
	 *            ������ ���� ����, �� �ð����� �� �ð� ���� ������ȣ�� ���ٸ� ������ ������
	 * @param end_margin_frame
	 *            ���� �������� �ڷ� �� �����ӱ��� ���������� ������ ���ΰ�
	 * @param silence_gain_th
	 *            �߼����� �ʴ� �������� ���ֵǴ� ������ �Ӱ谪
	 * @param speech_gain_th
	 *            �߼��������� ���ֵǴ� ������ �Ӱ谪
	 * @return 0 �Է°��� ������ ��� ����� ���� ����, 1 �ùٷ� ������
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
	 * ������ �Ϻκ� �Ǵ� ��ü�� �Է��մϴ�. �Ϻκ��� �ɰ��� �� �Լ��� ȣ���Ѵٸ�, ������ �Ϻκ��� ��� ���� ����� ��ȯ�ϰ� ������
	 * ������ ������, �ɰ��� �������� ���ļ� ������ ��ü ���� �����͸� ��ȯ�մϴ�
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

		// convAudio byte ��
		int sizeOfConvAudio = (int) (convAudio.getFrameLength() * convAudio.getFormat()
				.getFrameSize());

		for (int i = 0; i < (int) Math.ceil((double) sizeOfConvAudio / 160); i++)
		{
			byte[] buf = new byte[160];
			convAudio.read(buf);

			// ���
			int resultOfEpdLib = epd.DetectEPD(buf); // EPD Detect
			resultCode = (resultOfEpdLib == HciEpdResultCode.SUCCESS.getEpdResultCode())
																						? HciEpdResultCode.SUCCESS
																						: HciEpdResultCode.FAILED;

			if (resultCode == HciEpdResultCode.SUCCESS)
			{
				// ����
				if (DEBUG)
				{
					System.out.println("epd success");
				}

				byte[] epdByteData = epd.getEpdData();
				epdData = AudioUtil.getAudioInputStream(EPD_FORMAT,
														epdByteData);
				epd.InitializeEpd(true);

				// ���Ͽ� �����ϴ� �ҽ��ڵ�
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
				// ����
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
	 * ���ο� epd�� �����ϱ� ���� ����Ǿ��ִ� ���� �����͸� �ʱ�ȭ�մϴ�.
	 */
	public void reset()
	{
		epd.InitializeEpd(true);
	}
}
