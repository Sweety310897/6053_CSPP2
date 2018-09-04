import java.util.Scanner;
/*
    Do not modify this main function.
    */
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
     * This is for main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gc = gcd(n1, n2);
        System.out.println(gc);
    }
    /*
    Need to write the gcd function and print the output.
    */
    /**
     * This function is to calculate gcd.
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     returns gcd of the numbers.
     */
    public static int gcd(final int n1, final int n2) {
        int i, temp = 0;
        for (i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                temp = i;
            }
        }
        return temp;
    }
}




