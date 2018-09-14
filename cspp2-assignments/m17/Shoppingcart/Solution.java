import java.util.Scanner;
import java.util.Arrays;
final class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		for(int i = 0; i < testcases; i++) {
			String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
			String[] check = tokens[0].split(" ");
			System.out.println(Arrays.toString(check));
		}
	}
}