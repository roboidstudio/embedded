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

package org.roboid.audio.tts;

/**
 * 
 * Microsoft Speech API의 나라별 언어 코드
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
public enum TtsLanguage
{
//	AFRIKAANS_SOUTH_AFRICA 	("af", "ZA", "Afrikaans(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ALBANIAN_ALBANIA 		("sq", "AL", "Albanian(Albania)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ALSATIAN_FRANCE			("gsw","FR", "Alsatian(France)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	AMHARIC_ETHIOPIA 		("am", "ET", "Amharic(Ethiopia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_ALGERIA	 		("ar", "DZ", "Arabic(Algeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_BAHRAIN			("ar", "BH", "Arabic(Bahrain)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_EGYPT			("ar", "EG", "Arabic(Egypt)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_IRAQ				("ar", "IQ", "Arabic(Iraq)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_JORDAN			("ar", "JO", "Arabic(Jordan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_KUWAIT			("ar", "KW", "Arabic(Kuwait)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_LEBANON			("ar", "LB", "Arabic(Lebanon)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_LIBYA			("ar", "LY", "Arabic(Libya)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_MOROCCO			("ar", "MA", "Arabic(Morocco)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_OMAN				("ar", "OM", "Arabic(Oman)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_QATAR			("ar", "QA", "Arabic(Qatar)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_SAUDI_ARABIA		("ar", "SA", "Arabic(Saudi Arabia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_SYRIA			("ar", "SY", "Arabic(Syria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_TUNISIA			("ar", "TN", "Arabic(Tunisia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_UAE				("ar", "AE", "Arabic(U.A.E.)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ARABIC_YEMEN			("ar", "YE", "Arabic(Yemen)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	ARABIC					("ar", "",	 Messages.TtsLanguage_Arabic), //$NON-NLS-1$ //$NON-NLS-2$
//	ARMENIAN_ARMENIA		("hy", "AM", "Armenian(Armenia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ASSAMESE_INDIA			("as", "IN", "Assamese(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	AZERI_CYRILLIC			("az", "AZ", "Azeri(Azerbaijan, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	AZERI_LATIN				("az", "AZ", "Azeri(Azerbaijan, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BASHKIR_RUSSIA 			("ba", "RU", "Bashkir(Russia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BASQUE_BASQUE			("eu", "ES", "Basque(Basque)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	BASQUE					("eu", "",	 Messages.TtsLanguage_Basque), //$NON-NLS-1$ //$NON-NLS-2$
//	BELARUSIAN_BELARUS		("be", "BY", "Belarusian(Belarus)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BENGALI_INDIA			("bn", "IN", "Bengali(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BENGALI_BANGLADESH		("bn", "BD", "Bengali(Bangladesh)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BOSNIAN_NEUTRAL			("bs", "", 	 "Bosnian"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BOSNIAN_BOSNIA_HERZEGOVINA_CYRILLIC ("bs", "BA", "Bosnian(Bosnia and Herzegovina, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BOSNIAN_BOSNIA_HERZEGOVINA_LATIN	("bs", "BA", "Bosnian(Bosnia and Herzegovina, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BRETON_FRANCE			("br", "FR", "Breton(France)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BULGARIAN_BULGARIA		("bg", "BG", "Bulgarian(Bulgaria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	BURMESE					("bur", "", "Burmese"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CATALAN_CATALAN			("ca", "ES", "Catalan(Spain)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CHEROKEE				("chr", "US", "Cherokee(United States)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	CHINESE_PEOPLES_REPUBLIC_OF_CHINA("zh", "CN", Messages.TtsLanguage_Chinese_Simplified), //$NON-NLS-1$ //$NON-NLS-2$
//	CHINESE_HONGKONG		("zh", "HK", "Chinese(Hong Kong SAR, PRC)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CHINESE_MACAU			("zh", "MO", "Chinese(Macao SAR)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CHINESE_SINGAPORE		("zh", "SG", "Chinese(Singapore)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	CHINESE_TAIWAN			("zh", "TW", Messages.TtsLanguage_Chinese_Traditional), //$NON-NLS-1$ //$NON-NLS-2$
//	CHINESE_SIMPLIFIED		("zh", "", Messages.getString("TtsLanguage.SIMPLIFIED_CHINESE")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CHINESE_TRADITIONAL		("zh", "", Messages.getString("TtsLanguage.TRADITIONAL_CHINESE")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CORSICAN_FRANCE			("co", "FR", "Corsican(France)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CROATIAN_BOSNIA_HERZEGOVINA_LATIN("hr", "BA", "Croatian(Bosnia and Herzegovina, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CROATIAN_CROATIA		("hr", "HR", "Croatian(Croatia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	CROATIAN				("hr", "", Messages.TtsLanguage_Croatian), //$NON-NLS-1$ //$NON-NLS-2$
//	CZECH_CZECH_REPUBLIC	("cs", "CZ", "Czech(Czech Republic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	CZECH					("cs", "",	 Messages.TtsLanguage_Czech), //$NON-NLS-1$ //$NON-NLS-2$
//	DANISH_DENMARK			("da", "DK", "Danish(Denmark)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	DARI_AFGHANISTAN		("prs", "AF", "Dari(Afghanistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	DIVEHI_MALDIVES			("dv", "MV", "Divehi(Maldives)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	DUTCH_BELGIAN			("nl", "BE", "Dutch(Belgium)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	DUTCH_NETHERLANDS		("nl", "NL", "Dutch(Netherlands)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	DUTCH					("nl", "",	 Messages.TtsLanguage_Dutch), //$NON-NLS-1$ //$NON-NLS-2$
//	EDO						("bin", "", "Edo"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_AUS				("en", "AU", "English(Australia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_BELIZE			("en", "BE", "English(Belize)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_CAN				("en", "CA", "English(Canada)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_CARIBBEAN		("en", "029", "English(Caribbean)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_HONGKONG_SAR	("en", "HK", "English(Hong kong SAR)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_INDIA			("en", "IN", "English(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_INDONESIA		("en", "ID", "English(Indonesia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_IRELAND			("en", "IE", "English(Ireland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_JAMAICA			("en", "JM", "English(Jamaica)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_MALAYSIA		("en", "MY", "English(Malaysia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_NZ				("en", "NZ", "English(New Zealand)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_PHILIPPINES		("en", "PH", "English(Philippines)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_SINGAPORE		("en", "SG", "English(Singapore)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_SOUTH_AFRICA	("en", "ZA", "English(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_TRINIDAD		("en", "TT", "English(Trinidad and Tobago)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_UK				("en", "GB", "English(United Kingdom)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_US				("en", "US", "English(United States)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ENGLISH_ZIMBABWE		("en", "ZW", "English(Zimbabwe)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	ENGLISH					("en", "",	 Messages.TtsLanguage_English), //$NON-NLS-1$ //$NON-NLS-2$
//	ESTONIAN_ESTONIA		("et", "EE", "Estonian(Estonia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FAEROESE_FAROE_ISLANDS	("fo", "FO", "Faroese(Faroe Islands)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FILIPINO_PHILIPPINES	("fil", "PH", "Filipino(Philippines)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FINNISH_FINLAND			("fi", "FI", "Finnish(Finland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	FINNISH					("fi", "",	 Messages.TtsLanguage_Finnish), //$NON-NLS-1$ //$NON-NLS-2$
//	FRENCH_BELGIAN			("fr", "BE", "French(Belgium)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_CAMEROON			("fr", "CM", "French(Cameroon)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_CANADIAN			("fr", "CA", "French(Canada)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_COTE_DIVOIRE		("fr", "CI", "French(Cote d'Ivoire)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_DEMOCRATIC_REP_OF_CONGO("fr", "CG", "French(Congo)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_HAITI			("fr", "HT", "French(Haiti)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_FRANCE			("fr", "FR", "French(France)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_LUXEMBOURG		("fr", "LU", "French(Luxembourg)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_MALI				("fr", "ML", "French(Mali)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_MONACO			("fr", "MC", "French(Monaco)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_MOROCCO			("fr", "MA", "French(Morocco)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_NORTH_AFRICA		("fr", "",   "French(North Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_REUNION			("fr", "",	 "French(Reunion)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_SENEGAL			("fr", "SN", "French(Senegal)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_SWISS			("fr", "CH", "French(Switzerland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FRENCH_WEST_INDIES		("fr", "",	 "French(West Indies)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	FRENCH					("fr", "",	 Messages.TtsLanguage_French), //$NON-NLS-1$ //$NON-NLS-2$
//	FRISIAN_NETHERLANDS		("fy", "NL", "Frisian(Netherlands)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	FULFULDE_NIGERIA		("ff", "NG", "Fulfulde(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GALICIAN_GALICIAN		("gl", "ES", "Galician(Spain)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GEORGIAN_GEORGIA		("ka", "GE", "Georgian(Georgia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GERMAN_AUSTRIAN			("de", "AT", "German(Austria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GERMAN_GERMANY			("de", "DE", "German(Germany)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GERMAN_LIECHTENSTEIN	("de", "LI", "German(Liechtenstein)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GERMAN_LUXEMBOURG		("de", "LU", "German(Luxembourg)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GERMAN_SWISS			("de", "CH", "German(Switzerland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	GERMAN					("de", "",	 Messages.TtsLanguage_German), //$NON-NLS-1$ //$NON-NLS-2$
//	GREEK_GREECE			("el", "GR", "Greek(Greece)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	GREEK					("el", "",	 Messages.TtsLanguage_Greek), //$NON-NLS-1$ //$NON-NLS-2$
//	GUARANI_PARAGUAY		("gn", "PY", "Guarani(Paraguay)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GREENLANDIC_GREENLAND	("kl", "GL", "Greenlandic(Greenland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GUJARATI_INDIA			("gu", "IN", "Gujarati(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	HAUSA_NIGERIA_LATIN		("ha", "NG", "Hausa(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	HAWAIIAN_US				("haw", "US", "Hwaiian(United States)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	HEBREW_ISRAEL			("he", "IL", "Hebrew(Israel)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	HEBREW					("he", "",	 Messages.TtsLanguage_Hebrew), //$NON-NLS-1$ //$NON-NLS-2$
//	HINDI_INDIA				("hi", "IN", "Hindi(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	HUNGARIAN_HUNGARY		("hu", "HU", "Hungarian(Hungary)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	HUNGARIAN				("hu", "",	 Messages.TtsLanguage_Hungarian), //$NON-NLS-1$ //$NON-NLS-2$
//	IBIBIO_NIGERIA			("bnt", "NG", "Ibibio(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ICELANDIC_ICELAND		("is", "IS", "Icelandic(Iceland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	IGBO_NIGERIA			("ig", "NG", "Igbo(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	INDONESIAN_INDONESIA	("id", "ID", "Indonesian(Indonesia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	INUKTITUT_CANADA_LATIN	("iu", "CA", "Inuktitut(Canada (CA), Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	INUKTITUT_CANADA		("iu", "CA", "Inuktitut(Canada (CA), Canadian Syllabics)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	IRISH_IRELAND			("ga", "IE", "Irish(Ireland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	GAELIC_SCOTLAND			("gd", "UK", "Gaelic(Scotland, UK)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	XHOSA_SOUTH_AFRICA		("xh", "ZA", "isiXhosa(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ZULU_SOUTH_AFRICA		("zu", "ZA", "isiZulu(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ITALIAN_ITALY			("it", "IT", "Italian(Italy)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ITALIAN_SWISS			("it", "CH", "Italian(Switzerland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	ITALIAN					("it", "",	 Messages.TtsLanguage_Italian), //$NON-NLS-1$ //$NON-NLS-2$
//	JAPANESE_JAPAN			("ja", "JP", "Japanese(Japan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	JAPANESE				("ja", "",	 Messages.TtsLanguage_Japanese), //$NON-NLS-1$ //$NON-NLS-2$
//	KANNADA_INDIA			("kn", "IN", "Kannada(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KANURI_NIGERIA			("kr", "NG", "Kanuri(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KASHMIRI				("ks", "",   "Kashmiri"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KASHMIRI_ARABIC			("ks", "",   "Kashmiri(Arabic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KAZAK_KAZAKHSTAN		("kk", "KZ", "Kazakh(Kazakhstan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KHMER_CAMBODIA			("kh", "KH", "Khmer(Cambodia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KONKANI					("kok", "",  "Konkani"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KICHE_GUATEMALA			("qut", "GT", "K'iche(Guatemala)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KINYARWANDA_RWANDA		("rw", "RW", "Kinyarwanda(Rwanda)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KONKANI_INDIA			("kok", "IN", "Konkani(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	KOREAN_KOREA			("ko", "KR", "Korean(Korea)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	KOREAN					("ko", "",	 Messages.TtsLanguage_Korean), //$NON-NLS-1$ //$NON-NLS-2$
//	KYRGYZ_KYRGYZSTAN		("ky", "KG", "Kyrgyz(Kyrgyzstan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LAO_LAO					("lo", "LA", "Lao(Lao PDR)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LATIN					("la", "",	 "Latin"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LATVIAN_LATVIA			("lv", "LV", "Latvian(Latvia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LITHUANIAN_LITHUANIA	("lt", "LT", "Lithuanian(Lithuanian)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LOWER_SORBIAN_GERMANY	("dsb", "DE", "Lower Sorbian(Germany)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	LUXEMBOURGISH_LUXEMBOURG("lb", "LU", "Luxembourgish(Luxembourg)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MACEDONIAN_MACEDONIA	("mk", "MK", "Macedonian(Macedonia, FYROM)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MALAY_BRUNEI_DARUSSALAM	("ms", "BN", "Malay(Brunei Darassalam)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MALAY_MALAYSIA			("ms", "MY", "Malay(Malaysia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MALAYALAM_INDIA			("ml", "IN", "Malayalam(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MALTESE_MALTA			("mt", "MT", "Maltese(Malta)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MANIPURI				("mni", "",  "Manipuri"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MAORI_NEW_ZEALAND		("mi", "NZ", "Maori(New Zealand)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MAPUDUNGUN_CHILE		("arn", "CL", "Mapudungun(Chile)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MARATHI_INDIA			("mr", "IN", "Marathi(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MOHAWK_MOHAWK			("moh", "CA", "Mohawk(Canada)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MONGOLIAN_CYRILLIC_MONGOLIA("mn", "MN", "Mongolian(Mongolia, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	MONGOLIAN_PRC			("mn", "MN", "Mongolian(Mongolia, Mong)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	NEPALI_NEPAL			("ne", "NP", "Nepali(Nepal)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	NEPALI_INDIA			("ne", "IN", "Nepali(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	NORWEGIAN_BOKMAL		("no", "NO", "Norwegian(Bokmal, Norway)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	NORWEGIAN_NYNORSK		("no", "NO", "Norwegian(Nynorsk, Norway)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	NORWEGIAN				("no", "",	 Messages.TtsLanguage_Norwegian), //$NON-NLS-1$ //$NON-NLS-2$
//	OCCITAN_FRANCE			("oc", "FR", "Occitan(France)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ORIYA_INDIA				("or", "IN", "Oriya(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	OROMO					("om", "",   "Oromo"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	PAPIAMENTU				("pap", "",  "Papiamentu"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	PASHTO_AFGHANISTAN		("ps", "AF", "Pashto(Afghanistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	PERSIAN_IRAN			("fa", "IR", "Persian(Iran)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	POLISH_POLAND			("pl", "PL", "Polish(Poland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	POLISH					("pl", "",	 Messages.TtsLanguage_Polish), //$NON-NLS-1$ //$NON-NLS-2$
//	PORTUGUESE_BRAZILIAN	("pt", "BR", "Portuguese(Brazil)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	PORTUGUESE_PORTUGAL		("pt", "PT", "Portuguese(Portugal)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	PORTUGUESE				("pt", "",	 Messages.TtsLanguage_Portuguese), //$NON-NLS-1$ //$NON-NLS-2$
//	PUNJABI_INDIA			("pa", "IN", "Punjabi(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	PUNJABI_PAKISTAN		("pa", "PK", "Punjabi(Pakistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	QUECHUA_BOLIVIA			("quz", "BO", "Quechua(Bolivia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	QUECHUA_ECUADOR			("quz", "EC", "Quechua(Ecuador)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	QUECHUA_PERU			("quz", "PE", "Quechua(Peru)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ROMANIAN_ROMANIA		("ro", "RO", "Romanian(Romania)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	ROMANIAN_MOLDOVA		("ro", "MD", "Romanian(Moldova)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	ROMANIAN				("ro", "",	 Messages.TtsLanguage_Romanian), //$NON-NLS-1$ //$NON-NLS-2$
//	ROMANSH_SWITZERLAND		("rm", "CH", "Romansh(Switzerland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	RUSSIAN_RUSSIA			("ru", "RU", "Russian(Russia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	RUSSIAN_MOLDOVA			("ru", "MD", "Russian(Moldova)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	RUSSIAN					("ru", "",	 Messages.TtsLanguage_Russian), //$NON-NLS-1$ //$NON-NLS-2$
//	SAMI_INARI_FINLAND		("smn", "FI", "Sami(Inari, Finland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_LULE_NORWAY		("smj", "NO", "Sami(Lule, Norway)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_LULE_SWEDEN		("smj", "SE", "Sami(Lule, Sweden)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_NORTHERN_FINLAND	("se", "FI", "Sami(Northern, Finland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_NORTHERN_NORWAY	("se", "NO", "Sami(Northern, Norway)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_NORTHERN_SWEDEN	("se", "SE", "Sami(Northern, Sweden)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_SKOLT_FINLAND		("sms", "FI", "Sami(Skolt, Finland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_SOUTHERN_NORWAY	("sma", "NO", "Sami(Southern, Norway)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SAMI_SOUTHERN_SWEDEN	("sma", "SE", "Sami(Southern, Sweden)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SANSKRIT_INDIA			("sa", "IN", "Sanskrit(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SERBIAN					("sr", "", "Serbian"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SERBIAN_BOSNIA_HERZEGOVINA_CYRILLIC("sr", "BA", "Serbian(Bosnia and Herzegovina, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SERBIAN_BOSNIA_HERZEGOVINA_LATIN("sr", "BA", "Serbian(Bosnia and Herzegovina, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SERBIAN_CYRILLIC		("sr", "CS", "Serbian(Serbia and Montenegro, Former, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SERBIAN_LATIN			("sr", "CS", "Serbian(Serbia and Montenegro, Former, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SINDHI_INDIA			("sd", "IN", "Sindhi(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SINDHI_PAKISTAN			("sd", "PK", "Sindhi(Pakistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SOTHO_NORTHERN_SOUTH_AFRICA("nso", "ZA", "Sesotho sa Leboa(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TSWANA_SOUTH_AFRICA		("tn", "ZA", "Setswana(South Africa)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SINHALESE_SRI_LANKA		("si", "LK", "Sinhala(Sri Lanka)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SLOVAK_SLOVAKIA			("sk", "SK", "Slovak(Slovakia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	SLOVAK					("sk", "",  Messages.TtsLanguage_Slovak), //$NON-NLS-1$ //$NON-NLS-2$
//	SLOVENIAN_SLOVENIA		("sl", "SI", "Slovenian(Slovenia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	SLOVENIAN				("sl", "",	 Messages.TtsLanguage_Slovenian), //$NON-NLS-1$ //$NON-NLS-2$
//	SOMALI					("so", "",   "Somali"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_SPAIN_MODERN_SORT("es", "ES", "Spanish(Spain, Modern Sort)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_SPAIN_TRANDITIONAL_SORT("es", "ES", "Spanish(Spain, Traditional Sort)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_ARGENTINA		("es", "AR", "Spanish(Argentina)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_BOLIVIA			("es", "BO", "Spanish(Bolivia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_CHILE			("es", "CL", "Spanish(Chile)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_COLOMBIA		("es", "CO", "Spanish(Colombia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_COSTA_RICA		("es", "CR", "Spanish(Costa Rica)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_DOMINICAN_REPUBLIC("es", "DO", "Spanish(Dominican Republic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_ECUADOR			("es", "EC", "Spanish(Ecuador)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_EL_SALVADOR		("es", "SV", "Spanish(El Salvador)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_GUATEMALA		("es", "GT", "Spanish(Guatemala)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_HONDURAS		("es", "HN", "Spanish(Honduras)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_LATIN_AMERICA	("es", "",	 "Spanish(Latin America)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_MEXICAN			("es", "MX", "Spanish(Mexico)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_NICARAGUA		("es", "NI", "Spanish(Nicaragua)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_PANAMA			("es", "PA", "Spanish(Panama)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_PARAGUAY		("es", "PY", "Spanish(Paraguay)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_PERU			("es", "PE", "Spanish(Peru)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_PUERTO_RICO		("es", "PR", "Spanish(Puerto Rico)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_US				("es", "US", "Spanish(United States)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_URUGUAY			("es", "UY", "Spanish(Uruguay)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SPANISH_VENEZUELA		("es", "VE", "Spanish(Venezuela)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	SPANISH					("es", "",	 Messages.TtsLanguage_Spanish), //$NON-NLS-1$ //$NON-NLS-2$
//	SUTU					("sx", "",	 "Sutu"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SWAHILI					("sw", "KE", "Swahili(Kenya)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SWEDISH_FINLAND			("sv", "FI", "Swedish(Finland)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SWEDISH_SWEDEN			("sv", "SE", "Swedish(Sweden)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	SWEDISH					("sv", "",	 Messages.TtsLanguage_Swedish), //$NON-NLS-1$ //$NON-NLS-2$
//	SYRIAC					("syr", "SY", "Syriac(Syria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TAJIK_TAJIKISTAN		("tg", "TJ", "Tajik(Tajikistan, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TAMAZIGHT_ARABIC		("tzm", "",   "Tamazight(Arabic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TAMAZIGHT_ALGERIA_LATIN	("tzm", "DZ", "Tamazight(Algeria, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TAMIL_INDIA				("ta", "IN", "Tamil(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TATAR_RUSSIA			("tt", "RU", "Tatar(Russia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TELUGU_INDIA			("te", "IN", "Telugu(India)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	THAI_THAILAND			("th", "TH", "Thai(Thailand)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	THAI					("th", "",	 Messages.TtsLanguage_Thai), //$NON-NLS-1$ //$NON-NLS-2$
//	TIBETAN_BHUTAN			("bo", "BT", "Tibetan(Bhutan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TIBETAN_PRC				("bo", "CN", "Tibetan(PRC)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TIGRIGNA_ERITREA		("ti", "ER", "Tigrigna(Eritrea)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TIGRIGNA_ETHIOPIA		("ti", "ET", "Tigrigna(Ethiopia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TSONGA					("ts", "",   "Tsonga"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	TURKISH_TURKEY			("tr", "TR", "Turkish(Turkey)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	TURKISH					("tr", "",	 Messages.TtsLanguage_Turkish), //$NON-NLS-1$ //$NON-NLS-2$
//	TURKMEN_TURKMENISTAN	("tk", "TM", "Turkmen(Turkmenistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UKRAINIAN_UKRAINE		("uk", "UA", "Ukrainian(Ukraine)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UPPER_SORBIAN_GERMANY	("hsb", "DE", "Upper Sorbia(Germany)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	URDU_INDIA				("ur", "", "Urdu"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	URDU_PAKISTAN			("ur", "PK", "Urdu(Pakistan)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UIGHUR_PRC				("ug", "CN", "Uyghur(PRC)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UZBEK_CYRILLIC			("uz", "UZ", "Uzbek(Uzbekistan, Cyrillic)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UZBEK_LATIN				("uz", "UZ", "Uzbek(Uzbekistan, Latin)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	VENDA					("ve", "", "Venda"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	VIETNAMESE_VIETNAM		("vi", "VN", "Vietnamese(Vietnam)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	WELSH_UNITED_KINGDOM	("cy", "GB", "Welsh(United Kingdom)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	WOLOF_SENEGA			("wo", "SN", "Wolof(Senegal)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	YAKUT_RUSSIA			("sah", "RU", "Yakut(Russia)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	YI_PRC					("ii", "CN", "Yi(PRC)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	YIDDISH					("yi", "", "Yiddish"),		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	YORUBA_NIGERIA			("yo", "NG", "Yoruba(Nigeria)"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	
	/** 특수 용도 **/
