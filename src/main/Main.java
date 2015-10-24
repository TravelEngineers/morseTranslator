package main;

import morse.MorseMap;
import operation.MorseDecoder;
import operation.MorseEncoder;
import utils.Cons;

/**
 * Class main
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 *         <mode><system><pathToFile> Usage: This program accepts three
 *         parameters. First parameter: -c (Code) -d (Decode) -p (Play)
 * 
 *         Second Parameter -i (International morse) -e (Extended morse)
 * 
 *         Third parameter: Path to the file to be encoded (ej: message.txt)
 * 
 *         Fourth parameter: Optional,name of the output file, default is
 *         morseoutput.txt
 *
 */
public class Main {
	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Incorrect number of arguments given. Usage: <mode><system><pathToFile>");
			System.exit(-1);
		} else {
			// Map creation and morse system
			String morseSystem = "";

			switch (args[1]) {
			case "-i":
				morseSystem = Cons.INTERNATIONAL;
				break;

			case "-e":
				morseSystem = Cons.EXTENDED;
				break;

			default:
				System.out.println("Undefined morse system");
				break;

			}
			MorseMap morse = new MorseMap(morseSystem);
			String outputFileName = "morseoutput.txt";
			if (args[3] != null) {
				outputFileName = args[3];
			}
			switch (args[0]) {
			case "-c": // Encode
				MorseEncoder encoder = new MorseEncoder(args[2], morse);
				encoder.encode(outputFileName);
				
				break;

			case "-d":// Decode
				morse.fillMapWithInternationalCodeReversed();
				MorseDecoder decoder = new MorseDecoder(args[2], morse);
				decoder.decode(outputFileName);
				System.exit(-1);
				break;

			case "-p":// Play
				break;

			default:
				System.out.println("Incorrect action given, Usage: <mode><system><pathToFile>");
				System.exit(-1);
				break;
			}
		}

	}
}
