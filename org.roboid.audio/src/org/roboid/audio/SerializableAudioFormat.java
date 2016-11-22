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

package org.roboid.audio;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;


/**
 * {@link AudioFormat} with {@link Serializable}
 * 
 * @author Tae-hoon Kim
 * @see AudioFormat
 */
public class SerializableAudioFormat implements Serializable
{

	// INSTANCE VARIABLES

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The audio encoding technique used by this format.
	 */
	protected SerializableEncoding encoding;

	/**
	 * The number of samples played or recorded per second, for sounds that have
	 * this format.
	 */
	protected float sampleRate;

	/**
	 * The number of bits in each sample of a sound that has this format.
	 */
	protected int sampleSizeInBits;

	/**
	 * The number of audio channels in this format (1 for mono, 2 for stereo).
	 */
	protected int channels;

	/**
	 * The number of bytes in each frame of a sound that has this format.
	 */
	protected int frameSize;

	/**
	 * The number of frames played or recorded per second, for sounds that have
	 * this format.
	 */
	protected float frameRate;

	/**
	 * Indicates whether the audio data is stored in big-endian or little-endian
	 * order.
	 */
	protected boolean bigEndian;

	/** The set of properties */
	private HashMap<String, Object> properties;

	/**
	 * Constructs an <code>AudioFormat</code> with the given parameters. The
	 * encoding specifies the convention used to represent the data. The other
	 * parameters are further explained in the {@link AudioFormat class
	 * description}.
	 * 
	 * @param encoding
	 *            the audio encoding technique
	 * @param sampleRate
	 *            the number of samples per second
	 * @param sampleSizeInBits
	 *            the number of bits in each sample
	 * @param channels
	 *            the number of channels (1 for mono, 2 for stereo, and so on)
	 * @param frameSize
	 *            the number of bytes in each frame
	 * @param frameRate
	 *            the number of frames per second
	 * @param bigEndian
	 *            indicates whether the data for a single sample is stored in
	 *            big-endian byte order (<code>false</code> means little-endian)
	 */
	public SerializableAudioFormat(SerializableEncoding encoding,
								   float sampleRate,
								   int sampleSizeInBits,
								   int channels,
								   int frameSize,
								   float frameRate,
								   boolean bigEndian)
	{

		this.encoding = encoding;
		this.sampleRate = sampleRate;
		this.sampleSizeInBits = sampleSizeInBits;
		this.channels = channels;
		this.frameSize = frameSize;
		this.frameRate = frameRate;
		this.bigEndian = bigEndian;
		this.properties = null;
	}

	public SerializableAudioFormat(Encoding encoding,
								   float sampleRate,
								   int sampleSizeInBits,
								   int channels,
								   int frameSize,
								   float frameRate,
								   boolean bigEndian)
	{
		this(new SerializableEncoding(encoding),
			 sampleRate,
			 sampleSizeInBits,
			 channels,
			 frameSize,
			 frameRate,
			 bigEndian);
	}

	/**
	 * Constructs an <code>AudioFormat</code> with the given parameters. The
	 * encoding specifies the convention used to represent the data. The other
	 * parameters are further explained in the {@link AudioFormat class
	 * description}.
	 * 
	 * @param encoding
	 *            the audio encoding technique
	 * @param sampleRate
	 *            the number of samples per second
	 * @param sampleSizeInBits
	 *            the number of bits in each sample
	 * @param channels
	 *            the number of channels (1 for mono, 2 for stereo, and so on)
	 * @param frameSize
	 *            the number of bytes in each frame
	 * @param frameRate
	 *            the number of frames per second
	 * @param bigEndian
	 *            indicates whether the data for a single sample is stored in
	 *            big-endian byte order (<code>false</code> means little-endian)
	 * @param properties
	 *            a <code>Map&lt;String,Object&gt;</code> object containing
	 *            format properties
	 * 
	 * @since 1.5
	 */
	public SerializableAudioFormat(SerializableEncoding encoding,
								   float sampleRate,
								   int sampleSizeInBits,
								   int channels,
								   int frameSize,
								   float frameRate,
								   boolean bigEndian,
								   Map<String, Object> properties)
	{
		this(encoding,
			 sampleRate,
			 sampleSizeInBits,
			 channels,
			 frameSize,
			 frameRate,
			 bigEndian);
		this.properties = new HashMap<String, Object>(properties);
	}

