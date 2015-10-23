package operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import morse.MorseMap;

/**
 * Class Coder
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 *         This class handles the coding operation, including file inputting and
 *         outputting in both morse systems
 * 
 *         Formatting:
 * 
 *         In between each character, it uses a single space (" "). In between
 *         each words, it uses double space ("  ")
 *
 */
public class MorseEncoder {
	private String filePath;
	private MorseMap codes;

	/**
	 * Default constructor for coder
	 */
	public MorseEncoder() {
		super();
	}

	public MorseEncoder(String filePath, MorseMap codes) {
		this.filePath = filePath;
		this.codes = codes;
	}

	/**
	 * Handles the text in the class attribute and creates a encoded file with
	 * the contents.
	 * 
	 * If the file already exists, PrintWriter will truncate it
	 */
	public void encodeText(String outputFileName) {
		Scanner scanner;
		try {
			// Open the file
			scanner = new Scanner(new File(filePath));
			// Create the file to be written
			PrintWriter writer = new PrintWriter(outputFileName, "UTF-8");

			while (scanner.hasNextLine()) {
				String lineEncoded = "";
				String line = scanner.nextLine();
				String[] wordsInLine = line.split("\\s");

				// Encoding each word separately
				for (int i = 0; i < wordsInLine.length; i++) {
					String wordEncoded = "";
					String word = wordsInLine[i].toUpperCase();
					// Encoding each char in the String
					for (int c = 0; c < word.length(); c++) {
						wordEncoded = wordEncoded + codes.getLetterCode(word.charAt(c)) + " ";
					}
					// Finally paste the word into the line String adding a
					// double space
					wordEncoded = wordEncoded + "  ";
					lineEncoded = lineEncoded + wordEncoded;
					System.out.println(lineEncoded);

					// Write the line to the file
					writer.println(lineEncoded);
				}

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
