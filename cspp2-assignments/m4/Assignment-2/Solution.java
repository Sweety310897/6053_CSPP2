import java.util.Scanner;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int rowsA = s.nextInt();
		//System.out.println("rowsA" + rowsA);
		int colsA = s.nextInt();
		//System.out.println("colsA" + colsA);
		//int sizeA = s.nextInt();
		//System.out.println("sizeA" + sizeA);

		

		int[][] sum= new int[rowsA][colsA];

		int[][] a= new int[rowsA][colsA];
		for(int i = 0; i<rowsA;i++)
		{
			for(int j = 0; j<colsA;j++)
			{
				a[i][j] = s.nextInt();
			}
			//System.out.println(a[i] + "a");
		} 
		//System.out.println(a);

		int rowsB = s.nextInt();
		//System.out.println("rowsB" + rowsB);
		int colsB = s.nextInt();
		//System.out.println("colsB" + colsB);
		//int sizeB = s.nextInt();
		//System.out.println("sizeB" + sizeB);

		int[][] b= new int[rowsB][colsB];
		for(int i = 0; i<rowsB;i++)
		{
			for(int j = 0; j<colsB;j++)
			{
				b[i][j] = s.nextInt();
			}
			//System.out.println(b[i] + "b");
		} 
		//System.out.println(b);
		for(int i = 0;i<rowsA;i++)
		{
			for(int j=0;j<colsA;j++)
			{
				sum[i][j] = a[i][j] + b[i][j];
				System.out.print(sum[i][j]+ " ");
			}
			System.out.println( );
		}

		
	}
}