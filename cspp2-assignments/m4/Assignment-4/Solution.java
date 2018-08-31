// Given an String, Write a java method that returns the decimal value for the given binary string.
import java.util.Scanner;
/**
 * Class Solution
 */
public final class Solution
{/*
	Do not modify the main function 
	*/
	/**
	 * Constructs the object.
	 */
	private Solution()
	{
		//Constructor is used.
	}
	/**
	 * main function.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);
		
	}
	/**
	 * Reverse function
	 *
	 * @param      s     input string
	 *
	 * @return     returns the value
	 */
	public static String reverseString(final String s) {
		String temp = "";
		for (int i = s.length()-1; i >= 0 ; i-- ) {
			temp = temp + s.charAt(i);
		}
		return temp;
	}

}
