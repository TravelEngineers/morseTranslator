package operation;

import java.io.File;
import java.io.FileNotFoundException;
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
	 * Generates a sound specified by it's parameters
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
				audioBuffer[0] = (byte) (angle);

				dataLine.write(audioBuffer, 0, 1);
			}
			dataLine.drain();
			dataLine.stop();
			dataLine.close();

		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the file and generates a tone for each of it's characters
	 */
	public void play() {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fileInputPath));

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				char[] characters = line.toCharArray();
				for (char character : characters) {
					if (character == '.') {
						soundGenerator(Cons.morseFrequency, Cons.morseUnitDotTime);
					} else if (character == '-') {
						soundGenerator(Cons.morseFrequency, Cons.morseUnitDashTime);
					} else {
						try {
							Thread.sleep(Cons.morseUnitDashTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}

			}

			scanner.close();

		} catch (

		FileNotFoundException e)

		{
			e.printStackTrace();
		}
	}

}