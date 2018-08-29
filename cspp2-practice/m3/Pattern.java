import java.util.Scanner;
public class Pattern{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int i,j;
		for(i=1;i<=num;i++){
			for(j=1;j<=i;j++){
				System.out.print(j);
			}
			System.out.println( );
		}
	}
}