	public SerializableAudioFormat(Encoding encoding,
								   float sampleRate,
								   int sampleSizeInBits,
								   int channels,
								   int frameSize,
								   float frameRate,
								   boolean bigEndian,
								   Map<String, Object> properties)
	{
		this(new SerializableEncoding(encoding),
			 sampleRate,
			 sampleSizeInBits,
			 channels,
			 frameSize,
			 frameRate,
			 bigEndian,
			 properties);
	}

	/**
	 * Constructs an <code>AudioFormat</code> with a linear PCM encoding and the
	 * given parameters. The frame size is set to the number of bytes required
	 * to contain one sample from each channel, and the frame rate is set to the
	 * sample rate.
	 * 
	 * @param sampleRate
	 *            the number of samples per second
	 * @param sampleSizeInBits
	 *            the number of bits in each sample
	 * @param channels
	 *            the number of channels (1 for mono, 2 for stereo, and so on)
	 * @param signed
	 *            indicates whether the data is signed or unsigned
	 * @param bigEndian
	 *            indicates whether the data for a single sample is stored in
	 *            big-endian byte order (<code>false</code> means little-endian)
	 */
	public SerializableAudioFormat(float sampleRate,
								   int sampleSizeInBits,
								   int channels,
								   boolean signed,
								   boolean bigEndian)
	{

		this((signed == true
							? SerializableEncoding.PCM_SIGNED
							: SerializableEncoding.PCM_UNSIGNED),
			 sampleRate,
			 sampleSizeInBits,
			 channels,
			 (channels == AudioUtil.NOT_SPECIFIED || sampleSizeInBits == AudioUtil.NOT_SPECIFIED)
																								 ? AudioUtil.NOT_SPECIFIED
																								 : ((sampleSizeInBits + 7) / 8)
																								   * channels,
			 sampleRate,
			 bigEndian);
	}

	/**
	 * Obtains the type of encoding for sounds in this format.
	 * 
	 * @return the encoding type
	 * @see Encoding#PCM_SIGNED
	 * @see Encoding#PCM_UNSIGNED
	 * @see Encoding#ULAW
	 * @see Encoding#ALAW
	 */
	public SerializableEncoding getEncoding()
	{

		return encoding;
	}

	/**
	 * Obtains the sample rate. For compressed formats, the return value is the
	 * sample rate of the uncompressed audio data. When this AudioFormat is used
	 * for queries (e.g.
	 * {@link AudioUtil#isConversionSupported(AudioFormat, AudioFormat)
	 * AudioUtil.isConversionSupported}) or capabilities (e.g.
	 * {@link DataLine.Info#getFormats() DataLine.Info.getFormats}), a sample
	 * rate of <code>AudioUtil.NOT_SPECIFIED</code> means that any sample rate
	 * is acceptable. <code>AudioUtil.NOT_SPECIFIED</code> is also returned when
	 * the sample rate is not defined for this audio format.
	 * 
	 * @return the number of samples per second, or
	 *         <code>AudioUtil.NOT_SPECIFIED</code>
	 * 
	 * @see #getFrameRate()
	 * @see AudioUtil#NOT_SPECIFIED
	 */
	public float getSampleRate()
	{

		return sampleRate;
	}

