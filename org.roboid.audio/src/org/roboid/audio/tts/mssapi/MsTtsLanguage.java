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

package org.roboid.audio.tts.mssapi;

import org.roboid.audio.tts.TtsLanguage;

/**
 * 
 * Microsoft Speech API�� ���� ��� �ڵ�
 * 
 * <p><strong>references</strong></p>
 * <ul>
 * <li><a href=http://msdn.microsoft.com/en-us/library/dd318693(VS.85).aspx>http://msdn.microsoft.com/en-us/library/dd318693(VS.85).aspx</a></li>
 * <li><a href=http://www.loc.gov/standards/iso639-2/php/code_list.php>http://www.loc.gov/standards/iso639-2/php/code_list.php</a></li>
 * <li><a href=http://www.iso.org/iso/country_codes/iso_3166_code_lists/english_country_names_and_code_elements.htm>http://www.iso.org/iso/country_codes/iso_3166_code_lists/english_country_names_and_code_elements.htm</a></li>
 * <li><a href=http://msdn.microsoft.com/en-us/goglobal/bb964664.aspx>http://msdn.microsoft.com/en-us/goglobal/bb964664.aspx</a></li>
 * </ul>
 * 
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public enum MsTtsLanguage
{
//	AFRIKAANS_SOUTH_AFRICA 	(0x0436, TtsLanguage.AFRIKAANS_SOUTH_AFRICA),
//	ALBANIAN_ALBANIA 		(0x041C, TtsLanguage.ALBANIAN_ALBANIA),
//	ALSATIAN_FRANCE			(0x0484, TtsLanguage.ALSATIAN_FRANCE),
//	AMHARIC_ETHIOPIA 		(0x045E, TtsLanguage.AMHARIC_ETHIOPIA),
	ARABIC_ALGERIA	 		(0x1401, TtsLanguage.ARABIC),
	ARABIC_BAHRAIN			(0x3C01, TtsLanguage.ARABIC),
	ARABIC_EGYPT			(0x0C01, TtsLanguage.ARABIC),
	ARABIC_IRAQ				(0x0801, TtsLanguage.ARABIC),
	ARABIC_JORDAN			(0x2C01, TtsLanguage.ARABIC),
	ARABIC_KUWAIT			(0x3401, TtsLanguage.ARABIC),
	ARABIC_LEBANON			(0x3001, TtsLanguage.ARABIC),
	ARABIC_LIBYA			(0x1001, TtsLanguage.ARABIC),
	ARABIC_MOROCCO			(0x1801, TtsLanguage.ARABIC),
	ARABIC_OMAN				(0x2001, TtsLanguage.ARABIC),
	ARABIC_QATAR			(0x4001, TtsLanguage.ARABIC),
	ARABIC_SAUDI_ARABIA		(0x0401, TtsLanguage.ARABIC),
	ARABIC_SYRIA			(0x2801, TtsLanguage.ARABIC),
	ARABIC_TUNISIA			(0x1C01, TtsLanguage.ARABIC),
	ARABIC_UAE				(0x3801, TtsLanguage.ARABIC),
	ARABIC_YEMEN			(0x2401, TtsLanguage.ARABIC),
//	ARMENIAN_ARMENIA		(0x042B, TtsLanguage.ARMENIAN_ARMENIA),
//	ASSAMESE_INDIA			(0x044D, TtsLanguage.ASSAMESE_INDIA),
//	AZERI_CYRILLIC			(0x082C, TtsLanguage.AZERI_CYRILLIC),
//	AZERI_LATIN				(0x042C, TtsLanguage.AZERI_LATIN),
//	BASHKIR_RUSSIA 			(0x046D, TtsLanguage.BASHKIR_RUSSIA),
	BASQUE_BASQUE			(0x042D, TtsLanguage.BASQUE),
//	BELARUSIAN_BELARUS		(0x0423, TtsLanguage.BELARUSIAN_BELARUS),
//	BENGALI_INDIA			(0x0445, TtsLanguage.BENGALI_INDIA),
//	BENGALI_BANGLADESH		(0x0845, TtsLanguage.BENGALI_BANGLADESH),
//	BOSNIAN_NEUTRAL			(0x781A, TtsLanguage.BOSNIAN_NEUTRAL),
//	BOSNIAN_BOSNIA_HERZEGOVINA_CYRILLIC (0x201A, TtsLanguage.BOSNIAN_BOSNIA_HERZEGOVINA_CYRILLIC),
//	BOSNIAN_BOSNIA_HERZEGOVINA_LATIN	(0x141A, TtsLanguage.BOSNIAN_BOSNIA_HERZEGOVINA_LATIN),
//	BRETON_FRANCE			(0x047E, TtsLanguage.BRETON_FRANCE),
//	BULGARIAN_BULGARIA		(0x0402, TtsLanguage.BULGARIAN_BULGARIA),
//	BURMESE					(0x0455, TtsLanguage.BURMESE),
//	CATALAN_CATALAN			(0x0403, TtsLanguage.CATALAN_CATALAN),
//	CHEROKEE				(0x045C, TtsLanguage.CHEROKEE),
	CHINESE_PEOPLES_REPUBLIC_OF_CHINA(0x0804, TtsLanguage.CHINESE_PEOPLES_REPUBLIC_OF_CHINA),
	CHINESE_HONGKONG		(0x0C04, TtsLanguage.CHINESE_PEOPLES_REPUBLIC_OF_CHINA),
	CHINESE_MACAU			(0x1404, TtsLanguage.CHINESE_PEOPLES_REPUBLIC_OF_CHINA),
	CHINESE_SINGAPORE		(0x1004, TtsLanguage.CHINESE_PEOPLES_REPUBLIC_OF_CHINA),
	CHINESE_TAIWAN			(0x0404, TtsLanguage.CHINESE_TAIWAN),
	CHINESE_SIMPLIFIED		(0x0004, TtsLanguage.CHINESE_PEOPLES_REPUBLIC_OF_CHINA),
	CHINESE_TRADITIONAL		(0x7C04, TtsLanguage.CHINESE_TAIWAN),
//	CORSICAN_FRANCE			(0x0483, TtsLanguage.CORSICAN_FRANCE),
//	CROATIAN				(0x001A, TtsLanguage.CROATIAN),
//	CROATIAN_BOSNIA_HERZEGOVINA_LATIN(0x101A, TtsLanguage.CROATIAN),
//	CROATIAN_CROATIA		(0x041A, TtsLanguage.CROATIAN),
	CZECH_CZECH_REPUBLIC	(0x0405, TtsLanguage.CZECH),
//	DANISH_DENMARK			(0x0406, TtsLanguage.DANISH_DENMARK),
//	DARI_AFGHANISTAN		(0x048C, TtsLanguage.DARI_AFGHANISTAN),
//	DIVEHI_MALDIVES			(0x0465, TtsLanguage.DIVEHI_MALDIVES),
	DUTCH_BELGIAN			(0x0813, TtsLanguage.DUTCH),
	DUTCH					(0x0413, TtsLanguage.DUTCH),
//	EDO						(0x0466, TtsLanguage.EDO),
	ENGLISH_AUS				(0x0C09, TtsLanguage.ENGLISH),
	ENGLISH_BELIZE			(0x2809, TtsLanguage.ENGLISH),
	ENGLISH_CAN				(0x1009, TtsLanguage.ENGLISH),
	ENGLISH_CARIBBEAN		(0x2409, TtsLanguage.ENGLISH),
	ENGLISH_HONGKONG_SAR	(0x3C09, TtsLanguage.ENGLISH),
	ENGLISH_INDIA			(0x4009, TtsLanguage.ENGLISH),
	ENGLISH_INDONESIA		(0x3809, TtsLanguage.ENGLISH),
	ENGLISH_IRELAND			(0x1809, TtsLanguage.ENGLISH),
	ENGLISH_JAMAICA			(0x2009, TtsLanguage.ENGLISH),
	ENGLISH_MALAYSIA		(0x4409, TtsLanguage.ENGLISH),
	ENGLISH_NZ				(0x1409, TtsLanguage.ENGLISH),
	ENGLISH_PHILIPPINES		(0x3409, TtsLanguage.ENGLISH),
	ENGLISH_SINGAPORE		(0x4809, TtsLanguage.ENGLISH),
	ENGLISH_SOUTH_AFRICA	(0x1c09, TtsLanguage.ENGLISH),
	ENGLISH_TRINIDAD		(0x2C09, TtsLanguage.ENGLISH),
	ENGLISH_UK				(0x0809, TtsLanguage.ENGLISH),
	ENGLISH_US				(0x0409, TtsLanguage.ENGLISH),
	ENGLISH_ZIMBABWE		(0x3009, TtsLanguage.ENGLISH),
//	ESTONIAN_ESTONIA		(0x0425, TtsLanguage.ESTONIAN_ESTONIA),
//	FAEROESE_FAROE_ISLANDS	(0x0438, TtsLanguage.FAEROESE_FAROE_ISLANDS),
//	FILIPINO_PHILIPPINES	(0x0464, TtsLanguage.FILIPINO_PHILIPPINES),
	FINNISH_FINLAND			(0x040B, TtsLanguage.FINNISH),
	FRENCH_BELGIAN			(0x080c, TtsLanguage.FRENCH),
	FRENCH_CAMEROON			(0x2C0C, TtsLanguage.FRENCH),
	FRENCH_CANADIAN			(0x0C0C, TtsLanguage.FRENCH),
	FRENCH_COTE_DIVOIRE		(0x300C, TtsLanguage.FRENCH),
	FRENCH_DEMOCRATIC_REP_OF_CONGO(0x240C, TtsLanguage.FRENCH),
	FRENCH_HAITI			(0x3C0C, TtsLanguage.FRENCH),
	FRENCH					(0x040c, TtsLanguage.FRENCH),
	FRENCH_LUXEMBOURG		(0x140C, TtsLanguage.FRENCH),
	FRENCH_MALI				(0x340C, TtsLanguage.FRENCH),
	FRENCH_MONACO			(0x180C, TtsLanguage.FRENCH),
	FRENCH_MOROCCO			(0x380C, TtsLanguage.FRENCH),
	FRENCH_NORTH_AFRICA		(0xE40C, TtsLanguage.FRENCH),
	FRENCH_REUNION			(0x200C, TtsLanguage.FRENCH),
	FRENCH_SENEGAL			(0x280C, TtsLanguage.FRENCH),
	FRENCH_SWISS			(0x100C, TtsLanguage.FRENCH),
	FRENCH_WEST_INDIES		(0x1C0C, TtsLanguage.FRENCH),
//	FRISIAN_NETHERLANDS		(0x0462, TtsLanguage.FRISIAN_NETHERLANDS),
//	FULFULDE_NIGERIA		(0x0467, TtsLanguage.FULFULDE_NIGERIA),
//	GALICIAN_GALICIAN		(0x0456, TtsLanguage.GALICIAN_GALICIAN),
//	GEORGIAN_GEORGIA		(0x0437, TtsLanguage.GEORGIAN_GEORGIA),
	GERMAN_AUSTRIAN			(0x0C07, TtsLanguage.GERMAN),
	GERMAN					(0x0407, TtsLanguage.GERMAN),
	GERMAN_LIECHTENSTEIN	(0x1407, TtsLanguage.GERMAN),
	GERMAN_LUXEMBOURG		(0x1007, TtsLanguage.GERMAN),
	GERMAN_SWISS			(0x0807, TtsLanguage.GERMAN),
	GREEK_GREECE			(0x0408, TtsLanguage.GREEK),
//	GUARANI_PARAGUAY		(0x0474, TtsLanguage.GUARANI_PARAGUAY),
//	GREENLANDIC_GREENLAND	(0x046F, TtsLanguage.GREENLANDIC_GREENLAND),
//	GUJARATI_INDIA			(0x0447, TtsLanguage.GUJARATI_INDIA),
//	HAUSA_NIGERIA_LATIN		(0x0468, TtsLanguage.HAUSA_NIGERIA_LATIN),
//	HAWAIIAN_US				(0x0475, TtsLanguage.HAWAIIAN_US),
	HEBREW_ISRAEL			(0x040D, TtsLanguage.HEBREW),
//	HINDI_INDIA				(0x0439, TtsLanguage.HINDI_INDIA),
	HUNGARIAN_HUNGARY		(0x040E, TtsLanguage.HUNGARIAN),
//	IBIBIO_NIGERIA			(0x0469, TtsLanguage.IBIBIO_NIGERIA),
//	ICELANDIC_ICELAND		(0x040F, TtsLanguage.ICELANDIC_ICELAND),
//	IGBO_NIGERIA			(0x0470, TtsLanguage.IGBO_NIGERIA),
//	INDONESIAN_INDONESIA	(0x0421, TtsLanguage.INDONESIAN_INDONESIA),
//	INUKTITUT_CANADA_LATIN	(0x085D, TtsLanguage.INUKTITUT_CANADA_LATIN),
//	INUKTITUT_CANADA		(0x045D, TtsLanguage.INUKTITUT_CANADA),
//	IRISH_IRELAND			(0x083C, TtsLanguage.IRISH_IRELAND),
//	GAELIC_SCOTLAND			(0x043C, TtsLanguage.GAELIC_SCOTLAND),
//	XHOSA_SOUTH_AFRICA		(0x0434, TtsLanguage.XHOSA_SOUTH_AFRICA),
//	ZULU_SOUTH_AFRICA		(0x0435, TtsLanguage.ZULU_SOUTH_AFRICA),
	ITALIAN					(0x0410, TtsLanguage.ITALIAN),
	ITALIAN_SWISS			(0x0810, TtsLanguage.ITALIAN),
	JAPANESE_JAPAN			(0x0411, TtsLanguage.JAPANESE),
//	KANNADA_INDIA			(0x044B, TtsLanguage.KANNADA_INDIA),
//	KANURI_NIGERIA			(0x0471, TtsLanguage.KANURI_NIGERIA),
//	KASHMIRI				(0x0860, TtsLanguage.KASHMIRI),
//	KASHMIRI_ARABIC			(0x0460, TtsLanguage.KASHMIRI_ARABIC),
//	KAZAK_KAZAKHSTAN		(0x043F, TtsLanguage.KAZAK_KAZAKHSTAN),
//	KHMER_CAMBODIA			(0x0453, TtsLanguage.KHMER_CAMBODIA),
//	KONKANI					(0x0457, TtsLanguage.KONKANI),
//	KICHE_GUATEMALA			(0x0486, TtsLanguage.KICHE_GUATEMALA),
//	KINYARWANDA_RWANDA		(0x0487, TtsLanguage.KINYARWANDA_RWANDA),
//	KONKANI_INDIA			(0x0457, TtsLanguage.KONKANI_INDIA),
	KOREAN					(0x0412, TtsLanguage.KOREAN),
//	KYRGYZ_KYRGYZSTAN		(0x0440, TtsLanguage.KYRGYZ_KYRGYZSTAN),
//	LAO_LAO					(0x0454, TtsLanguage.LAO_LAO),
//	LATIN					(0x0476, TtsLanguage.LATIN),
//	LATVIAN_LATVIA			(0x0426, TtsLanguage.LATVIAN_LATVIA),
//	LITHUANIAN_LITHUANIA	(0x0427, TtsLanguage.LITHUANIAN_LITHUANIA),
//	LOWER_SORBIAN_GERMANY	(0x082E, TtsLanguage.LOWER_SORBIAN_GERMANY),
//	LUXEMBOURGISH_LUXEMBOURG(0x046E, TtsLanguage.LUXEMBOURGISH_LUXEMBOURG),
//	MACEDONIAN_MACEDONIA	(0x042F, TtsLanguage.MACEDONIAN_MACEDONIA),
//	MALAY_BRUNEI_DARUSSALAM	(0x083E, TtsLanguage.MALAY_BRUNEI_DARUSSALAM),
//	MALAY_MALAYSIA			(0x043e, TtsLanguage.MALAY_MALAYSIA),
//	MALAYALAM_INDIA			(0x044C, TtsLanguage.MALAYALAM_INDIA),
//	MALTESE_MALTA			(0x043A, TtsLanguage.MALTESE_MALTA),
//	MANIPURI				(0x0458, TtsLanguage.MANIPURI),
//	MAORI_NEW_ZEALAND		(0x0481, TtsLanguage.MAORI_NEW_ZEALAND),
//	MAPUDUNGUN_CHILE		(0x047A, TtsLanguage.MAPUDUNGUN_CHILE),
//	MARATHI_INDIA			(0x044E, TtsLanguage.MARATHI_INDIA),
//	MOHAWK_MOHAWK			(0x047C, TtsLanguage.MOHAWK_MOHAWK),
//	MONGOLIAN_CYRILLIC_MONGOLIA(0x0450, TtsLanguage.MONGOLIAN_CYRILLIC_MONGOLIA),
//	MONGOLIAN_PRC			(0x0850, TtsLanguage.MONGOLIAN_PRC),
//	NEPALI_NEPAL			(0x0461, TtsLanguage.NEPALI_NEPAL),
//	NEPALI_INDIA			(0x0861, TtsLanguage.NEPALI_INDIA),
	NORWEGIAN_BOKMAL		(0x0414, TtsLanguage.NORWEGIAN),
	NORWEGIAN_NYNORSK		(0x0814, TtsLanguage.NORWEGIAN),
//	OCCITAN_FRANCE			(0x0482, TtsLanguage.OCCITAN_FRANCE),
//	ORIYA_INDIA				(0x0448, TtsLanguage.ORIYA_INDIA),
//	OROMO					(0x0472, TtsLanguage.OROMO),
//	PAPIAMENTU				(0x0479, TtsLanguage.PAPIAMENTU),
//	PASHTO_AFGHANISTAN		(0x0463, TtsLanguage.PASHTO_AFGHANISTAN),
//	PERSIAN_IRAN			(0x0429, TtsLanguage.PERSIAN_IRAN),
	POLISH_POLAND			(0x0415, TtsLanguage.POLISH),
	PORTUGUESE_BRAZILIAN	(0x0416, TtsLanguage.PORTUGUESE),
	PORTUGUESE				(0x0816, TtsLanguage.PORTUGUESE),
//	PUNJABI_INDIA			(0x0446, TtsLanguage.PUNJABI_INDIA),
//	PUNJABI_PAKISTAN		(0x0846, TtsLanguage.PUNJABI_PAKISTAN),
//	QUECHUA_BOLIVIA			(0x046B, TtsLanguage.QUECHUA_BOLIVIA),
//	QUECHUA_ECUADOR			(0x086B, TtsLanguage.QUECHUA_ECUADOR),
//	QUECHUA_PERU			(0x0C6B, TtsLanguage.QUECHUA_PERU),
	ROMANIAN_ROMANIA		(0x0418, TtsLanguage.ROMANIAN),
	ROMANIAN_MOLDOVA		(0x0818, TtsLanguage.ROMANIAN),
//	ROMANSH_SWITZERLAND		(0x0417, TtsLanguage.ROMANSH_SWITZERLAND),
	RUSSIAN_RUSSIA			(0x0419, TtsLanguage.RUSSIAN),
	RUSSIAN_MOLDOVA			(0x0819, TtsLanguage.RUSSIAN),
//	SAMI_INARI_FINLAND		(0x243B, TtsLanguage.SAMI_INARI_FINLAND),
//	SAMI_LULE_NORWAY		(0x103B, TtsLanguage.SAMI_LULE_NORWAY),
//	SAMI_LULE_SWEDEN		(0x143B, TtsLanguage.SAMI_LULE_SWEDEN),
//	SAMI_NORTHERN_FINLAND	(0x0C3B, TtsLanguage.SAMI_NORTHERN_FINLAND),
//	SAMI_NORTHERN_NORWAY	(0x043B, TtsLanguage.SAMI_NORTHERN_NORWAY),
//	SAMI_NORTHERN_SWEDEN	(0x083B, TtsLanguage.SAMI_NORTHERN_SWEDEN),
//	SAMI_SKOLT_FINLAND		(0x203B, TtsLanguage.SAMI_SKOLT_FINLAND),
//	SAMI_SOUTHERN_NORWAY	(0x183B, TtsLanguage.SAMI_SOUTHERN_NORWAY),
//	SAMI_SOUTHERN_SWEDEN	(0x1C3B, TtsLanguage.SAMI_SOUTHERN_SWEDEN),
//	SANSKRIT_INDIA			(0x044F, TtsLanguage.SANSKRIT_INDIA),
//	SERBIAN					(0x7C1A, TtsLanguage.SERBIAN),
//	SERBIAN_BOSNIA_HERZEGOVINA_CYRILLIC(0x1C1A, TtsLanguage.SERBIAN_BOSNIA_HERZEGOVINA_CYRILLIC),
//	SERBIAN_BOSNIA_HERZEGOVINA_LATIN(0x181A, TtsLanguage.SERBIAN_BOSNIA_HERZEGOVINA_LATIN),
//	SERBIAN_CYRILLIC		(0x0C1A, TtsLanguage.SERBIAN_CYRILLIC),
//	SERBIAN_LATIN			(0x081A, TtsLanguage.SERBIAN_LATIN),
//	SINDHI_INDIA			(0x0459, TtsLanguage.SINDHI_INDIA),
//	SINDHI_PAKISTAN			(0x0859, TtsLanguage.SINDHI_PAKISTAN),
//	SOTHO_NORTHERN_SOUTH_AFRICA(0x046C, TtsLanguage.SOTHO_NORTHERN_SOUTH_AFRICA),
//	TSWANA_SOUTH_AFRICA		(0x0432, TtsLanguage.TSWANA_SOUTH_AFRICA),
//	SINHALESE_SRI_LANKA		(0x045B, TtsLanguage.SINHALESE_SRI_LANKA),
	SLOVAK_SLOVAKIA			(0x041B, TtsLanguage.SLOVAK),
	SLOVENIAN_SLOVENIA		(0x0424, TtsLanguage.SLOVENIAN),
//	SOMALI					(0x0477, TtsLanguage.SOMALI),
	SPANISH_SPAIN_MODERN_SORT(0x0C0A, TtsLanguage.SPANISH),
	SPANISH_SPAIN_TRANDITIONAL_SORT(0x040A, TtsLanguage.SPANISH),
	SPANISH_ARGENTINA		(0x2C0A, TtsLanguage.SPANISH),
	SPANISH_BOLIVIA			(0x400A, TtsLanguage.SPANISH),
	SPANISH_CHILE			(0x340A, TtsLanguage.SPANISH),
	SPANISH_COLOMBIA		(0x240A, TtsLanguage.SPANISH),
	SPANISH_COSTA_RICA		(0x140A, TtsLanguage.SPANISH),
	SPANISH_DOMINICAN_REPUBLIC(0x1C0A, TtsLanguage.SPANISH),
	SPANISH_ECUADOR			(0x300A, TtsLanguage.SPANISH),
	SPANISH_EL_SALVADOR		(0x440A, TtsLanguage.SPANISH),
	SPANISH_GUATEMALA		(0x100A, TtsLanguage.SPANISH),
	SPANISH_HONDURAS		(0x480A, TtsLanguage.SPANISH),
	SPANISH_LATIN_AMERICA	(0x580A, TtsLanguage.SPANISH),
	SPANISH_MEXICAN			(0x080A, TtsLanguage.SPANISH),
	SPANISH_NICARAGUA		(0x4C0A, TtsLanguage.SPANISH),
	SPANISH_PANAMA			(0x180A, TtsLanguage.SPANISH),
	SPANISH_PARAGUAY		(0x3C0A, TtsLanguage.SPANISH),
	SPANISH_PERU			(0x280A, TtsLanguage.SPANISH),
	SPANISH_PUERTO_RICO		(0x500A, TtsLanguage.SPANISH),
	SPANISH_US				(0x540A, TtsLanguage.SPANISH),
	SPANISH_URUGUAY			(0x380A, TtsLanguage.SPANISH),
	SPANISH_VENEZUELA		(0x200A, TtsLanguage.SPANISH),
//	SUTU					(0x0430, TtsLanguage.SUTU),
//	SWAHILI					(0x0441, TtsLanguage.SWAHILI),
//	SWEDISH_FINLAND			(0x081D, TtsLanguage.SWEDISH_FINLAND),
//	SWEDISH_SWEDEN			(0x041D, TtsLanguage.SWEDISH_SWEDEN),
//	SYRIAC					(0x045A, TtsLanguage.SYRIAC),
//	TAJIK_TAJIKISTAN		(0x0428, TtsLanguage.TAJIK_TAJIKISTAN),
//	TAMAZIGHT_ARABIC		(0x045F, TtsLanguage.TAMAZIGHT_ARABIC),
//	TAMAZIGHT_ALGERIA_LATIN	(0x085F, TtsLanguage.TAMAZIGHT_ALGERIA_LATIN),
//	TAMIL_INDIA				(0x0449, TtsLanguage.TAMIL_INDIA),
//	TATAR_RUSSIA			(0x0444, TtsLanguage.TATAR_RUSSIA),
//	TELUGU_INDIA			(0x044A, TtsLanguage.TELUGU_INDIA),
	THAI_THAILAND			(0x041E, TtsLanguage.THAI),
//	TIBETAN_BHUTAN			(0x0851, TtsLanguage.TIBETAN_BHUTAN),
//	TIBETAN_PRC				(0x0451, TtsLanguage.TIBETAN_PRC),
//	TIGRIGNA_ERITREA		(0x0873, TtsLanguage.TIGRIGNA_ERITREA),
//	TIGRIGNA_ETHIOPIA		(0x0473, TtsLanguage.TIGRIGNA_ETHIOPIA),
//	TSONGA					(0x0431, TtsLanguage.TSONGA),
	TURKISH_TURKEY			(0x041F, TtsLanguage.TURKISH),
//	TURKMEN_TURKMENISTAN	(0x0442, TtsLanguage.TURKMEN_TURKMENISTAN),
//	UKRAINIAN_UKRAINE		(0x0422, TtsLanguage.UKRAINIAN_UKRAINE),
//	UPPER_SORBIAN_GERMANY	(0x042E, TtsLanguage.UPPER_SORBIAN_GERMANY),
//	URDU_INDIA				(0x0820, TtsLanguage.URDU_INDIA),
//	URDU_PAKISTAN			(0x0420, TtsLanguage.URDU_PAKISTAN),
//	UIGHUR_PRC				(0x0480, TtsLanguage.UIGHUR_PRC),
//	UZBEK_CYRILLIC			(0x0843, TtsLanguage.UZBEK_CYRILLIC),
//	UZBEK_LATIN				(0x0443, TtsLanguage.UZBEK_LATIN),
//	VENDA					(0x0433, TtsLanguage.VENDA),
//	VIETNAMESE_VIETNAM		(0x042A, TtsLanguage.VIETNAMESE_VIETNAM),
//	WELSH_UNITED_KINGDOM	(0x0452, TtsLanguage.WELSH_UNITED_KINGDOM),
//	WOLOF_SENEGA			(0x0488, TtsLanguage.WOLOF_SENEGA),
//	YAKUT_RUSSIA			(0x0485, TtsLanguage.YAKUT_RUSSIA),
//	YI_PRC					(0x0478, TtsLanguage.YI_PRC),
//	YIDDISH					(0x043d, TtsLanguage.YIDDISH),
//	YORUBA_NIGERIA			(0x046A, TtsLanguage.YORUBA_NIGERIA),
	
	/** Ư�� �뵵 **/
