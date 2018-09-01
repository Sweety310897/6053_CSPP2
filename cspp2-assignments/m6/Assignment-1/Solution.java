import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
	// write your code here
        int flag = 0;
        //int[] a = new int[100];
        //String s ="";
        for(int i = 1;i<=n;i++)
        {
            if(i%2!=0)
            {
                int temp = prime(i);
                //a = i;
                //System.out.println(temp);
            }
        }
        //System.out.println(temp);
        
        
    }
    static int prime(int n)
    {
        int flag = 0;
        for(int i =2;i<=n;i++)
        {
            if(n%i==0)
            {
                flag += 1;

            }
        }
        if(flag!=2)
        {
            System.out.println(n);
        }
        return 0;
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

