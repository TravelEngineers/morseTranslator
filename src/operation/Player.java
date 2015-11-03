package operation;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

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

	public void soundGenerator(int hertz, int milliseconds) {
		byte[] buffer=new byte[1];
		float frequency = 44100; // Default sound frequency used in most places

		AudioFormat sound = new AudioFormat(frequency, 8, 1, true, false);

		try {
			SourceDataLine dataLine = AudioSystem.getSourceDataLine(sound);
			dataLine.open(sound);
			dataLine.start();

			// Generate the audio
			for (int i = 0; i < milliseconds * frequency / 1000; i++) {
				double angle = i / (frequency / hertz) * 2.0 * Math.PI;
				buffer[0] = (byte)(Math.sin(angle) * 100);
				
				dataLine.write(buffer, 0, 1);
			}
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}