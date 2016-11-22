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

package org.roboid.studio.timeline.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.roboid.audio.AudioUtil;
import org.roboid.robot.AudioMode;
import org.roboid.studio.timeline.AudioPoint;
import org.roboid.studio.timeline.AudioTrack;
import org.roboid.studio.timeline.ControlPoint;
import org.roboid.studio.timeline.TimelineFactory;
import org.roboid.studio.timeline.TimelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Audio Point</b></em>'.
 * @author Kyoung Jin Kim
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getMp3 <em>Mp3</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getLength <em>Length</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getVoiceId <em>Voice Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getLanguageId <em>Language Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getVoiceEffectId <em>Voice Effect Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getSpeechRate <em>Speech Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getPitch <em>Pitch</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getBalance <em>Balance</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getSampleRate <em>Sample Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getSampleSizeInBits <em>Sample Size In Bits</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getFrameSize <em>Frame Size</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getFrameRate <em>Frame Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#isBigEndian <em>Big Endian</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#getPcm <em>Pcm</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.impl.AudioPointImpl#isModified <em>Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AudioPointImpl extends ControlPointImpl implements AudioPoint
{
	/**
	 * The default value of the '{@link #getMp3() <em>Mp3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMp3()
	 * @generated
	 * @ordered
	 */
	protected static final byte[] MP3_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMp3() <em>Mp3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMp3()
	 * @generated
	 * @ordered
	 */
	protected byte[] mp3 = MP3_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final int LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected int length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoiceId() <em>Voice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoiceId()
	 * @generated
	 * @ordered
	 */
	protected static final String VOICE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoiceId() <em>Voice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoiceId()
	 * @generated
	 * @ordered
	 */
	protected String voiceId = VOICE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguageId() <em>Language Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageId()
	 * @generated
	 * @ordered
	 */
	protected static final String LANGUAGE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLanguageId() <em>Language Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanguageId()
	 * @generated
	 * @ordered
	 */
	protected String languageId = LANGUAGE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVoiceEffectId() <em>Voice Effect Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoiceEffectId()
	 * @generated
	 * @ordered
	 */
	protected static final String VOICE_EFFECT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVoiceEffectId() <em>Voice Effect Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVoiceEffectId()
	 * @generated
	 * @ordered
	 */
	protected String voiceEffectId = VOICE_EFFECT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpeechRate() <em>Speech Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeechRate()
	 * @generated
	 * @ordered
	 */
	protected static final int SPEECH_RATE_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getSpeechRate() <em>Speech Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeechRate()
	 * @generated
	 * @ordered
	 */
	protected int speechRate = SPEECH_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected static final int VOLUME_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected int volume = VOLUME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected static final int PITCH_EDEFAULT = 100;

	/**
	 * The cached value of the '{@link #getPitch() <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPitch()
	 * @generated
	 * @ordered
	 */
	protected int pitch = PITCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getBalance() <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalance()
	 * @generated
	 * @ordered
	 */
	protected static final int BALANCE_EDEFAULT = 50;

	/**
	 * The cached value of the '{@link #getBalance() <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBalance()
	 * @generated
	 * @ordered
	 */
	protected int balance = BALANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCODING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEncoding() <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncoding()
	 * @generated
	 * @ordered
	 */
	protected String encoding = ENCODING_EDEFAULT;

	/**
	 * The default value of the '{@link #getSampleRate() <em>Sample Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleRate()
	 * @generated
	 * @ordered
	 */
	protected static final float SAMPLE_RATE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getSampleRate() <em>Sample Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleRate()
	 * @generated
	 * @ordered
	 */
	protected float sampleRate = SAMPLE_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSampleSizeInBits() <em>Sample Size In Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleSizeInBits()
	 * @generated
	 * @ordered
	 */
	protected static final int SAMPLE_SIZE_IN_BITS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSampleSizeInBits() <em>Sample Size In Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampleSizeInBits()
	 * @generated
	 * @ordered
	 */
	protected int sampleSizeInBits = SAMPLE_SIZE_IN_BITS_EDEFAULT;

	/**
	 * The default value of the '{@link #getChannels() <em>Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected static final int CHANNELS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getChannels() <em>Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannels()
	 * @generated
	 * @ordered
	 */
	protected int channels = CHANNELS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameSize() <em>Frame Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameSize()
	 * @generated
	 * @ordered
	 */
	protected static final int FRAME_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFrameSize() <em>Frame Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameSize()
	 * @generated
	 * @ordered
	 */
	protected int frameSize = FRAME_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFrameRate() <em>Frame Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameRate()
	 * @generated
	 * @ordered
	 */
	protected static final float FRAME_RATE_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getFrameRate() <em>Frame Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrameRate()
	 * @generated
	 * @ordered
	 */
	protected float frameRate = FRAME_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #isBigEndian() <em>Big Endian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBigEndian()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BIG_ENDIAN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBigEndian() <em>Big Endian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBigEndian()
	 * @generated
	 * @ordered
	 */
	protected boolean bigEndian = BIG_ENDIAN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AudioPointImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return TimelinePackage.Literals.AUDIO_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public byte[] getMp3()
	{
		return mp3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMp3(byte[] newMp3)
	{
		byte[] oldMp3 = mp3;
		mp3 = newMp3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__MP3, oldMp3, mp3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(int newLength)
	{
		int oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText)
	{
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVoiceId()
	{
		return voiceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoiceId(String newVoiceId)
	{
		String oldVoiceId = voiceId;
		voiceId = newVoiceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__VOICE_ID, oldVoiceId, voiceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLanguageId()
	{
		return languageId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLanguageId(String newLanguageId)
	{
		String oldLanguageId = languageId;
		languageId = newLanguageId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__LANGUAGE_ID, oldLanguageId, languageId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVoiceEffectId()
	{
		return voiceEffectId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVoiceEffectId(String newVoiceEffectId)
	{
		String oldVoiceEffectId = voiceEffectId;
		voiceEffectId = newVoiceEffectId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__VOICE_EFFECT_ID, oldVoiceEffectId, voiceEffectId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSpeechRate()
	{
		return speechRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeechRate(int newSpeechRate)
	{
		int oldSpeechRate = speechRate;
		speechRate = newSpeechRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__SPEECH_RATE, oldSpeechRate, speechRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVolume()
	{
		return volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(int newVolume)
	{
		int oldVolume = volume;
		volume = newVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__VOLUME, oldVolume, volume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPitch()
	{
		return pitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPitch(int newPitch)
	{
		int oldPitch = pitch;
		pitch = newPitch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__PITCH, oldPitch, pitch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBalance()
	{
		return balance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBalance(int newBalance)
	{
		int oldBalance = balance;
		balance = newBalance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__BALANCE, oldBalance, balance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncoding()
	{
		return encoding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncoding(String newEncoding)
	{
		String oldEncoding = encoding;
		encoding = newEncoding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__ENCODING, oldEncoding, encoding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getSampleRate()
	{
		return sampleRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleRate(float newSampleRate)
	{
		float oldSampleRate = sampleRate;
		sampleRate = newSampleRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__SAMPLE_RATE, oldSampleRate, sampleRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSampleSizeInBits()
	{
		return sampleSizeInBits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSampleSizeInBits(int newSampleSizeInBits)
	{
		int oldSampleSizeInBits = sampleSizeInBits;
		sampleSizeInBits = newSampleSizeInBits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__SAMPLE_SIZE_IN_BITS, oldSampleSizeInBits, sampleSizeInBits));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getChannels()
	{
		return channels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannels(int newChannels)
	{
		int oldChannels = channels;
		channels = newChannels;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__CHANNELS, oldChannels, channels));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFrameSize()
	{
		return frameSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameSize(int newFrameSize)
	{
		int oldFrameSize = frameSize;
		frameSize = newFrameSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__FRAME_SIZE, oldFrameSize, frameSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getFrameRate()
	{
		return frameRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrameRate(float newFrameRate)
	{
		float oldFrameRate = frameRate;
		frameRate = newFrameRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__FRAME_RATE, oldFrameRate, frameRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBigEndian()
	{
		return bigEndian;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBigEndian(boolean newBigEndian)
	{
		boolean oldBigEndian = bigEndian;
		bigEndian = newBigEndian;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__BIG_ENDIAN, oldBigEndian, bigEndian));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMode(AudioMode newMode)
	{
		AudioMode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(AudioFormat newFormat)
	{
		AudioFormat oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int[] getPcm()
	{
		return pcm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPcm(int[] newPcm)
	{
		int[] oldPcm = pcm;
		pcm = newPcm;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__PCM, oldPcm, pcm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isModified()
	{
		return modified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModified(boolean newModified)
	{
		boolean oldModified = modified;
		modified = newModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimelinePackage.AUDIO_POINT__MODIFIED, oldModified, modified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_POINT__MP3:
				return getMp3();
			case TimelinePackage.AUDIO_POINT__LENGTH:
				return getLength();
			case TimelinePackage.AUDIO_POINT__TEXT:
				return getText();
			case TimelinePackage.AUDIO_POINT__VOICE_ID:
				return getVoiceId();
			case TimelinePackage.AUDIO_POINT__LANGUAGE_ID:
				return getLanguageId();
			case TimelinePackage.AUDIO_POINT__VOICE_EFFECT_ID:
				return getVoiceEffectId();
			case TimelinePackage.AUDIO_POINT__SPEECH_RATE:
				return getSpeechRate();
			case TimelinePackage.AUDIO_POINT__VOLUME:
				return getVolume();
			case TimelinePackage.AUDIO_POINT__PITCH:
				return getPitch();
			case TimelinePackage.AUDIO_POINT__BALANCE:
				return getBalance();
			case TimelinePackage.AUDIO_POINT__ENCODING:
				return getEncoding();
			case TimelinePackage.AUDIO_POINT__SAMPLE_RATE:
				return getSampleRate();
			case TimelinePackage.AUDIO_POINT__SAMPLE_SIZE_IN_BITS:
				return getSampleSizeInBits();
			case TimelinePackage.AUDIO_POINT__CHANNELS:
				return getChannels();
			case TimelinePackage.AUDIO_POINT__FRAME_SIZE:
				return getFrameSize();
			case TimelinePackage.AUDIO_POINT__FRAME_RATE:
				return getFrameRate();
			case TimelinePackage.AUDIO_POINT__BIG_ENDIAN:
				return isBigEndian();
			case TimelinePackage.AUDIO_POINT__MODE:
				return getMode();
			case TimelinePackage.AUDIO_POINT__FORMAT:
				return getFormat();
			case TimelinePackage.AUDIO_POINT__PCM:
				return getPcm();
			case TimelinePackage.AUDIO_POINT__MODIFIED:
				return isModified();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_POINT__MP3:
				setMp3((byte[])newValue);
				return;
			case TimelinePackage.AUDIO_POINT__LENGTH:
				setLength((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__TEXT:
				setText((String)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__VOICE_ID:
				setVoiceId((String)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__LANGUAGE_ID:
				setLanguageId((String)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__VOICE_EFFECT_ID:
				setVoiceEffectId((String)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__SPEECH_RATE:
				setSpeechRate((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__VOLUME:
				setVolume((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__PITCH:
				setPitch((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__BALANCE:
				setBalance((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__ENCODING:
				setEncoding((String)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__SAMPLE_RATE:
				setSampleRate((Float)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__SAMPLE_SIZE_IN_BITS:
				setSampleSizeInBits((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__CHANNELS:
				setChannels((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__FRAME_SIZE:
				setFrameSize((Integer)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__FRAME_RATE:
				setFrameRate((Float)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__BIG_ENDIAN:
				setBigEndian((Boolean)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__MODE:
				setMode((AudioMode)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__FORMAT:
				setFormat((AudioFormat)newValue);
				return;
			case TimelinePackage.AUDIO_POINT__PCM:
				setPcm((int[])newValue);
				return;
			case TimelinePackage.AUDIO_POINT__MODIFIED:
				setModified((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_POINT__MP3:
				setMp3(MP3_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__VOICE_ID:
				setVoiceId(VOICE_ID_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__LANGUAGE_ID:
				setLanguageId(LANGUAGE_ID_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__VOICE_EFFECT_ID:
				setVoiceEffectId(VOICE_EFFECT_ID_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__SPEECH_RATE:
				setSpeechRate(SPEECH_RATE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__VOLUME:
				setVolume(VOLUME_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__PITCH:
				setPitch(PITCH_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__BALANCE:
				setBalance(BALANCE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__ENCODING:
				setEncoding(ENCODING_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__SAMPLE_RATE:
				setSampleRate(SAMPLE_RATE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__SAMPLE_SIZE_IN_BITS:
				setSampleSizeInBits(SAMPLE_SIZE_IN_BITS_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__CHANNELS:
				setChannels(CHANNELS_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__FRAME_SIZE:
				setFrameSize(FRAME_SIZE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__FRAME_RATE:
				setFrameRate(FRAME_RATE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__BIG_ENDIAN:
				setBigEndian(BIG_ENDIAN_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__PCM:
				setPcm(PCM_EDEFAULT);
				return;
			case TimelinePackage.AUDIO_POINT__MODIFIED:
				setModified(MODIFIED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case TimelinePackage.AUDIO_POINT__MP3:
				return MP3_EDEFAULT == null ? mp3 != null : !MP3_EDEFAULT.equals(mp3);
			case TimelinePackage.AUDIO_POINT__LENGTH:
				return length != LENGTH_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case TimelinePackage.AUDIO_POINT__VOICE_ID:
				return VOICE_ID_EDEFAULT == null ? voiceId != null : !VOICE_ID_EDEFAULT.equals(voiceId);
			case TimelinePackage.AUDIO_POINT__LANGUAGE_ID:
				return LANGUAGE_ID_EDEFAULT == null ? languageId != null : !LANGUAGE_ID_EDEFAULT.equals(languageId);
			case TimelinePackage.AUDIO_POINT__VOICE_EFFECT_ID:
				return VOICE_EFFECT_ID_EDEFAULT == null ? voiceEffectId != null : !VOICE_EFFECT_ID_EDEFAULT.equals(voiceEffectId);
			case TimelinePackage.AUDIO_POINT__SPEECH_RATE:
				return speechRate != SPEECH_RATE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__VOLUME:
				return volume != VOLUME_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__PITCH:
				return pitch != PITCH_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__BALANCE:
				return balance != BALANCE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__ENCODING:
				return ENCODING_EDEFAULT == null ? encoding != null : !ENCODING_EDEFAULT.equals(encoding);
			case TimelinePackage.AUDIO_POINT__SAMPLE_RATE:
				return sampleRate != SAMPLE_RATE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__SAMPLE_SIZE_IN_BITS:
				return sampleSizeInBits != SAMPLE_SIZE_IN_BITS_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__CHANNELS:
				return channels != CHANNELS_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__FRAME_SIZE:
				return frameSize != FRAME_SIZE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__FRAME_RATE:
				return frameRate != FRAME_RATE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__BIG_ENDIAN:
				return bigEndian != BIG_ENDIAN_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__MODE:
				return mode != MODE_EDEFAULT;
			case TimelinePackage.AUDIO_POINT__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case TimelinePackage.AUDIO_POINT__PCM:
				return PCM_EDEFAULT == null ? pcm != null : !PCM_EDEFAULT.equals(pcm);
			case TimelinePackage.AUDIO_POINT__MODIFIED:
				return modified != MODIFIED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mp3: ");
		result.append(mp3);
		result.append(", length: ");
		result.append(length);
		result.append(", text: ");
		result.append(text);
		result.append(", voiceId: ");
		result.append(voiceId);
		result.append(", languageId: ");
		result.append(languageId);
		result.append(", voiceEffectId: ");
		result.append(voiceEffectId);
		result.append(", speechRate: ");
		result.append(speechRate);
		result.append(", volume: ");
		result.append(volume);
		result.append(", pitch: ");
		result.append(pitch);
		result.append(", balance: ");
		result.append(balance);
		result.append(", encoding: ");
		result.append(encoding);
		result.append(", sampleRate: ");
		result.append(sampleRate);
		result.append(", sampleSizeInBits: ");
		result.append(sampleSizeInBits);
		result.append(", channels: ");
		result.append(channels);
		result.append(", frameSize: ");
		result.append(frameSize);
		result.append(", frameRate: ");
		result.append(frameRate);
		result.append(", bigEndian: ");
		result.append(bigEndian);
		result.append(", mode: ");
		result.append(mode);
		result.append(", format: ");
		result.append(format);
		result.append(", pcm: ");
		result.append(pcm);
		result.append(", modified: ");
		result.append(modified);
		result.append(')');
		return result.toString();
	}

	
	
	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated NOT
	 * @ordered
	 */
	protected static final AudioMode MODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected AudioMode mode = MODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final AudioFormat FORMAT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected AudioFormat format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPcm() <em>Pcm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcm()
	 * @generated
	 * @ordered
	 */
	protected static final int[] PCM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPcm() <em>Pcm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPcm()
	 * @generated
	 * @ordered
	 */
	protected int[] pcm = PCM_EDEFAULT;

	/**
	 * The default value of the '{@link #isModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModified()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MODIFIED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isModified() <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isModified()
	 * @generated
	 * @ordered
	 */
	protected boolean modified = MODIFIED_EDEFAULT;

	static final String P_LENGTH = "_length"; // length of pcm data in timeline frames
	static final String P_MODE = "_mode";
	static final String P_BALANCE = "_balance";
	
	@Override
	public AudioPoint deepCopy()
	{
		AudioPoint newPoint = TimelineFactory.eINSTANCE.createAudioPoint();
		copyTo(newPoint);
		return newPoint;
	}

	@Override
	void copyTo(ControlPoint newPoint)
	{
		super.copyTo(newPoint);
		if(!(newPoint instanceof AudioPoint)) return;
		
		((AudioPoint)newPoint).setText(getText());
		((AudioPoint)newPoint).setVoiceId(getVoiceId());
		((AudioPoint)newPoint).setVoiceEffectId(getVoiceEffectId());
		((AudioPoint)newPoint).setSpeechRate(getSpeechRate());
		((AudioPoint)newPoint).setVolume(getVolume());
		((AudioPoint)newPoint).setPitch(getPitch());
		((AudioPoint)newPoint).setBalance(getBalance());
		byte[] mp3 = getMp3();
		if(mp3 != null)
			((AudioPoint)newPoint).setMp3(Arrays.copyOf(mp3, mp3.length));
		((AudioPoint)newPoint).setEncoding(getEncoding());
		((AudioPoint)newPoint).setSampleRate(getSampleRate());
		((AudioPoint)newPoint).setSampleSizeInBits(getSampleSizeInBits());
		((AudioPoint)newPoint).setChannels(getChannels());
		((AudioPoint)newPoint).setFrameSize(getFrameSize());
		((AudioPoint)newPoint).setFrameRate(getFrameRate());
		((AudioPoint)newPoint).setBigEndian(isBigEndian());
		((AudioPoint)newPoint).setLength(getLength());
		((AudioPoint)newPoint).setMode(getMode());
		((AudioPoint)newPoint).setFormat(getFormat());
	}
	
	@Override
	protected void getPropertyDescriptors(List<IPropertyDescriptor> propertyDescriptors)
	{
		super.getPropertyDescriptors(propertyDescriptors);
		propertyDescriptors.add(new PropertyDescriptor(P_LENGTH, "Length"));
		propertyDescriptors.add(new TextPropertyDescriptor(P_TEXT, "Text/File Name"));
		propertyDescriptors.add(new PropertyDescriptor(P_MODE, "Mode"));
		propertyDescriptors.add(new TextPropertyDescriptor(P_VOLUME, "Volume"));
		if(getMode() == AudioMode.STEREO) propertyDescriptors.add(new TextPropertyDescriptor(P_BALANCE, "Balance"));
	}

	@Override
	public Object getPropertyValue(Object id)
	{
		if(id.equals(P_LENGTH)) return Integer.valueOf(getLength());
		if(id.equals(P_TEXT)) return getText();
		if(id.equals(P_MODE)) return getMode().getLiteral();
		if(id.equals(P_VOLUME)) return Integer.toString(getVolume());
		if(id.equals(P_BALANCE)) return Integer.toString(getBalance());
		return super.getPropertyValue(id);
	}

	@Override
	public boolean isPropertySet(Object id)
	{
		if(id.equals(P_LENGTH)) return true;
		if(id.equals(P_TEXT)) return true;
		if(id.equals(P_MODE)) return true;
		if(id.equals(P_VOLUME)) return true;
		if(id.equals(P_BALANCE)) return true;
		return super.isPropertySet(id);
	}

	@Override
	public void setPropertyValue(Object id, Object value)
	{
		if(id.equals(P_VOLUME))
		{
			try
			{
				int v = Integer.parseInt((String)value);
				if(v < 0) v = 0;
				else if(v > 999) v = 999;
				setVolume(v);
			} catch (Exception e)
			{
			}
		}
		else if(id.equals(P_BALANCE))
		{
			try
			{
				int v = Integer.parseInt((String)value);
				if(v < 0) v = 0;
				else if(v > 100) v = 100;
				setBalance(v);
			} catch (Exception e)
			{
			}
		}
		else
			super.setPropertyValue(id, value);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AudioFormat getFormat()
	{
		if(format == null)
		{
			if(encoding == null)
				format = new AudioFormat(AudioUtil.MPEG1L3, 16000.0f, 16, 1, 2, 16000.0f, false);
			else
				format = new AudioFormat(new AudioFormat.Encoding(encoding), sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
		}
		return format;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AudioMode getMode()
	{
		if(mode == null) mode = ((AudioTrack)getParent()).getMode();
		return mode;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int[] getPcm(AudioFormat targetFormat)
	{
		if(isModified() || pcm == null)
		{
//			AudioInputStream mp3Stream = AudioUtil.getAudioInputStream(getFormat(), mp3);
//	
//			try
//			{
//				// mp3 stream --> target format
//				mp3Stream = AudioUtil.getConvertedInputStream(targetFormat, mp3Stream);
//		
//				// mp3 stream in target format --> int array
//				pcm = AudioUtil.getIntegerArrayHeaderless(mp3Stream);
//				setModified(false);
//			}
			try
			{
				
				AudioInputStream mp3Stream = new AudioInputStream(new ByteArrayInputStream(mp3), getFormat(), -1);//AudioUtil.getAudioInputStream(getFormat(), mp3);

				// mp3 stream --> pcm
				AudioFormat tf = new AudioFormat(mp3Stream.getFormat().getSampleRate(), 16, mp3Stream.getFormat().getChannels(), true, false);
				AudioInputStream stream = AudioUtil.getConvertedInputStream(tf, mp3Stream);
				
				//pcm --> PCM_SIGNED target format
				tf = new AudioFormat(targetFormat.getSampleRate(), 16, targetFormat.getChannels(), true, targetFormat.isBigEndian());
				stream = AudioUtil.getConvertedInputStream(tf, stream);
				
				//PCM_SIGNED --> target format encoding
				if(!targetFormat.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED))
				{
					throw new UnsupportedAudioFileException("현재는 PCM 아웃만 지원합니다");
				}
				
				// mp3 stream in target format --> int array
				pcm = AudioUtil.getIntegerArrayHeaderless(stream);
				setModified(false);
			} catch (UnsupportedAudioFileException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return pcm;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isNew()
	{
		return mp3 == null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isFile()
	{
		return getVoiceId() == null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isTts()
	{
		return getVoiceId() != null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMode(int newMode)
	{
		AudioMode mode = AudioMode.get(newMode);
		if(mode != null) setMode(mode);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setMp3(AudioInputStream sourceStream) throws UnsupportedAudioFileException, IOException
	{
		// mp3 format
		AudioFormat sourceFormat = sourceStream.getFormat();
		encoding = "MPEG1L3";
		sampleRate = sourceFormat.getSampleRate(); // samples per second
		sampleSizeInBits = sourceFormat.getSampleSizeInBits(); // bits per sample (default: 16)
		channels = sourceFormat.getChannels(); // the number of channels (defalut: 1)
		frameSize = sourceFormat.getFrameSize(); // bytes per sample (sampleSizeInBits + 7)/8 * channels
		frameRate = sourceFormat.getFrameRate(); // samples per second (= frameRate)
		bigEndian = sourceFormat.isBigEndian();
		//format = new AudioFormat(AudioUtil.MPEG1L3, 16000, sampleSizeInBits, channels, frameSize, 16000, false);
//		format = new AudioFormat(AudioUtil.MPEG1L3, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
		format = new AudioFormat(AudioUtil.MPEG1L3, sampleRate, 16, channels, AudioUtil.NOT_SPECIFIED, AudioUtil.NOT_SPECIFIED, false);
		
		AudioFormat pcmFormat = AudioUtil.getPcmAudioFormat(format);

		// source --> pcm
		AudioInputStream pcmStream = AudioUtil.getConvertedInputStream(pcmFormat, sourceStream);

		// pcm --> mp3
		AudioInputStream mp3Stream = AudioUtil.getConvertedInputStream(format, pcmStream);

		// mp3 --> byte array
		ByteArrayOutputStream mp3Out = new ByteArrayOutputStream();
		AudioUtil.write(mp3Stream, AudioUtil.MP3, mp3Out);
		this.mp3 = mp3Out.toByteArray();

		// length of pcm data in timeline frames
		setModified(true);
		long pcmBytes = pcmStream.getFrameLength() * pcmStream.getFormat().getFrameSize(); // the number of samples * bytes per sample
		this.length = (int)(pcmBytes * 50 / pcmFormat.getFrameSize() / pcmFormat.getSampleRate()); // the number of bytes / bytes per sample / samples per second / 20ms
	}
} //AudioPointImpl
