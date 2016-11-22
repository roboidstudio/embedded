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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFileFormat.Type;

/**
 * Utility for audio conversion
 * 
 * @author Tae-hoon Kim
 * @author Kwang-Hyun Park
 */
public class AudioUtil
{
	public static final AudioFormat.Encoding MPEG1L3 = new AudioFormat.Encoding("MPEG1L3");
	public static final AudioFileFormat.Type MP3 = new AudioFileFormat.Type("MP3", "mp3");
	public static final int NOT_SPECIFIED = AudioSystem.NOT_SPECIFIED;
	public static final int DEFAULT_SAMPLE_SIZE_IN_BITS = 16;
	public static final int DEFAULT_CHANNELS = 1;

//	public static void printAudioFileFormatTypes()
//	{
//		AudioFileFormat.Type[] types = AudioSystem.getAudioFileTypes();
//		for (int i = 0; i < types.length; i++)
//		{
//			if (i != 0) System.out.print(", ");
//			System.out.print(types[i]);
//		}
//	}
	
	static
	{
//		printAudioFileFormatTypes();
		try
		{
			String path = Activator.findLibraryPath("lame_enc.dll");
			if(path != null)
			{
				File file = new File(path);
				// System.out.println(file.getParentFile().getCanonicalPath());
				Activator.addLibraryPath(file.getParentFile().getCanonicalPath());
				System.loadLibrary("lame_enc");
				System.loadLibrary("lametritonus");
			}
			else
			{
				System.err.println("Couldn't find a path of audio DLL library files.");
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		// System.out.println("Converter");
		// List list =
		// JDK13Services.getProviders(FormatConversionProvider.class);
		// for(int i=0; i<list.size(); i++) {
		// System.out.println(list.get(i));
		// }
		//
		// System.out.println("Reader");
		// list = JDK13Services.getProviders(AudioFileReader.class);
		// for(int i=0; i<list.size(); i++) {
		// System.out.println(list.get(i));
		// }
	}

	public static AudioFileFormat getAudioFileFormat(File file) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioFileFormat(file);
	}

	public static AudioFileFormat getAudioFileFormat(InputStream stream) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioFileFormat(stream);
	}

