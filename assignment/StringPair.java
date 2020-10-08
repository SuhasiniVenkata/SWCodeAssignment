package assignment;
/**
 * Assign the String value to String and Reverses the words in the given string 
 * For ex. "abcde" --> "edcba"
 *
 * @param string, transposed
 *            Input sequence of words
 * @return String and String with reversed words
 */
public class StringPair {
	private String string = "";
	private String transposed = "";
/**
 * Assign the Input string to String 
 * And reversed String value will be assigned to transposed
 */
	public StringPair(String input) {
		this.string = input;
		this.transposed = new StringBuilder(input).reverse().toString();
	}

	public String getString() {
		return string;
	}

	public String getTransposed() {
		return transposed;
	}

}