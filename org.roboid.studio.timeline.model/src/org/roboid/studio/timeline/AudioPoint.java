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

package org.roboid.studio.timeline;

import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.roboid.robot.AudioMode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Audio Point</b></em>'.
 * @author Kyoung Jin Kim
 * @author Kwang-Hyun Park
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getMp3 <em>Mp3</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getLength <em>Length</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getText <em>Text</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getVoiceId <em>Voice Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getLanguageId <em>Language Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getVoiceEffectId <em>Voice Effect Id</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getSpeechRate <em>Speech Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getVolume <em>Volume</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getPitch <em>Pitch</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getBalance <em>Balance</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getEncoding <em>Encoding</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getSampleRate <em>Sample Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getSampleSizeInBits <em>Sample Size In Bits</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getChannels <em>Channels</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getFrameSize <em>Frame Size</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getFrameRate <em>Frame Rate</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#isBigEndian <em>Big Endian</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getMode <em>Mode</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getFormat <em>Format</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#getPcm <em>Pcm</em>}</li>
 *   <li>{@link org.roboid.studio.timeline.AudioPoint#isModified <em>Modified</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint()
 * @model
 * @generated
 */
public interface AudioPoint extends ControlPoint
{
	/**
	 * Returns the value of the '<em><b>Mp3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mp3</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mp3</em>' attribute.
	 * @see #setMp3(byte[])
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Mp3()
	 * @model
	 * @generated
	 */
	byte[] getMp3();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getMp3 <em>Mp3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mp3</em>' attribute.
	 * @see #getMp3()
	 * @generated
	 */
	void setMp3(byte[] value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Length()
	 * @model
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Text()
	 * @model
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Voice Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voice Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voice Id</em>' attribute.
	 * @see #setVoiceId(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_VoiceId()
	 * @model
	 * @generated
	 */
	String getVoiceId();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getVoiceId <em>Voice Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voice Id</em>' attribute.
	 * @see #getVoiceId()
	 * @generated
	 */
	void setVoiceId(String value);

	/**
	 * Returns the value of the '<em><b>Language Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Language Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Language Id</em>' attribute.
	 * @see #setLanguageId(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_LanguageId()
	 * @model
	 * @generated
	 */
	String getLanguageId();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getLanguageId <em>Language Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Language Id</em>' attribute.
	 * @see #getLanguageId()
	 * @generated
	 */
	void setLanguageId(String value);

	/**
	 * Returns the value of the '<em><b>Voice Effect Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Voice Effect Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Voice Effect Id</em>' attribute.
	 * @see #setVoiceEffectId(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_VoiceEffectId()
	 * @model
	 * @generated
	 */
	String getVoiceEffectId();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getVoiceEffectId <em>Voice Effect Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Voice Effect Id</em>' attribute.
	 * @see #getVoiceEffectId()
	 * @generated
	 */
	void setVoiceEffectId(String value);

	/**
	 * Returns the value of the '<em><b>Speech Rate</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Speech Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Speech Rate</em>' attribute.
	 * @see #setSpeechRate(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_SpeechRate()
	 * @model default="100"
	 * @generated
	 */
	int getSpeechRate();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getSpeechRate <em>Speech Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Speech Rate</em>' attribute.
	 * @see #getSpeechRate()
	 * @generated
	 */
	void setSpeechRate(int value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Volume()
	 * @model default="100"
	 * @generated
	 */
	int getVolume();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(int value);

	/**
	 * Returns the value of the '<em><b>Pitch</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pitch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pitch</em>' attribute.
	 * @see #setPitch(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Pitch()
	 * @model default="100"
	 * @generated
	 */
	int getPitch();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getPitch <em>Pitch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pitch</em>' attribute.
	 * @see #getPitch()
	 * @generated
	 */
	void setPitch(int value);

	/**
	 * Returns the value of the '<em><b>Balance</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Balance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Balance</em>' attribute.
	 * @see #setBalance(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Balance()
	 * @model default="50"
	 * @generated
	 */
	int getBalance();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getBalance <em>Balance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Balance</em>' attribute.
	 * @see #getBalance()
	 * @generated
	 */
	void setBalance(int value);

	/**
	 * Returns the value of the '<em><b>Encoding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Encoding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Encoding</em>' attribute.
	 * @see #setEncoding(String)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Encoding()
	 * @model
	 * @generated
	 */
	String getEncoding();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getEncoding <em>Encoding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Encoding</em>' attribute.
	 * @see #getEncoding()
	 * @generated
	 */
	void setEncoding(String value);

	/**
	 * Returns the value of the '<em><b>Sample Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Rate</em>' attribute.
	 * @see #setSampleRate(float)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_SampleRate()
	 * @model
	 * @generated
	 */
	float getSampleRate();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getSampleRate <em>Sample Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Rate</em>' attribute.
	 * @see #getSampleRate()
	 * @generated
	 */
	void setSampleRate(float value);

	/**
	 * Returns the value of the '<em><b>Sample Size In Bits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Size In Bits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Size In Bits</em>' attribute.
	 * @see #setSampleSizeInBits(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_SampleSizeInBits()
	 * @model
	 * @generated
	 */
	int getSampleSizeInBits();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getSampleSizeInBits <em>Sample Size In Bits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Size In Bits</em>' attribute.
	 * @see #getSampleSizeInBits()
	 * @generated
	 */
	void setSampleSizeInBits(int value);

	/**
	 * Returns the value of the '<em><b>Channels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channels</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' attribute.
	 * @see #setChannels(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Channels()
	 * @model
	 * @generated
	 */
	int getChannels();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getChannels <em>Channels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channels</em>' attribute.
	 * @see #getChannels()
	 * @generated
	 */
	void setChannels(int value);

	/**
	 * Returns the value of the '<em><b>Frame Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Size</em>' attribute.
	 * @see #setFrameSize(int)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_FrameSize()
	 * @model
	 * @generated
	 */
	int getFrameSize();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getFrameSize <em>Frame Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Size</em>' attribute.
	 * @see #getFrameSize()
	 * @generated
	 */
	void setFrameSize(int value);

	/**
	 * Returns the value of the '<em><b>Frame Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Frame Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Frame Rate</em>' attribute.
	 * @see #setFrameRate(float)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_FrameRate()
	 * @model
	 * @generated
	 */
	float getFrameRate();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getFrameRate <em>Frame Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Frame Rate</em>' attribute.
	 * @see #getFrameRate()
	 * @generated
	 */
	void setFrameRate(float value);

	/**
	 * Returns the value of the '<em><b>Big Endian</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Big Endian</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Big Endian</em>' attribute.
	 * @see #setBigEndian(boolean)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_BigEndian()
	 * @model
	 * @generated
	 */
	boolean isBigEndian();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#isBigEndian <em>Big Endian</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Big Endian</em>' attribute.
	 * @see #isBigEndian()
	 * @generated
	 */
	void setBigEndian(boolean value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link org.roboid.robot.AudioMode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see org.roboid.robot.AudioMode
	 * @see #setMode(AudioMode)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Mode()
	 * @model transient="true"
	 * @generated
	 */
	AudioMode getMode();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see org.roboid.robot.AudioMode
	 * @see #getMode()
	 * @generated
	 */
	void setMode(AudioMode value);

	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(AudioFormat)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Format()
	 * @model dataType="org.roboid.studio.timeline.AudioFormat" transient="true"
	 * @generated
	 */
	AudioFormat getFormat();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(AudioFormat value);

	/**
	 * Returns the value of the '<em><b>Pcm</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pcm</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pcm</em>' attribute.
	 * @see #setPcm(int[])
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Pcm()
	 * @model dataType="org.roboid.robot.IntArray" transient="true"
	 * @generated
	 */
	int[] getPcm();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#getPcm <em>Pcm</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pcm</em>' attribute.
	 * @see #getPcm()
	 * @generated
	 */
	void setPcm(int[] value);

	/**
	 * Returns the value of the '<em><b>Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modified</em>' attribute.
	 * @see #setModified(boolean)
	 * @see org.roboid.studio.timeline.TimelinePackage#getAudioPoint_Modified()
	 * @model transient="true"
	 * @generated
	 */
	boolean isModified();

	/**
	 * Sets the value of the '{@link org.roboid.studio.timeline.AudioPoint#isModified <em>Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modified</em>' attribute.
	 * @see #isModified()
	 * @generated
	 */
	void setModified(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.roboid.studio.timeline.UnsupportedAudioFileException org.roboid.studio.timeline.IOException" sourceStreamDataType="org.roboid.studio.timeline.AudioInputStream"
	 * @generated
	 */
	void setMp3(AudioInputStream sourceStream) throws UnsupportedAudioFileException, IOException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.roboid.robot.IntArray" targetFormatDataType="org.roboid.studio.timeline.AudioFormat"
	 * @generated
	 */
	int[] getPcm(AudioFormat targetFormat);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isNew();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isFile();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isTts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setMode(int newMode);

	
	
	
	
	/*=====================================================================================
	 *=====================================================================================
	 * MODIFIED
	 *=====================================================================================
	 *=====================================================================================
	 */
	
	/**
	 * @generated NOT
	 */
	public static final String P_TEXT = "_text"; // TTS sentence or audio file name
	/**
	 * @generated NOT
	 */
	public static final String P_VOLUME = "_volume";
} // AudioPoint