	/**
	 * Obtains the size of a sample. For compressed formats, the return value is
	 * the sample size of the uncompressed audio data. When this AudioFormat is
	 * used for queries (e.g.
	 * {@link AudioUtil#isConversionSupported(AudioFormat, AudioFormat)
	 * AudioUtil.isConversionSupported}) or capabilities (e.g.
	 * {@link DataLine.Info#getFormats() DataLine.Info.getFormats}), a sample
	 * size of <code>AudioUtil.NOT_SPECIFIED</code> means that any sample size
	 * is acceptable. <code>AudioUtil.NOT_SPECIFIED</code> is also returned when
	 * the sample size is not defined for this audio format.
	 * 
	 * @return the number of bits in each sample, or
	 *         <code>AudioUtil.NOT_SPECIFIED</code>
	 * 
	 * @see #getFrameSize()
	 * @see AudioUtil#NOT_SPECIFIED
	 */
	public int getSampleSizeInBits()
	{

		return sampleSizeInBits;
	}

	/**
	 * Obtains the number of channels. When this AudioFormat is used for queries
	 * (e.g. {@link AudioUtil#isConversionSupported(AudioFormat, AudioFormat)
	 * AudioUtil.isConversionSupported}) or capabilities (e.g.
	 * {@link DataLine.Info#getFormats() DataLine.Info.getFormats}), a return
	 * value of <code>AudioUtil.NOT_SPECIFIED</code> means that any (positive)
	 * number of channels is acceptable.
	 * 
	 * @return The number of channels (1 for mono, 2 for stereo, etc.), or
	 *         <code>AudioUtil.NOT_SPECIFIED</code>
	 * 
	 * @see AudioUtil#NOT_SPECIFIED
	 */
	public int getChannels()
	{

		return channels;
	}

	/**
	 * Obtains the frame size in bytes. When this AudioFormat is used for
	 * queries (e.g.
	 * {@link AudioUtil#isConversionSupported(AudioFormat, AudioFormat)
	 * AudioUtil.isConversionSupported}) or capabilities (e.g.
	 * {@link DataLine.Info#getFormats() DataLine.Info.getFormats}), a frame
	 * size of <code>AudioUtil.NOT_SPECIFIED</code> means that any frame size is
	 * acceptable. <code>AudioUtil.NOT_SPECIFIED</code> is also returned when
	 * the frame size is not defined for this audio format.
	 * 
	 * @return the number of bytes per frame, or
	 *         <code>AudioUtil.NOT_SPECIFIED</code>
	 * 
	 * @see #getSampleSizeInBits()
	 * @see AudioUtil#NOT_SPECIFIED
	 */
	public int getFrameSize()
	{

		return frameSize;
	}

	/**
	 * Obtains the frame rate in frames per second. When this AudioFormat is
	 * used for queries (e.g.
	 * {@link AudioUtil#isConversionSupported(AudioFormat, AudioFormat)
	 * AudioUtil.isConversionSupported}) or capabilities (e.g.
	 * {@link DataLine.Info#getFormats() DataLine.Info.getFormats}), a frame
	 * rate of <code>AudioUtil.NOT_SPECIFIED</code> means that any frame rate is
	 * acceptable. <code>AudioUtil.NOT_SPECIFIED</code> is also returned when
	 * the frame rate is not defined for this audio format.
	 * 
	 * @return the number of frames per second, or
	 *         <code>AudioUtil.NOT_SPECIFIED</code>
	 * 
	 * @see #getSampleRate()
	 * @see AudioUtil#NOT_SPECIFIED
	 */
	public float getFrameRate()
	{

		return frameRate;
	}

	/**
	 * Indicates whether the audio data is stored in big-endian or little-endian
	 * byte order. If the sample size is not more than one byte, the return
	 * value is irrelevant.
	 * 
	 * @return <code>true</code> if the data is stored in big-endian byte order,
	 *         <code>false</code> if little-endian
	 */
	public boolean isBigEndian()
	{

		return bigEndian;
	}

