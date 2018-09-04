import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * variable description.
     */
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
        return false;
    }

}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is used.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}



