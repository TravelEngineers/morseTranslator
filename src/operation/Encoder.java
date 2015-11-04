package operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import morse.MorseMap;

/**
 * Handles the coding operation, including file inputting and
 * outputting morse 
 * 
 * Formatting:
 * 
 * In between each character, it uses a single space (" "). In between each
 * words, it uses double space ("  ")
 *
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 * 
 */
public class Encoder {
	private String fileInputPath;
	private MorseMap codes;

	/**
	 * Default constructor for coder
	 */
	public Encoder() {
		super();
	}

	public Encoder(String filePath, MorseMap codes) {
		this.fileInputPath = filePath;
		this.codes = codes;
	}

	/**
	 * Handles the text in the class attribute and creates a encoded file with
	 * the contents.
	 * 
	 * If the file already exists, PrintWriter will truncate it
	 */
	public void encode(String outputFileName) {
		Scanner scanner;
		try {
			// Open the file
			scanner = new Scanner(new File(fileInputPath));
			// Create the file to be written
			PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");

			while (scanner.hasNextLine()) {
				String lineEncoded = "";
				String line = scanner.nextLine();
				String[] wordsInLine = line.split("\\s");

				// Encoding each word separately
				for (int i = 0; i < wordsInLine.length; i++) {
					String wordEncoded = "";
					String word = wordsInLine[i].toUpperCase().replaceAll("[^\\p{ASCII}]", "");;
					// Encoding each char in the String
					for (int j = 0; j < word.length(); j++) {
						wordEncoded = wordEncoded + codes.getLetterCode(word.charAt(j)) + " ";
					}
					// Finally paste the word into the line String adding a
					// double space
					wordEncoded = wordEncoded + "  ";
					lineEncoded = lineEncoded + wordEncoded;

				}
				// Write the line to the file
				writer.println(lineEncoded);

			}
			// Close the open streams
			scanner.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

}
