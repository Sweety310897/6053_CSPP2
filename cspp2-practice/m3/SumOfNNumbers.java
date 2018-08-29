import java.util.*;
public class SumOfNNumbers{
	public static void main(String[] args) {
		int sum = 0;
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int i;
		for(i=0;i<=num;i++){
			sum = sum + i;

		}
		System.out.println(sum);
	}
}