	/**
	 * Obtain an unmodifiable map of properties. The concept of properties is
	 * further explained in the {@link AudioFileFormat class description}.
	 * 
	 * @return a <code>Map&lt;String,Object&gt;</code> object containing all
	 *         properties. If no properties are recognized, an empty map is
	 *         returned.
	 * 
	 * @see #getProperty(String)
	 * @since 1.5
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> properties()
	{
		Map<String, Object> ret;
		if (properties == null)
		{
			ret = new HashMap<String, Object>(0);
		}
		else
		{
			ret = (Map<String, Object>) (properties.clone());
		}
		return (Map<String, Object>) Collections.unmodifiableMap(ret);
	}

	/**
	 * Obtain the property value specified by the key. The concept of properties
	 * is further explained in the {@link AudioFileFormat class description}.
	 * 
	 * <p>
	 * If the specified property is not defined for a particular file format,
	 * this method returns <code>null</code>.
	 * 
	 * @param key
	 *            the key of the desired property
	 * @return the value of the property with the specified key, or
	 *         <code>null</code> if the property does not exist.
	 * 
	 * @see #properties
	 * @since 1.5
	 */
	public Object getProperty(String key)
	{
		if (properties == null) { return null; }
		return properties.get(key);
	}

	/**
	 * Indicates whether this format matches the one specified. To match, two
	 * formats must have the same encoding, the same number of channels, and the
	 * same number of bits per sample and bytes per frame. The two formats must
	 * also have the same sample rate, unless the specified format has the
	 * sample rate value <code>AudioUtil.NOT_SPECIFIED</code> , which any sample
	 * rate will match. The frame rates must similarly be equal, unless the
	 * specified format has the frame rate value
	 * <code>AudioUtil.NOT_SPECIFIED</code> . The byte order (big-endian or
	 * little-endian) must match if the sample size is greater than one byte.
	 * 
	 * @param format
	 *            format to test for match
	 * @return <code>true</code> if this format matches the one specified,
	 *         <code>false</code> otherwise.
	 */
	/*
	 * $$kk: 04.20.99: i changed the semantics of this.
	 */
	public boolean matches(SerializableAudioFormat format)
	{

		if (format.getEncoding().equals(getEncoding())
			&& ((format.getSampleRate() == (float) AudioUtil.NOT_SPECIFIED) || (format.getSampleRate() == getSampleRate()))
			&& (format.getSampleSizeInBits() == getSampleSizeInBits())
			&& (format.getChannels() == getChannels()
				&& (format.getFrameSize() == getFrameSize())
				&& ((format.getFrameRate() == (float) AudioUtil.NOT_SPECIFIED) || (format.getFrameRate() == getFrameRate())) && ((format.getSampleSizeInBits() <= 8) || (format.isBigEndian() == isBigEndian())))) return true;

		return false;
	}

	/**
	 * Returns a string that describes the format, such
	 * as:"PCM SIGNED 22050 Hz 16 bit mono big-endian" . The contents of the
	 * string may vary between implementations of Java Sound.
	 * 
	 * @return a string that describes the format parameters
	 */
	public String toString()
	{
		String sEncoding = "";
		if (getEncoding() != null)
		{
			sEncoding = getEncoding().toString() + " ";
		}

		String sSampleRate;
		if (getSampleRate() == (float) AudioUtil.NOT_SPECIFIED)
		{
			sSampleRate = "unknown sample rate, ";
		}
		else
		{
			sSampleRate = "" + getSampleRate() + " Hz, ";
		}

		String sSampleSizeInBits;
		if (getSampleSizeInBits() == (float) AudioUtil.NOT_SPECIFIED)
		{
			sSampleSizeInBits = "unknown bits per sample, ";
		}
		else
		{
			sSampleSizeInBits = "" + getSampleSizeInBits() + " bit, ";
		}

		String sChannels;
		if (getChannels() == 1)
		{
			sChannels = "mono, ";
		}
		else
			if (getChannels() == 2)
			{
				sChannels = "stereo, ";
			}
			else
			{
				if (getChannels() == AudioUtil.NOT_SPECIFIED)
				{
					sChannels = " unknown number of channels, ";
				}
				else
				{
					sChannels = "" + getChannels() + " channels, ";
				}
			}

		String sFrameSize;
		if (getFrameSize() == (float) AudioUtil.NOT_SPECIFIED)
		{
			sFrameSize = "unknown frame size, ";
		}
		else
		{
			sFrameSize = "" + getFrameSize() + " bytes/frame, ";
		}

		String sFrameRate = "";
		if (Math.abs(getSampleRate() - getFrameRate()) > 0.00001)
		{
			if (getFrameRate() == (float) AudioUtil.NOT_SPECIFIED)
			{
				sFrameRate = "unknown frame rate, ";
			}
			else
			{
				sFrameRate = getFrameRate() + " frames/second, ";
			}
		}

		String sEndian = "";
		if ((getEncoding().equals(SerializableEncoding.PCM_SIGNED) || getEncoding().equals(SerializableEncoding.PCM_UNSIGNED))
			&& ((getSampleSizeInBits() > 8) || (getSampleSizeInBits() == AudioUtil.NOT_SPECIFIED)))
		{
			if (isBigEndian())
			{
				sEndian = "big-endian";
			}
			else
			{
				sEndian = "little-endian";
			}
		}

		return sEncoding
			   + sSampleRate
			   + sSampleSizeInBits
			   + sChannels
			   + sFrameSize
			   + sFrameRate
			   + sEndian;

	}

