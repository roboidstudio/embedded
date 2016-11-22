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

/**
 * @author Tae-hoon Kim
 * @see ASRAction
 */
public class HciAsrResult
{
	/** error code enum */
	public static enum HciAsrErrorCode
	{
		ASR_SVC_DATA_FAILED,

		ASR_SVC_DATA_INITIALIZE_FAILED,

		ASR_SVC_RECG_OPEN_FAILED,

		ASR_SVC_RECG_PROC_FAILED,
		ASR_SVC_RECG_RJCT_FAILED,
		ASR_SVC_RECG_WLST_FAILED,
		ASR_SVC_RECOG_FAILED,
		/** EPD extraction failed */
		EPD_FAILED,
		/** Recognition failed */
		RECOGNIZE_FAILED,
		/** Success */
		SUCCESS,

		/** Other reason (Ex. Socket error) */
		UNKNOWN_FAILED;

	}

	/** error code */
	final public HciAsrErrorCode errorCode;

	/**
	 * <code>true</code> if recognition is succeeded
	 * <code>false</code> if failed
	 */
	final public boolean isSuccess;

	/** recognized word */
	final public String recogText;

	/** recognition score */
	final public double score;

	/** symbol of a word */
	final public String symbolText;

	/**
	 * Recognition result
	 * 
	 * @param errorCode
	 *            error code
	 * @param recogText
	 *            recognized word
	 * @param symbolText
	 *            symbol of a word
	 * @param score
	 *            recognition score
	 */
	public HciAsrResult(final HciAsrErrorCode errorCode,
			final String recogText,
			final String symbolText,
			final double score)
	{
		super();
		if (errorCode.equals(HciAsrErrorCode.SUCCESS))
		{
			isSuccess = true;
		}
		else
		{
			isSuccess = false;
		}
		this.errorCode = errorCode;
		this.recogText = recogText;
		this.symbolText = symbolText;
		this.score = score;
	}

	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("isSuccess:").append(isSuccess).append(", ").append("ErrorCode:")
				.append(errorCode).append(", ").append("recogText:").append(recogText)
				.append(", ").append("SymbolText:").append(symbolText).append(", ")
				.append("Score:").append(score);
		return buffer.toString();
	}

}
