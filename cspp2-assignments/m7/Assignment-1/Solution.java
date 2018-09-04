import java.util.*;
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
	InputValidator(String temp) {
		this.input = temp;
	}
	boolean validateData() {
		if(input.length() >= 6) {
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
	public static void main(String args[]) {
    	Scanner s = new Scanner(System.in);
    	String input = s.next();
    	InputValidator i = new InputValidator(input);    	
    	System.out.println(i.validateData());
    }
}
