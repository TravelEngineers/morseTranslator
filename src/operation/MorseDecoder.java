package operation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import morse.MorseMap;

/**
 * Class MorseDecoder
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 *         This class handles the decoding operation, including file inputting
 *         and outputting in both morse systems
 * 
 *         Formatting:
 * 
 *         In between each character, it uses a single space (" "). In between
 *         each words, it uses double space ("  ")
 *
 */
public class MorseDecoder {
	private String fileInputPath;
	private MorseMap codes;

	public MorseDecoder() {
		super();
	}

	public MorseDecoder(String fileInputPath, MorseMap codes) {
		this.fileInputPath = fileInputPath;
		this.codes = codes;
	}

	/**
	 * Handles the text in the class attribute and creates a decoded file with
	 * the contents.
	 * 
	 * If the file already exists, PrintWriter will truncate it
	 */
	public void decode(String fileOutputPath) {
		Scanner scanner;
		try {
			// Open the file
			scanner = new Scanner(new File(fileInputPath));
			// Prepare the new file to be written
			PrintWriter writer = new PrintWriter(fileOutputPath, "UTF-8");

			while (scanner.hasNextLine()) {
				String lineDecoded = "";
				String line = scanner.nextLine();

				// Words are separated by two spaces
				String[] wordsInLine = line.split("\\s\\s");

				for (int i = 0; i < wordsInLine.length; i++) {
					String wordDecoded = "";
					// Each character is separated by one space

					String[] charactersInLine = wordsInLine[i].split("\\s");
					for (int j = 0; j < charactersInLine.length; j++) {
						if (charactersInLine[j].equals("")) {
							wordDecoded = wordDecoded + " ";
						} else {
							wordDecoded = wordDecoded + codes.getCodeLetter(charactersInLine[j]);
						}
					}
					// Add the decoded word into the line
					lineDecoded = lineDecoded + wordDecoded;
				}
				// Print the line
				writer.println(lineDecoded);
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
