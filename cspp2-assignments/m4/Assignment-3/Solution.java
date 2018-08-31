// Given an String, Write a java method that returns
//the decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0;i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            //Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * To convert to binary.
     *
     * @param      s     string input
     *
     * @return     returns integer value
     */
    public static String binaryToDecimal(final String s) {
        double sum = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            char temp = s.charAt(i);
            int value = Character.getNumericValue(temp);
            sum += (value * Math.pow(2, (s.length() - 1) - i));
        }
        int  temp2 = (int) sum;
        String temp3 = Integer.toString(temp2);
        return temp3;
    }
}
