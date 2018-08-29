import java.util.Scanner;
/*
	Do not modify this main function.
	*/
/**
 * Class for solution.
 */
public class Solution {
    private Solution() {
        //constructor is used.
    }

    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);      
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gc = gcd(n1,n2);
        System.out.println(gc);
    }
    /*
	Need to write the gcd function and print the output.
	*/
    public static int gcd(int n1, int n2) {
        int i, temp = 0;
        for(i = 1; i <= n1 && i <= n2; i++) {
            if(n1 % i == 0 && n2 % i == 0) {
                temp = i;
            }
        }
        return temp;
    }
}
