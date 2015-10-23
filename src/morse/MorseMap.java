package morse;

import java.util.HashMap;

import utils.Cons;

/**
 * @author Manuel Palomo <manuel_palomo@hotmail.es> Class MorseDictionary This
 *         is a data structure containing all the necessary methods for handling
 *         morse to text translation It varies in content depending on what
 *         morse system is used(international or extended)
 * 
 *         Extended has non-English variants Dot(.) and dash (-)
 * 
 */
public class MorseMap {
	private HashMap<String, String> codes;
	private String morseSystem;

	/**
	 * Default constructor, if no system is inputed, default is international
	 * system
	 */
	public MorseMap() {
		this.morseSystem = Cons.INTERNATIONAL;
		codes = new HashMap<String, String>();
	}

	/**
	 * If a boolean is provided, create and load the map with the corresponding
	 * codes
	 * 
	 * @param morseSystem
	 */
	public MorseMap(String morseSystem) {
		this.morseSystem = morseSystem;
		codes = new HashMap<String, String>();
		switch (morseSystem) {
		case Cons.EXTENDED:
			fillMapWithExtendedCode(codes);
			break;
		case Cons.INTERNATIONAL:
			fillMapWithInternationalCode(codes);
			break;
		}

	}

	/**
	 * Fills the map passed as parameter with the International morse codes
	 * 
	 * @param map
	 *            map to be filled
	 */
	public void fillMapWithInternationalCode(HashMap<String, String> map) {
		map.put("A", ".-");
		map.put("B", "-...");
		map.put("C", "-.-.");
		map.put("D", "-..");
		map.put("E", ".");
		map.put("F", "..-.");
		map.put("G", "--.");
		map.put("H", "....");
		map.put("I", "..");
		map.put("J", ".---");
		map.put("K", "-.-");
		map.put("L", ".-..");
		map.put("M", "--");
		map.put("N", "-.");
		map.put("O", "---");
		map.put("P", ".--.");
		map.put("Q", "--.-");
		map.put("R", ".-.");
		map.put("S", "...");
		map.put("T", "-");
		map.put("U", "..-");
		map.put("V", "...-");
		map.put("W", ".--");
		map.put("X", "-..-");
		map.put("Y", "-.--");
		map.put("Z", "--..");
		map.put("1", ".----");
		map.put("2", "..---");
		map.put("3", "...--");
		map.put("4", "....-");
		map.put("5", ".....");
		map.put("6", "-....");
		map.put("7", "--...");
		map.put("8", "---..");
		map.put("9", "----.");
		map.put("0", "-----");

	}

	/**
	 * Fills the map passed as parameter with the Extended morse codes
	 * 
	 * @param map
	 *            map to be filled
	 */
	public void fillMapWithExtendedCode(HashMap<String, String> map) {
		map.put("A", ".-");
		map.put("B", "-...");
		map.put("C", "-.-.");
		map.put("D", "-..");
		map.put("E", ".");
		map.put("F", "..-.");
		map.put("G", "--.");
		map.put("H", "....");
		map.put("I", "..");
		map.put("J", ".---");
		map.put("K", "-.-");
		map.put("L", ".-..");
		map.put("M", "--");
		map.put("N", "-.");
		map.put("O", "---");
		map.put("P", ".--.");
		map.put("Q", "--.-");
		map.put("R", ".-.");
		map.put("S", "...");
		map.put("T", "-");
		map.put("U", "..-");
		map.put("V", "...-");
		map.put("W", ".--");
		map.put("X", "-..-");
		map.put("Y", "-.--");
		map.put("Z", "--..");
		map.put("1", ".----");
		map.put("2", "..---");
		map.put("3", "...--");
		map.put("4", "....-");
		map.put("5", ".....");
		map.put("6", "-....");
		map.put("7", "--...");
		map.put("8", "---..");
		map.put("9", "----.");
		map.put("0", "-----");
		map.put(".", ".-.-.-");
		map.put(",", "--..--");
		map.put("?", "..--..");
		map.put("'", ".----.");
		map.put("!", "-.-.--");
		map.put("/", "-..-.");
		map.put("(", "-.--.");
		map.put(")", "-.--.-");
		map.put("&", ".-...");
		map.put(":", "---...");
		map.put(";", "-.-.-.");
		map.put("=", "-...-");
		map.put("+", ".-.-.");
		map.put("-", "-....-");
		map.put("_", "..--.-");
		map.put("\"ROM\"", ".-..-."); // "
		map.put("$", "...-..-");
		map.put("@", ".--.-.");
		map.put("ç", "-.-..");
		map.put("é", "..-..");
		map.put("ó", "---.");
		map.put("", "");
		map.put("", "");

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
//		if (code.equals(null)) {
//			code = "?";
//		}
		return code;
	}

	public String getMorseSystem() {
		return morseSystem;
	}

}
