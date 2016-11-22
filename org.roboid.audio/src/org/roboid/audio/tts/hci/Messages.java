package org.roboid.audio.tts.hci;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.roboid.audio.tts.hci.messages"; //$NON-NLS-1$
	public static String HciTts_Aram;
	public static String HciTts_JongPil;
	public static String HciTts_MiJin;
	public static String HciVcMode_Cave;
	public static String HciVcMode_ChuJeok60Min;
	public static String HciVcMode_Echo;
	public static String HciVcMode_Foreigner;
	public static String HciVcMode_Ghost;
	public static String HciVcMode_Jolaman;
	public static String HciVcMode_Protoss;
	public static String HciVcMode_Robot;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