	public static AudioFileFormat getAudioFileFormat(URL url) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioFileFormat(url);
	}

	public static Type[] getAudioFileTypes()
	{
		return AudioSystem.getAudioFileTypes();
	}

	public static Type[] getAudioFileTypes(AudioInputStream stream)
	{
		return AudioSystem.getAudioFileTypes(stream);
	}

	/**
	 * <p>
	 * call AudioSystem method
	 * </p>
	 * </p>This method can cause an error during converting audio. Use the below method if conversion is required.
	 * {@link AudioUtil#getConvertedInputStream(AudioFormat, AudioInputStream)}
	 * </p>
	 * 
	 * @param targetFormat
	 * @param sourceStream
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static AudioInputStream getAudioInputStream(AudioFormat targetFormat, AudioInputStream sourceStream) throws IllegalArgumentException
	{
		return AudioSystem.getAudioInputStream(targetFormat, sourceStream);
	}

	/**
	 * <p>
	 * Convert byte array to audio stream with given audio format
	 * </p>
	 * 
	 * @param format
	 * @param byteArrayHeaderless
	 * @return
	 */
	public static AudioInputStream getAudioInputStream(AudioFormat format, byte[] byteArrayHeaderless)
	{
		
		if(format.getFrameSize()>0)
			return new AudioInputStream(new ByteArrayInputStream(byteArrayHeaderless), format, byteArrayHeaderless.length / format.getFrameSize());
		else 
			return new AudioInputStream(new ByteArrayInputStream(byteArrayHeaderless), format, NOT_SPECIFIED);
	}

	/**
	 * <p>
	 * Convert byte array to audio stream with given audio format
	 * </p>
	 * 
	 * @param format
	 * @param byteArrayHeaderless
	 * @param length
	 * @return
	 */
	public static AudioInputStream getAudioInputStream(AudioFormat format, byte[] byteArrayHeaderless, long length)
	{
		return new AudioInputStream(new ByteArrayInputStream(byteArrayHeaderless), format, length);
	}

	/**
	 * <p>
	 * Convert integer array to audio stream with given audio format.
	 * The {@link AudioFormat#getSampleSizeInBits()} size of data are stored in integer array.
	 * </p>
	 * <p>
	 * If {@link AudioFormat#getSampleSizeInBits()} is 16bit, the lower 16bit data of integer is used when generate AudioInputStream
	 * </p>
	 * 
	 * @param format
	 * @param intArrayHeaderless
	 * @return
	 */
	public static AudioInputStream getAudioInputStream(AudioFormat format, int[] intArrayHeaderless) throws IllegalArgumentException
	{
		return getAudioInputStream(format, getByteArrayHeaderless(intArrayHeaderless, format.getSampleSizeInBits(), format.isBigEndian()));
	}

	/**
	 * <p>
	 * Convert source stream to target encoding
	 * </p>
	 * <p>
	 * Call an AudioSystem method
	 * </p>
	 * 
	 * @param targetEncoding
	 * @param sourceStream
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static AudioInputStream getAudioInputStream(AudioFormat.Encoding targetEncoding, AudioInputStream sourceStream) throws IllegalArgumentException
	{
		return AudioSystem.getAudioInputStream(targetEncoding, sourceStream);
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 */
	public static AudioInputStream getAudioInputStream(File file) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioInputStream(file);
	}

	public static AudioInputStream getAudioInputStream(InputStream stream) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioInputStream(stream);
	}

	public static AudioInputStream getAudioInputStream(URL url) throws UnsupportedAudioFileException, IOException
	{
		return AudioSystem.getAudioInputStream(url);
	}

	/**
	 * Convert integer array to byte array
	 * 
	 * @param intArrayHeaderless
	 * @param sampleSizeInBits
	 *            The bit size of data stored in integer array
	 * @param isBigEndian
	 * @return
	 */
	public static byte[] getByteArrayHeaderless(int[] intArrayHeaderless, int sampleSizeInBits, boolean isBigEndian) throws IllegalArgumentException
	{
		if(sampleSizeInBits <= 0 && sampleSizeInBits > Integer.SIZE)
		{
			throw new IllegalArgumentException("sampleSizeInBits should be less than " + Integer.SIZE + ":" + sampleSizeInBits);
		}

		// --------------------------------------
		int b = ((sampleSizeInBits + 7) / 8);
		byte[] target = new byte[intArrayHeaderless.length * b];

		if(isBigEndian)
		{ // big endian
			for(int i = 0; i < intArrayHeaderless.length; i++)
			{
				for(int j = 0; j < b; j++)
				{
					target[i * b + j] = (byte)(intArrayHeaderless[i] >>> (8 * (b - j - 1)));
				}
			}
		}
		else
		{ // little endian
			for(int i = 0; i < intArrayHeaderless.length; i++)
			{
				for(int j = 0; j < b; j++)
				{
					target[i * b + j] = (byte)(intArrayHeaderless[i] >>> (8 * (j)));
				}
			}
		}
		return target;
	}

	/**
	 * Convert InputStream to byteArray
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static byte[] getByteArrayHeaderless(InputStream in) throws IOException
	{
		if(in.markSupported())
			in.reset();
		
		byte[] ret = new byte[in.available()];
		in.read(ret);
		return ret;
	}

	public static Clip getClip() throws LineUnavailableException
	{
		return AudioSystem.getClip();
	}

	public static Clip getClip(Mixer.Info mixerInfo) throws LineUnavailableException
	{
		return AudioSystem.getClip(mixerInfo);
	}

	public static AudioInputStream getConvertedInputStream(AudioFormat targetFormat, AudioInputStream sourceStream) throws UnsupportedAudioFileException, IOException
	{
		return getConvertedInputStream(targetFormat, sourceStream, true);
	}
	/**
	 * Convert audio stream to given audio format
	 * 
	 * @param targetFormat
	 * @param sourceStream
	 * @return
	 * @throws UnsupportedAudioFileException
	 * @throws IOException
	 * 
	 */
	public static AudioInputStream getConvertedInputStream(AudioFormat targetFormat, AudioInputStream sourceStream, boolean isClip) throws UnsupportedAudioFileException, IOException
	{
		AudioInputStream convertedStream = sourceStream;
		AudioFormat sf = null;
		AudioFormat tf = targetFormat;

		// Convert to PCM
		sf = convertedStream.getFormat();
		if(!sf.getEncoding().equals(AudioFormat.Encoding.PCM_SIGNED))
		{
			convertedStream = getConvertedInputStream_(getPcmAudioFormat(sf), convertedStream);
			if(isClip)
			{
				convertedStream = getConvertedPcmAudioInputStream(convertedStream);
			}
		}

		// Convert sampling rate
		sf = convertedStream.getFormat();
		if(sf.getSampleRate() != tf.getSampleRate() || sf.getFrameRate() != tf.getFrameRate())
		{

			convertedStream = getConvertedInputStream_(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
																		tf.getSampleRate(),
																		sf.getSampleSizeInBits(),
																		sf.getChannels(),
																		sf.getChannels() * ((sf.getSampleSizeInBits() + 7) / 8),
																		tf.getSampleRate(), // PCM은 샘플링 레이트와 프레임 레이트가 같음
																		sf.isBigEndian()),
														convertedStream);
		}

		// Convert channels
		sf = convertedStream.getFormat();
		if(sf.getChannels() != tf.getChannels())
		{
			convertedStream = getConvertedInputStream_(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
																		sf.getSampleRate(),
																		sf.getSampleSizeInBits(),
																		tf.getChannels(),
																		tf.getChannels() * ((sf.getSampleSizeInBits() + 7) / 8),
																		sf.getSampleRate(),
																		sf.isBigEndian()),
														convertedStream);
		}

		// Convert sample size
		sf = convertedStream.getFormat();
		if(sf.getSampleSizeInBits() != tf.getSampleSizeInBits())
		{
			// If target sample size is not given, set to default (16bit)
			int pcmSampleSizeInBits = (tf.getSampleSizeInBits() == NOT_SPECIFIED) ? DEFAULT_SAMPLE_SIZE_IN_BITS : tf.getSampleSizeInBits();
			convertedStream = getConvertedInputStream_(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
																		sf.getSampleRate(),
																		pcmSampleSizeInBits,
																		sf.getChannels(),
																		sf.getChannels() * ((sf.getSampleSizeInBits() + 7) / 8),
																		sf.getSampleRate(),
																		sf.isBigEndian()),
														convertedStream);
		}

		// Convert endian
		sf = convertedStream.getFormat();
		if(sf.isBigEndian() != tf.isBigEndian())
		{
			convertedStream = getConvertedInputStream_(new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
																		sf.getSampleRate(),
																		sf.getSampleSizeInBits(),
																		sf.getChannels(),
																		sf.getChannels() * ((sf.getSampleSizeInBits() + 7) / 8),
																		sf.getSampleRate(),
																		tf.isBigEndian()),
														convertedStream);
		}

		// Convert to target encoding
		sf = convertedStream.getFormat();
		if(!sf.getEncoding().equals(tf.getEncoding()))
		{
			// System.out.println(convertedStream.available());
			convertedStream = getConvertedInputStream_(new AudioFormat(tf.getEncoding(),
																		sf.getSampleRate(),
																		sf.getSampleSizeInBits(),
																		sf.getChannels(),
																		sf.getChannels() * ((sf.getSampleSizeInBits() + 7) / 8),
																		sf.getFrameRate(),
																		sf.isBigEndian()),
														convertedStream);
		}

		return convertedStream;
	}

	/**
	 * Utility method used in {@link AudioUtil#getConvertedInputStream(AudioFormat, AudioInputStream)}
	 * 
	 * @param targetFormat
	 * @param in
	 * @return
	 * @throws UnsupportedAudioFileException
	 */
	private static AudioInputStream getConvertedInputStream_(AudioFormat targetFormat, AudioInputStream in) throws UnsupportedAudioFileException
	{
		AudioInputStream target = null;
		if(AudioSystem.isConversionSupported(targetFormat, in.getFormat()))
		{
			try
			{
				target = AudioSystem.getAudioInputStream(targetFormat, in);
			} catch (Exception e)
			{
				throw new UnsupportedAudioFileException("could not convert : " + in.getFormat() + " -> " + targetFormat);
			}
		}
		else
		{
			throw new UnsupportedAudioFileException("could not convert : " + in.getFormat() + " -> " + targetFormat);
		}

		return target;
	}

	private static AudioInputStream getConvertedPcmAudioInputStream(AudioInputStream stream) throws IOException
	{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		AudioSystem.write(stream, AudioFileFormat.Type.WAVE, bout);
		byte[] barray = bout.toByteArray();
		barray = Arrays.copyOfRange(barray, 44, barray.length);
		stream = getAudioInputStream(stream.getFormat(),barray);
		return stream;
	}
	
	public static DataLine.Info getDataLineInfo(Class<?> lineClass, AudioFormat format)
	{
		return new DataLine.Info(lineClass, format);
	}

	/**
	 * Convert AudioInputStream to integer array<br/>
	 * The {@link AudioFormat#getSampleSizeInBits()} bit size of data is stored in integer array
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static int[] getIntegerArrayHeaderless(AudioInputStream in) throws IOException, IllegalArgumentException
	{
		return getIntegerArrayHeaderless(getByteArrayHeaderless(in), in.getFormat().getSampleSizeInBits(), in.getFormat().isBigEndian());
	}

	/**
	 * Convert byte array to integer array<br/>
	 * Convert sampleSizeInBits/8 size of byte array to one integer
	 * 
	 * @param sampleSizeInBits
	 * @param byteArray
	 * @param isBigEndian
	 * @return
	 */
	public static int[] getIntegerArrayHeaderless(byte[] byteArray, int sampleSizeInBits, boolean isBigEndian) throws IllegalArgumentException
	{
		// sampleSizeInBits should be <= 32
		if(sampleSizeInBits <= 0 && sampleSizeInBits > Integer.SIZE)
		{
			throw new IllegalArgumentException("sampleSizeInBits should be less than 32:" + sampleSizeInBits);
		}

		// sampleSizeInBits should be multiples of 8
		if(sampleSizeInBits % 8 != 0)
		{
			throw new IllegalArgumentException("sampleSizeInBits should be a multiple of 8:" + sampleSizeInBits);
		}

		// ----------------------------------------------

		int b = ((sampleSizeInBits + 7) / 8);
		int[] target = new int[byteArray.length / b];
		if(isBigEndian)
		{ // big endian
			for(int i = 0; i < target.length; i++)
			{
				target[i] = byteArray[i * b] << (8 * (b - 1));
				for(int j = 1; j < b; j++)
				{ // 1 ~ (b-1)
					target[i] |= (byteArray[(i * b) + j] & 0xff) << ((b - j - 1) * 8);
				}
			}
		}
		else
		{ // little endian
			for(int i = 0; i < target.length; i++)
			{
				target[i] = byteArray[i * b + (b - 1)] << (8 * (b - 1));
				for(int j = 1; j < b; j++)
				{ // 1 ~ (b-1)
					target[i] |= (byteArray[(i * b) + j - 1] & 0xff) << ((j - 1) * 8);
				}
			}
		}
		return target;
	}

	public static Line getLine(Line.Info info) throws LineUnavailableException
	{
		return AudioSystem.getLine(info);
	}

	public static Mixer getMixer(Mixer.Info info)
	{
		return AudioSystem.getMixer(info);
	}

	public static Mixer.Info[] getMixerInfo()
	{
		return AudioSystem.getMixerInfo();
	}

	public static SourceDataLine getSourceDataLine(AudioFormat format) throws LineUnavailableException
	{
		return AudioSystem.getSourceDataLine(format);
	}

	public static SourceDataLine getSourceDataLine(AudioFormat format, Mixer.Info mixerinfo) throws LineUnavailableException
	{
		return AudioSystem.getSourceDataLine(format, mixerinfo);
	}

	public static Line.Info[] getSourceLineInfo(Line.Info info)
	{
		return AudioSystem.getSourceLineInfo(info);
	}

	public static TargetDataLine getTargetDataLine(AudioFormat format) throws LineUnavailableException
	{
		return AudioSystem.getTargetDataLine(format);
	}

	public static TargetDataLine getTargetDataLine(AudioFormat format, Mixer.Info mixerinfo) throws LineUnavailableException
	{
		return AudioSystem.getTargetDataLine(format, mixerinfo);
	}

	public static AudioFormat.Encoding[] getTargetEncodings(AudioFormat sourceFormat)
	{
		return AudioSystem.getTargetEncodings(sourceFormat);
	}

	public static AudioFormat.Encoding[] getTargetEncodings(AudioFormat.Encoding sourceEncoding)
	{
		return AudioSystem.getTargetEncodings(sourceEncoding);
	}

	public static AudioFormat[] getTargetFormats(AudioFormat.Encoding targetEncoding, AudioFormat sourceFormat)
	{
		return AudioSystem.getTargetFormats(targetEncoding, sourceFormat);
	}

	public static Line.Info[] getTargetLineInfo(Line.Info info)
	{
		return AudioSystem.getTargetLineInfo(info);
	}

	public static boolean isConversionSupported(AudioFormat targetFormat, AudioFormat sourceFormat)
	{
		return AudioSystem.isConversionSupported(targetFormat, sourceFormat);
	}

	public static boolean isConversionSupported(AudioFormat.Encoding targetEncoding, AudioFormat sourceFormat)
	{
		return AudioSystem.isConversionSupported(targetEncoding, sourceFormat);
	}

	public static boolean isEqual(AudioFormat a, AudioFormat b)
	{
		return a.getChannels() == b.getChannels() && a.getEncoding().equals(b.getEncoding()) && a.getFrameRate() == b.getFrameRate() && a.getFrameSize() == b.getFrameSize() && a.getSampleRate() == b.getSampleRate() && a.getSampleSizeInBits() == b.getSampleSizeInBits() && a.isBigEndian() == b.isBigEndian() && a.properties().equals(b.properties());

	}

	public static boolean isFileTypeSupported(AudioFileFormat.Type fileType)
	{
		return AudioSystem.isFileTypeSupported(fileType);
	}

	public static boolean isFileTypeSupported(AudioFileFormat.Type fileType, AudioInputStream stream)
	{
		return AudioSystem.isFileTypeSupported(fileType, stream);
	}

	public static boolean isLineSupported(Line.Info info)
	{
		return AudioSystem.isLineSupported(info);
	}

	public static AudioFormat getPcmAudioFormat(AudioFormat f)
	{
		// SampleSizeInBits
		int sampleSizeInBits = f.getSampleSizeInBits();
		if(sampleSizeInBits == AudioUtil.NOT_SPECIFIED || sampleSizeInBits == 0)
		{
			sampleSizeInBits = DEFAULT_SAMPLE_SIZE_IN_BITS;
		}

		// Channel
		int channels = f.getChannels();
		if(channels == AudioUtil.NOT_SPECIFIED || channels <= 0)
		{
			channels = DEFAULT_CHANNELS;
		}

		// Frame Size
		int frameSize = f.getFrameSize();
		if(frameSize == AudioUtil.NOT_SPECIFIED || frameSize <= 0)
		{
			frameSize = channels * ((sampleSizeInBits + 7) / 8);
		}

		return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, f.getSampleRate(), sampleSizeInBits, channels, frameSize, f.getSampleRate(), false);
	}

	public static int write(AudioInputStream stream, AudioFileFormat.Type fileType, File out) throws IOException, IllegalArgumentException
	{
		return AudioSystem.write(stream, fileType, out);
	}

	public static int write(AudioInputStream stream, AudioFileFormat.Type fileType, OutputStream out) throws IOException, IllegalArgumentException
	{
		return AudioSystem.write(stream, fileType, out);
	}

	/**
	 * Multiply multiplicand to an array. The result should be min <= result <= max
	 * 
	 * @param channel
	 * @param multiplicand
	 * @param min
	 * @param max
	 */
	public static void multiply(int[] channel, float multiplicand, int min, int max)
	{
		for(int i = 0; i < channel.length; i ++)
		{
			int v = (int)(channel[i] * multiplicand);
			if(v > max) v = max;
			else if(v < min) v = min;
			channel[i] = v;
		}
	}

	/**
	 * 
	 * Multiply a constant to src, and add two arrays
	 * 
	 * @param src
	 * @param srcPos
	 * @param multiplicand
	 * @param dst
	 * @param dstPos
	 * @param length
	 * @param min
	 * @param max
	 */
	public static void multiplyAndSum(int src[], int srcPos, float multiplicand, int[] dst, int dstPos, int length, int min, int max)
	{
		for(int i = 0; i < length; i ++)
		{
			int v = dst[i + dstPos] + (int)(src[i + srcPos] * multiplicand);
			if(v > max) v = max;
			else if(v < min) v = min;
			dst[i + dstPos] = v;
		}
	}

	/**
	 * Add two arrays
	 * 
	 * @param src
	 * @param srcPos
	 * @param dst
	 * @param dstPos
	 * @param length
	 * @param min
	 * @param max
	 */
	public static void sumOf(int[] src, int srcPos, int[] dst, int dstPos, int length, int min, int max)
	{
		for(int i = 0; i < length; i++)
		{
			int v = dst[i + dstPos] + src[i + srcPos];
			if(v > max) v = max;
			else if(v < min) v = min;
			dst[i + dstPos] = v;
		}
	}

	/**
	 * Merge multiple arrays to one array
	 * 
	 * @param channels
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] sumOf(int[][] channels, int min, int max)
	{
		int numChannels = channels.length;
		if(numChannels < 1) return new int[0];
		if(numChannels < 2) return channels[0];
		
		int maxLength = 0;
		for(int[] ch : channels)
		{
			if(maxLength < ch.length)
				maxLength = ch.length;
		}

		// Get sum of arrays
		int[] sum = new int[maxLength];
		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < channels[i].length; j ++)
			{
				int v = sum[j] + channels[i][j];
				if(v > max) v = max;
				else if(v < min) v = min;
				sum[j] = v;
			}
		}

		return sum;
	}

	/**
	 * Merge multiple arrays to one array
	 * 
	 * @param channels
	 * @param balance
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] sumOf(int[][] channels, float balance, int min, int max)
	{
		int numChannels = channels.length;
		if(numChannels < 1) return new int[0];
		if(numChannels < 2) return channels[0];
		
		int maxLength = 0;
		for(int[] ch : channels)
		{
			if(maxLength < ch.length)
				maxLength = ch.length;
		}

		// Add arrays
		int[] sum = new int[maxLength];
		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < channels[i].length; j ++)
			{
				int v = sum[j];
				v += (int)(channels[i][j] * balance);
				if(v > max) v = max;
				else if(v < min) v = min;
				sum[j] = v;
			}
		}

		return sum;
	}

	/**
	 * Merge multiple arrays to one array
	 * 
	 * @param channels
	 * @param balance
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] sumOf(int[][] channels, float[] balance, int min, int max)
	{
		int numChannels = channels.length;
		if(numChannels < 1) return new int[0];
		if(numChannels < 2) return channels[0];
		
		int maxLength = 0;
		for(int[] ch : channels)
		{
			if(maxLength < ch.length)
				maxLength = ch.length;
		}

		// Add arrays
		int[] sum = new int[maxLength];
		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < channels[i].length; j ++)
			{
				int v = sum[j];
				v += (int)(channels[i][j] * balance[i]);
				if(v > max) v = max;
				else if(v < min) v = min;
				sum[j] = v;
			}
		}

		return sum;
	}

	/**
	 * <p>
	 * Merge multiple channels to one channel
	 * </p>
	 * <p>
	 * If arrays a, b are given as parameters
	 * <ul>
	 * <li>a = new int[]{1,2,3,4};</li>
	 * <li>b = new int[]{5,6,7,8};</li>
	 * </ul>
	 * The result is given by
	 * <pre>
	 * 1,5,2,6,3,7,4,8
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param channels
	 * @param balance
	 *            1.0: As is, 0.0: no output
	 * @param min
	 * @param max
	 * @return
	 */
	public static int[] mergeChannels(int[][] channels, float[] balance, int min, int max)
	{
		int numChannels = channels.length;
		if(numChannels < 1) return new int[0];
		if(numChannels < 2) return channels[0];
		
		int maxLength = 0;
		for(int[] ch : channels)
		{
			if(maxLength < ch.length)
				maxLength = ch.length;
		}
		
		int[] merge = new int[maxLength * numChannels];
		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < channels[i].length; j ++)
			{
				int v = (int)(channels[i][j] * balance[i]);
				if(v > max) v = max;
				else if(v < min) v = min;
				merge[j * numChannels + i] = v;
			}
		}

		return merge;
	}

	

	/**
	 * <p>
	 * Merge multiple channels to one channel
	 * </p>
	 * <p>
	 * If arrays a, b are given as parameters
	 * <ul>
	 * <li>a = new int[]{1,2,3,4};</li>
	 * <li>b = new int[]{5,6,7,8};</li>
	 * </ul>
	 * The result is given by
	 * <pre>
	 * 1,5,2,6,3,7,4,8
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param channels
	 * @return
	 */
	public static int[] mergeChannels(int[][] channels)
	{
		int numChannels = channels.length;
		if(numChannels < 1) return new int[0];
		if(numChannels < 2) return channels[0];
		
		int maxLength = 0;
		for(int[] ch : channels)
		{
			if(maxLength < ch.length)
				maxLength = ch.length;
		}

		int[] merge = new int[maxLength * numChannels];
		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < channels[i].length; j ++)
				merge[j * numChannels + i] = channels[i][j];
		}

		return merge;
	}

	/**
	 * <p>
	 * Split one channel to multiple channels
	 * </p>
	 * <p>
	 * If the below array is given and channel of array is 2
	 * 
	 * <pre>
	 * 1,5,2,6,3,7,4,8
	 * </pre>
	 * 
	 * it is splitted to the below two arrays
	 * <ul>
	 * <li>{1,2,3,4}</li>
	 * <li>{5,6,7,8}</li>
	 * </ul>
	 * </p>
	 * *
	 * 
	 * @param channel
	 * @param numChannels
	 * @return
	 */
	public static int[][] splitChannel(int[] channel, int numChannels)
	{
		// The length of array should be multiples of channel
		if(channel.length % numChannels != 0)
		{
			throw new IllegalArgumentException("The specified 'array' should be a multiple of the specified 'channel'");
		}

		int len = channel.length / numChannels;
		int div[][] = new int[numChannels][len];

		for(int i = 0; i < numChannels; i ++)
		{
			for(int j = 0; j < len; j ++)
				div[i][j] = channel[j * numChannels + i];
		}

		return div;
	}
}
