
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution(){
		//constructor is used.
	}
/* Fill the main function to print the number of 7's between 1 to n*/
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        int i;
        int temp = 1;
        final int x = 10;
        final int y = 7;
        for (i = 0; i <= n; i++) {
        	temp = i;
        	while (temp != 0) {
        		if (temp % x == y) {
        			count++;
        		}
        		temp = temp / x;

        	}

        }
        System.out.println(count);
    }
}