	public AudioFormat toAudioformat()
	{
		if (properties != null)
		{
			return new AudioFormat(encoding.toEncoding(),
								   sampleRate,
								   sampleSizeInBits,
								   channels,
								   frameSize,
								   frameRate,
								   bigEndian,
								   properties);
		}
		else
		{
			return new AudioFormat(encoding.toEncoding(),
								   sampleRate,
								   sampleSizeInBits,
								   channels,
								   frameSize,
								   frameRate,
								   bigEndian);
		}

	}

	/**
	 * {@link Encoding}을 {@link Serializable}하도록 만들었습니다.
	 * 
	 * @author Tae-hoon Kim
	 *
	 */
	public static class SerializableEncoding implements Serializable
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		// ENCODING DEFINES

		/**
		 * Specifies signed, linear PCM data.
		 */
		public static final SerializableEncoding PCM_SIGNED = new SerializableEncoding("PCM_SIGNED");

		/**
		 * Specifies unsigned, linear PCM data.
		 */
		public static final SerializableEncoding PCM_UNSIGNED = new SerializableEncoding("PCM_UNSIGNED");

		/**
		 * Specifies u-law encoded data.
		 */
		public static final SerializableEncoding ULAW = new SerializableEncoding("ULAW");

		/**
		 * Specifies a-law encoded data.
		 */
		public static final SerializableEncoding ALAW = new SerializableEncoding("ALAW");

		// INSTANCE VARIABLES

		/**
		 * Encoding name.
		 */
		private String name;

		// CONSTRUCTOR

		/**
		 * Constructs a new encoding.
		 * 
		 * @param name
		 *            the name of the new type of encoding
		 */
		public SerializableEncoding(String name)
		{
			this.name = name;
		}

		public SerializableEncoding(Encoding encoding)
		{
			this.name = encoding.toString();
		}

		// METHODS

		/**
		 * Finalizes the equals method
		 */
		public final boolean equals(Object obj)
		{
			if (toString() == null) { return (obj != null)
											 && (obj.toString() == null); }
			if (obj instanceof SerializableEncoding) { return toString().equals(obj.toString()); }
			return false;
		}

		/**
		 * Finalizes the hashCode method
		 */
		public final int hashCode()
		{
			if (toString() == null) { return 0; }
			return toString().hashCode();
		}

		/**
		 * Provides the <code>String</code> representation of the encoding. This
		 * <code>String</code> is the same name that was passed to the
		 * constructor. For the predefined encodings, the name is similar to the
		 * encoding's variable (field) name. For example,
		 * <code>PCM_SIGNED.toString()</code> returns the name "pcm_signed".
		 * 
		 * @return the encoding name
		 */
		public final String toString()
		{
			return name;
		}

		public Encoding toEncoding()
		{
			return new Encoding(name);
		}
	} // class Encoding
}
