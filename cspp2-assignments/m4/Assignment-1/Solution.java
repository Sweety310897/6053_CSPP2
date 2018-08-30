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
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = s.nextInt();
		}
		int max = a[0];
		for (int i = 1; i < size; i++) {
			//System.out.println(max);
			if(a[i] > max) {
				max = a[i];
			}
		}
		System.out.println(max);
	}
}
