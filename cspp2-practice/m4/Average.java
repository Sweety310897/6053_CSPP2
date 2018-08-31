import java.util.Scanner;
public class Average
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] a= new int[size];
		float sum = 0;
		for(int i = 0;i<size;i++)
		{
			System.out.println("enter num");
			a[i] = s.nextInt();
			sum += a[i];
		}
		System.out.println(sum/size);

	}
}