package ro.codewars.morsecode;

import java.util.HashMap;
import java.util.Map;

public final class MorseCode {

	private static Map<String, String> MORSE_CODE;
	
	static {
		MORSE_CODE = new HashMap<>();
		
		MORSE_CODE.put(".", "E");
		MORSE_CODE.put("..", "I");
		MORSE_CODE.put("...", "S");
		MORSE_CODE.put("....", "H");
		MORSE_CODE.put("-", "T");
		MORSE_CODE.put("--", "M");
		MORSE_CODE.put("---", "O");
		MORSE_CODE.put("----", "CH");
		
		MORSE_CODE.put(".-", "A");
		MORSE_CODE.put(".--", "W");
		MORSE_CODE.put(".---", "J");
		MORSE_CODE.put("-.", "N");
		MORSE_CODE.put("-..", "D");
		MORSE_CODE.put("-...", "B");
		
		MORSE_CODE.put(".-.", "R");
		MORSE_CODE.put(".--.", "P");
		MORSE_CODE.put("-.-", "K");
		MORSE_CODE.put("-..-", "X");
		
		MORSE_CODE.put(".-..", "L");
		MORSE_CODE.put("..-.", "F");
		MORSE_CODE.put("-.--", "Y");
		MORSE_CODE.put("--.-", "Q");
		
		MORSE_CODE.put("..-", "U");
		MORSE_CODE.put("...-", "V");
		MORSE_CODE.put("--.", "G");
		MORSE_CODE.put("--..", "Z");
		MORSE_CODE.put("-.-.", "C");
		
	}
	
	public static String get(String key) {
		return MORSE_CODE.getOrDefault(key, null);
	}
	
}
