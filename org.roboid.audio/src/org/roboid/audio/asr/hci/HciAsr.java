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
		 * ASR �κ� (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			if (audioByteArray == null)
			{
				exceptionList
						.add(new NullPointerException("EPD AudioInputStream�� �������� �ʾҽ��ϴ�"));
			}
			if (words == null || words == "")
			{
				exceptionList.add(new NullPointerException("�ν� �ܾ �������� �ʾҽ��ϴ�."));
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

					// ������,����, �������ۼ�:1, ��������1, ���Ұ��:2
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
					{ // ����� �νĵ������
						// ��� ����
						result = new HciAsrResult(HciAsrResult.HciAsrErrorCode.SUCCESS, lib
								.getCRECG()[0], lib.getCOUTS()[0], lib.getFSCOR()[0]);

					}
					else
					{ // �ν��� �����������
						// ��� ����
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

					// ���� �ֱٿ� ������� �����常�� ��ȿ�ϹǷ�, ������ ��ȿ���� �˻��Ѵ�.
					if (HciAsr.this.threadHashcode == ASRThread.this.hashCode())
					{
						// ��� ����
						// HciAsr.this.setTargetFrame(currentFrame);

						// ����� ����
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
		/** ������ ���Ѱ�� �� �ɼ��� �����մϴ�. �����ν� �������� ������ �� ������, ������ ���Ѱ�� ȿ�����Դϴ�. */
		EXTREAM(2),

		/** ASR ���ο��� ������ ���͸��� ���� �ʽ��ϴ�. */
		NONE(0),

		/** �Ϲ����� ���ؿ����� ������ ���͸��� �մϴ�. */
		NORMAL(1);

		private int filteringCode;

		HciAsrNoiseFilteringLevel(int code)
		{
			this.filteringCode = code;
		}

		/** @return HCILAB Library������ ������ ���͸� �ڵ带 ��ȯ�մϴ�. */
		public int getFilteringCode()
		{
			return filteringCode;
		}
	}

	/** ASR ���� IP �ּ� */
	private final String ASR_SERVER_IP = "roboid.co.kr";

	/** ASR ���� ��Ʈ ��ȣ */
	private final int ASR_SERVER_PORT = 9000;

	/** epd�κ��� ����� ���� ������ */
	volatile private byte audioByteArray[];

	private final AudioFormat EPD_FORMAT = new AudioFormat(8000, 16, 1, true, false);

	/** ������ ���͸� ���� ���� */
	private HciAsrNoiseFilteringLevel noiseFiltering = HciAsrNoiseFilteringLevel.NORMAL;

	private HciAsrOnCompleteListener onCompleteListener = null;

	/** ���� �������� Thread�� ���� hashcode */
	private long threadHashcode = 0;

	/** �ν��� �ܾ� ��� */
	private String words;

	public HciAsr()
	{
	}

	/**
	 * EPD�� ���� ó���� ���� ��Ʈ���� �����մϴ�.
	 * 
	 * @param ain
	 *            EPD�� ���� ó���� ���� ��Ʈ��
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
	 * �����ν��� �Ϸ�Ǿ��� �� ������ �����ʸ� �����մϴ�.
	 * 
	 * @param onCompleteListener
	 */
	public void setOnCompleteListener(HciAsrOnCompleteListener onCompleteListener)
	{
		this.onCompleteListener = onCompleteListener;
	}

	/**
	 * <p>
	 * �ν��� �ܾ� ����� �����մϴ�. ASR���� �ν��� �ܾ�� ����� ������ �ɺ��� ������ �� �ֽ��ϴ�.
	 * </p>
	 * <p>
	 * <b>��!</b> �νĴܾ�� �ɺ����� ������ ���� �� ������ <b>�νĴܾ�� ,(�޸�)�� ;(�����ݷ�)</b>�� �ʼ��Դϴ�.
	 * �ɺ��� �Է����� ���� ��� ������� �ɺ��� �νĴܾ ��ȯ�մϴ�.
	 * </p>
	 * 
	 * <p>
	 * <blockquote>
	 * 
	 * <pre>
	 *  
	 * ����: �νĴܾ�1,�ɺ�1;�νĴܾ�2,�ɺ�2;  ...
	 * ��) ȫ�浿,01012345678;�������,;��ö��,;
	 * </pre>
	 * 
	 * </blockquote>
	 * </p>
	 * 
	 * @param words
	 *            �ν��� �ܾ� ���
	 */
	public void setWords(String words)
	{
		this.words = words;
	}

	/**
	 * ���� �ν��� �����մϴ�.
	 */
	public void start()
	{
		ASRThread thread = new ASRThread("ASR", words, audioByteArray, onCompleteListener);
		threadHashcode = thread.hashCode();
		thread.start();
	}
}
