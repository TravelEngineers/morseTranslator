package morse;

import java.util.HashMap;

import utils.Cons;

/**
 * Class MorseDictionary This is a data structure containing all the necessary
 * methods for handling morse to text translation It varies in content depending
 * on what morse system is used(international or extended)
 * 
 * Extended has non-English variants Dot(.) and dash (-)
 * 
 * 
 * @author Manuel Palomo <manuel_palomo@hotmail.es>
 * 
 * 
 */
public class MorseMap {
	private HashMap<String, String> codes;
	private String morseSystem;

	public MorseMap() {
		this.morseSystem = Cons.INTERNATIONAL;
		codes = new HashMap<String, String>();
		fillMapWithInternationalCode();
	}

	/**
	 * Fills the map passed as parameter with the International morse codes
	 * 
	 * @param codes
	 *            map to be filled
	 */
	public void fillMapWithInternationalCode() {
		codes.put("A", ".-");
		codes.put("B", "-...");
		codes.put("C", "-.-.");
		codes.put("D", "-..");
		codes.put("E", ".");
		codes.put("F", "..-.");
		codes.put("G", "--.");
		codes.put("H", "....");
		codes.put("I", "..");
		codes.put("J", ".---");
		codes.put("K", "-.-");
		codes.put("L", ".-..");
		codes.put("M", "--");
		codes.put("N", "-.");
		codes.put("O", "---");
		codes.put("P", ".--.");
		codes.put("Q", "--.-");
		codes.put("R", ".-.");
		codes.put("S", "...");
		codes.put("T", "-");
		codes.put("U", "..-");
		codes.put("V", "...-");
		codes.put("W", ".--");
		codes.put("X", "-..-");
		codes.put("Y", "-.--");
		codes.put("Z", "--..");
		codes.put("1", ".----");
		codes.put("2", "..---");
		codes.put("3", "...--");
		codes.put("4", "....-");
		codes.put("5", ".....");
		codes.put("6", "-....");
		codes.put("7", "--...");
		codes.put("8", "---..");
		codes.put("9", "----.");
		codes.put("0", "-----");

	}

	/**
	 * Puts the international morse system in reverse order where the key are
	 * the codes and the value are the character. Used for decoding. The
	 * standard operation from getting the key out of a value is a O(n)
	 * operation, so it's cheaper to add the codes when needed than to get the
	 * entrySet() and iterate searching for the correspondent value
	 * 
	 * @param codes
	 *            map to be filled
	 */
	public void fillMapWithInternationalCodeReversed() {
		codes.put(".-", "A");
		codes.put("-...", "B");
		codes.put("-.-.", "C");
		codes.put("-..", "D");
		codes.put(".", "E");
		codes.put("..-.", "F");
		codes.put("--.", "G");
		codes.put("....", "H");
		codes.put("..", "I");
		codes.put(".---", "J");
		codes.put("-.-", "K");
		codes.put(".-..", "L");
		codes.put("--", "M");
		codes.put("-.", "N");
		codes.put("---", "O");
		codes.put(".--.", "P");
		codes.put("--.-", "Q");
		codes.put(".-.", "R");
		codes.put("...", "S");
		codes.put("-", "T");
		codes.put("..-", "U");
		codes.put("...-", "V");
		codes.put(".--", "W");
		codes.put("-..-", "X");
		codes.put("-.--", "Y");
		codes.put("--..", "Z");
		codes.put(".----", "1");
		codes.put("..---", "2");
		codes.put("...--", "3");
		codes.put("....-", "4");
		codes.put(".....", "5");
		codes.put("-....", "6");
		codes.put("--...", "7");
		codes.put("---..", "8");
		codes.put("----.", "9");
		codes.put("-----", "0");
	}

	/**
	 * Returns the code assigned to the letter provided, if there is no mapped
	 * value, return an interrogant
	 * 
	 * @param character
	 * @return Morse code assigned to the letter provided
	 */
	public String getLetterCode(char character) {
		String code = codes.get(String.valueOf(character));
		if (code.equals(null)) {
			code = "?";
		}
		return code;
	}

	public String getCodeLetter(String code) {
		String letter = codes.get(code);
		if (letter.equals(null)) {
			letter = "?";
		}
		return letter;
	}

	public String getMorseSystem() {
		return morseSystem;
	}

}