//	CUSTOM_DEFAULT			("", "", "Default custom locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	UI_CUSTOM_DEFAULT		("", "", "Default custom MUI locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	INVARIANT				("", "", "Invariant locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	NEUTRAL					("", "", "Neutral locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	SYS_DEFAULT				("", "", "System default locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	CUSTOM_UNSPECIFIED		("", "", "Unspecified custom locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//	USER_DEFAULT			("", "", "User default locale language"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	UNKNOWN					("", "", Messages.TtsLanguage_Unknown); //$NON-NLS-1$ //$NON-NLS-2$

	private String language;
	private String country;
	private String name;
	
	TtsLanguage(String language, String country, String name)
	{
		this.language = language;
		this.country = country;
		this.name = name;
	}
	
	public String getLanguage()
	{
		return language;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getId()
	{
		if(country.equals("")) //$NON-NLS-1$
			return language;
		return language + "-" + country; //$NON-NLS-1$
	}
	
	public static TtsLanguage findByLanguage(String language)
	{
		for(TtsLanguage lang : values())
		{
			if(lang.getLanguage().equalsIgnoreCase(language))
				return lang;
		}
		return UNKNOWN;
	}
	
	public static TtsLanguage findById(String id)
	{
		id = id.replace('_', '-');

		// '-' 없이 language 값만 있다.
		if(id.indexOf('-') < 0)
			return findByLanguage(id);
		
		// '-'를 포함한 전체 코드를 비교한다.
		for(TtsLanguage lang : values())
		{
			if(lang.getId().equalsIgnoreCase(id))
				return lang;
		}
		
		// 전체 코드가 같은 것이 없으면 language 값이 같은 것을 찾는다.
		id = id.substring(0, id.indexOf('-'));
		return findByLanguage(id);
	}
	
	public static String getNameById(String id)
	{
		return findById(id).getName();
	}
}
