import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor is used
    }
    /*
    Do not modify this main function.
    */
    /**
     * This is main function.
     *
     * @param      args  string arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
    */
    /**
     * this function is to calculate power.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     returns the result of base power.
     */
    public static long power(final int base, final int exponent) {
        if (exponent > 0) {
            return base * power(base, exponent - 1);
        }
        return 1;
    }
}




