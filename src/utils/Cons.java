package utils;

public final class Cons {
	public static final String INTERNATIONAL = "international";
	public static final int SAMPLERATE = 22050;
	
	// Acording to the wikipedia(wiki/Morse_code) 
	//this is the normal time in milliseconds
	public static final int morseUnitDotTime = 60;
	public static final int morseUnitDashTime = 180;
	
	public static final int morseFrequency = 882; //In hertz

	private Cons() {
		throw new AssertionError();
	}
}