//	CUSTOM_DEFAULT			(0x0C00, TtsLanguage.CUSTOM_DEFAULT),
//	UI_CUSTOM_DEFAULT		(0x1400, TtsLanguage.UI_CUSTOM_DEFAULT),
//	INVARIANT				(0x007F, TtsLanguage.INVARIANT),
//	NEUTRAL					(0x0000, TtsLanguage.NEUTRAL),
//	SYS_DEFAULT				(0x0800, TtsLanguage.SYS_DEFAULT),
//	CUSTOM_UNSPECIFIED		(0x1000, TtsLanguage.CUSTOM_UNSPECIFIED),
//	USER_DEFAULT			(0x0400, TtsLanguage.USER_DEFAULT),
	UNKNOWN					(0x0000, TtsLanguage.UNKNOWN);
	
	private int id;
	private TtsLanguage ttsLanguage;
	
	MsTtsLanguage(int id, TtsLanguage ttsLanguage)
	{
		this.id = id; 
		this.ttsLanguage = ttsLanguage;
	}

	public int getId()
	{
		return id;
	}

	public TtsLanguage getTtsLanguage()
	{
		return ttsLanguage;
	}

	public static TtsLanguage getTtsLanguageById(int id)
	{
		for(MsTtsLanguage lang : values())
		{
			if(lang.getId() == id)
				return lang.getTtsLanguage();
		}
		return UNKNOWN.getTtsLanguage();
	}
}