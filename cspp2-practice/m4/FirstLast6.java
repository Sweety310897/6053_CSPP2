import java.util.Scanner;
public class FirstLast6
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int[] a= new int[size];
		for(int i = 0;i<size;i++)
		{
			System.out.println("enter num");
			a[i] = s.nextInt();
		}
		int temp = a.length;
		if(a[0]==6 || a[size-1]==6)
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("false");
		}
	}
}