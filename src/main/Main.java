package main;

import morse.MorseMap;
import operation.Decoder;
import operation.Encoder;
import operation.Player;
import utils.Cons;

/**
 * <mode><system><pathToFile> Usage: This program accepts three parameters.
 * First parameter: -c (Code) -d (Decode) -p (Play)
 * 
 * Second parameter: Path to the file to be encoded (ej: message.txt)
 * 
 * Third parameter: Optional,name of the output file, default is morseoutput.txt
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 * 
 */
public class Main {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Incorrect number of arguments given. Usage: <mode><pathToFile>");
			System.exit(-1);
		} else {
			MorseMap morse = new MorseMap();
			String outputFileName = "morseoutput.txt";
			if (args.length==3 && args[2] != null) {
				outputFileName = args[2];
			}
			switch (args[0]) {
			case "-c": // Encode
				Encoder encoder = new Encoder(args[1], morse);
				encoder.encode(outputFileName);

				break;

			case "-d":// Decode
				morse.fillMapWithInternationalCodeReversed();
				Decoder decoder = new Decoder(args[1], morse);
				decoder.decode(outputFileName);
				break;

			case "-p":// Play
				Player player = new Player(args[1]);
				player.play();
				break;

			default:
				System.out.println("Incorrect action given, Usage: <mode><system><pathToFile>");
				System.exit(-1);
				break;
			}
		}

	}
}
