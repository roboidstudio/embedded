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
 * ��Ҹ��� ���� ������ ��Ÿ���� Ŭ����
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class TtsVoice
{
	/**
	 * ��Ҹ��� ���̸� ��Ÿ���� enum
	 * 
	 * @author ������
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
	 * ��Ҹ��� ������ ��Ÿ���� enum
	 * 
	 * @author ������
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
	 * ���ϴ� ��Ÿ���� ��Ÿ���� enum
	 * 
	 * @author ������
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
	 * �ش� ��Ҹ��� Ư�� ������ ����ϵ��� Ưȭ�Ǿ� �ִ����� ��Ÿ���� enum
	 * 
	 * @author ������
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
	 * ���ο� Voice ��ü�� �����մϴ�
	 * 
	 * @param engine
	 *            TTS ����
	 * @param voiceId
	 *            ��Ҹ� ID (TTS ������)
	 * @param voiceName
	 *            ��Ҹ� �̸� (ȭ�� ��¿�)
	 * @param language
	 *            ���
	 * @param age
	 *            ��Ҹ��� ���ɴ�
	 * @param gender
	 *            ��Ҹ��� ����
	 * @param style
	 *            ��ȭ ��Ÿ��
	 * @param domain
	 *            ��Ҹ��� ���ѵ� ����(limited domain)���� ����ϴ��� �ƴϸ� �Ϲ������� ����ϴ� TTS������ ��Ÿ���� ����
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
