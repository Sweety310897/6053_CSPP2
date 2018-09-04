import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
	private String input;
	
	/**
	 * Constructs the object.
	 *
	 * @param      temp  The temporary
	 */
	InputValidator(final String temp) {
		this.input = temp;
	}
	/**
	 * To return true or false.
	 *
	 * @return     returns boolean value.
	 */
	boolean validateData() {
		final int z = 6;
		if (input.length() >= z) {
			return true;
		}
		else {
			return false;
		}
	}

}
/**
 * Class for solution.
 */
public class Solution {
/**
 * Main function.
 */
	/**
	 * Main function.
	 */
	public static void main(final String[] args) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);
    	System.out.println(i.validateData());
    }
}
