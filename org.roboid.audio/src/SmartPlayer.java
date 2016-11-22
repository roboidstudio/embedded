import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Window;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.DataLine.Info;

import org.tritonus.lowlevel.lame.Lame;

public class SmartPlayer
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void printAudioFileFormatTypes()
	{
		AudioFileFormat.Type[] types = AudioSystem.getAudioFileTypes();
		for (int i = 0; i < types.length; i++)
		{
			if (i != 0) System.out.print(", ");
			System.out.print(types[i]);
		}
	}

	public static void main(String[] args)
	{
		System.out.print("write 지원가능한 파일 타입: ");
		printAudioFileFormatTypes();
		System.out.println();

		FileDialog fileDialog = new FileDialog((Dialog) null, "파일 열기", FileDialog.LOAD);
		AudioFormat audioFormat = null;
		AudioFileFormat audioFileFormat = null;
		AudioInputStream in = null;
		AudioFormat lineAudioFormat = null;
		File file = null;

		try
		{
			fileDialog.setVisible(true);
			if (fileDialog.getFile() == null) { return; }
			file = new File(fileDialog.getDirectory() + fileDialog.getFile());

			
			
			lineAudioFormat = new AudioFormat(44100, 16, 2, true, false);
			audioFileFormat = AudioSystem.getAudioFileFormat(file);
			audioFormat = audioFileFormat.getFormat();
			lineAudioFormat = audioFormat;
			//			in = AudioSystem.getAudioInputStream(	lineAudioFormat,
			//													AudioSystem.getAudioInputStream(file));
			in = AudioSystem.getAudioInputStream(file);
			System.out.println(audioFileFormat);

			//			// MP3 파일 변환 테스트
			//			System.out.println("MP3 파일 출력 테스트");
			//			File outFile = new File("out.mp3");
			//			AudioSystem
			//					.write(	AudioSystem
			//									.getAudioInputStream(	new AudioFormat(Lame.MPEG1L3, 44100, -1, 2, -1, -1, false),
			//															AudioSystem
			//																	.getAudioInputStream(	new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
			//																	                     	                44100,
			//																											16,
			//																											2,
			//																											4,
			//																											44100,
			//																											false),
			//																							AudioSystem
			//																									.getAudioInputStream(file))),
			//
			//							new AudioFileFormat.Type("MP3", "mp3"),
			//							outFile);
		}
		catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			fileDialog.dispose();
		}

		// 오디오 재생
		SourceDataLine line = null;
		try
		{
			line = (SourceDataLine) AudioSystem
					.getLine(new DataLine.Info(SourceDataLine.class, lineAudioFormat));
		}
		catch (IllegalArgumentException e)
		{
			System.err.println("해당 파일의 포맷으로 line을 얻을 수 없으므로 파일을 변환합니다");
			lineAudioFormat = new AudioFormat(44100, 16, 2, true, false);
			try
			{
				System.out.println("available: " + in.available());
				in = AudioSystem.getAudioInputStream(	lineAudioFormat,
														AudioSystem.getAudioInputStream(file));

				System.out.println("available: " + in.available());
				line = (SourceDataLine) AudioSystem
						.getLine(new DataLine.Info(SourceDataLine.class, lineAudioFormat));
			}
			catch (UnsupportedAudioFileException e1)
			{
				e1.printStackTrace();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
			catch (LineUnavailableException e1)
			{
				e.printStackTrace();
			}

		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}

		try
		{
			line.open(lineAudioFormat);
			line.start();
			int readBytes = 0;
			byte[] buffer = new byte[line.getBufferSize()];
			while ((readBytes = in.read(buffer)) != -1)
			{
				System.out.println("buffer size: " + line.getBufferSize());
				System.out.println("read size: " + readBytes);
				line.write(	buffer,
							0,
							readBytes);
			}

		}
		catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (line != null)
			{
				line.drain();
				line.stop();
				line.close();
			}
		}

	}
}