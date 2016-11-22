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
 * 목소리에 대한 정보를 나타내는 클래스
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsVoice
{
	/**
	 * 목소리의 나이를 나타내는 enum
	 * 
	 * @author 김태훈
	 */
	public enum Age
	{
		/**
	     * Age roughly up to 12 years.
	     */
		CHILD,
		/**
	     * Age roughly 13 to 19 years.
	     */
		TEENAGER,
		/**
	     * Age roughly 20 to 39 years.
	     */
		YOUNGER_ADULT,
		/**
	     * Age roughly 40 to 59 years.
	     */
		MIDDLE_ADULT,
		/**
	     * Age roughly 60 years and up.
	     */
		OLDER_ADULT,
		/**
	     * An Age that is indeterminate.
	     */
		INDETERMINATE,
		/**
	     * Matches against any Age.
	     */
		DONT_CARE
	}

	/**
	 * 목소리의 성별을 나타내는 enum
	 * 
	 * @author 김태훈
	 */
	public enum Gender
	{
		/**
	     * Male.
	     */
		MALE,
		/**
	     * Female.
	     */
		FEMALE,
		/**
	     * Neutral such as a robot or artificial.
	     */
		NEUTRAL,
		/**
	     * Match against all other genders.
	     */
		DONT_CARE
	}

	/**
	 * 말하는 스타일을 나타내는 enum
	 * 
	 * @author 김태훈
	 */
	public enum Style
	{
		/**
	     * Standard style.
	     */
		STANDARD,
		/**
	     * Matches against any style.
	     */
		DONT_CARE
	}

	/**
	 * 해당 목소리가 특정 영역에 사용하도록 특화되어 있는지를 나타내는 enum
	 * 
	 * @author 김태훈
	 */
	public enum Domain
	{
		/**
	     * General purpose.
	     */
		GENERAL,
		/**
		 * Specified to speak time.
		 */
		TIME,
		/**
	     * Matches against any domain.
	     */
		DONT_CARE
	}

	private AbstractTts engine;
	private String voiceId;
	private String voiceName;
	private TtsLanguage language;
	private Age age = Age.DONT_CARE;
	private Gender gender = Gender.DONT_CARE;
	private Style style = Style.STANDARD;
	private Domain domain = Domain.GENERAL;

	/**
	 * 새로운 Voice 객체를 생성합니다
	 * 
	 * @param engine
	 *            TTS 엔진
	 * @param voiceId
	 *            목소리 ID (TTS 엔진용)
	 * @param voiceName
	 *            목소리 이름 (화면 출력용)
	 * @param language
	 *            언어
	 * @param age
	 *            목소리의 연령대
	 * @param gender
	 *            목소리의 성별
	 * @param style
	 *            대화 스타일
	 * @param domain
	 *            목소리가 제한된 영역(limited domain)에서 사용하는지 아니면 일반적으로 사용하는 TTS인지를 나타내는 정보
	 */
	public TtsVoice(AbstractTts engine,
			String voiceId,
			String voiceName,
			TtsLanguage language,
			Age age,
			Gender gender,
			Style style,
			Domain domain)
	{
		super();
		this.engine = engine;
		this.voiceId = voiceId;
		this.voiceName = voiceName;
		this.language = language;
		this.age = age;
		this.gender = gender;
		this.style = style;
		this.domain = domain;
	}

	public AbstractTts getEngine()
	{
		return engine;
	}
	
	public String getVoiceId()
	{
		return voiceId;
	}
	
	public String getVoiceName()
	{
		return voiceName;
	}
	
	public TtsLanguage getLanguage()
	{
		return language;
	}
	
	public Age getAge()
	{
		return age;
	}

	public Gender getGender()
	{
		return gender;
	}
	
	public Style getStyle()
	{
		return style;
	}

	public Domain getDomain()
	{
		return domain;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("engine:")
				.append(engine)
				.append(", voice:")
				.append(voiceName)
				.append("(")
				.append(voiceId)
				.append("), language:")
				.append(language.getName())
				.append("(")
				.append(language.getId())
				.append("), age:")
				.append(age.name())
				.append(", gender:")
				.append(gender.name())
				.append(", style:")
				.append(style.name())
				.append(", domain:")
				.append(domain.name());
		return sb.toString();
	}

	public boolean isAccepted(TtsVoice filter)
	{
		if(filter.engine != null && !filter.engine.equals(this.engine)) return false;
		if(filter.voiceId != null && !filter.voiceId.equalsIgnoreCase(this.voiceId)) return false;
		if(filter.voiceName != null && !filter.voiceName.equals(this.voiceName)) return false;
		if(filter.language != null && !filter.language.equals(this.language)) return false;
		if(filter.age != null && !filter.age.equals(this.age)) return false;
		if(filter.gender != null && !filter.gender.equals(this.gender)) return false;
		if(filter.style != null && !filter.style.equals(this.style)) return false;
		if(filter.domain != null && !filter.domain.equals(this.domain)) return false;
		
		return true;
	}
}
