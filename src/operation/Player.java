package operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import utils.Cons;

/**
 * Handles the morse sound
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 */
public class Player {
	private String fileInputPath;

	public Player(String fileInputpath) {
		this.fileInputPath = fileInputpath;
	}

	/**
	 * Generates a sound specified by it's parameters using a sinusoidal wave
	 * 
	 * @param hertz
	 *            Frecuency of the sounds
	 * @param millis
	 *            Total time the sound will be played
	 */
	private void soundGenerator(int hertz, int millis) {
		byte[] audioBuffer = new byte[1];

		AudioFormat audio = new AudioFormat(Cons.SAMPLERATE, 8, 1, true, false);
		try {
			SourceDataLine dataLine = AudioSystem.getSourceDataLine(audio);
			dataLine.open(audio);
			dataLine.start();

			for (int i = 0; i < millis * 8; i++) {
				double angle = i / (Cons.SAMPLERATE / hertz) * 2.0 * Math.PI;
				audioBuffer[0] = (byte) (Math.sin(angle) * 120.0 * 100);
				dataLine.write(audioBuffer, 0, 1);
			}
			dataLine.drain();
			dataLine.stop();
			dataLine.close();

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void play() {
		Scanner scanner;
		try {
			// Open the file
			scanner = new Scanner(new File(fileInputPath));

			while (scanner.hasNextLine()) {
				String lineDecoded = "";
				String line = scanner.nextLine();

			}

			// Close the open streams
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}