public class Factorial
{
	public static int factorial(int x)
	{
		if(x==0)
		{
			return 1;
		}
		if(x==1)
		{
			return 1;
		}
		else
		{
			return x * factorial(x-1);
		}

	}
	public static void main(String[] args)
	{
		int factorialvalue = factorial(5);
		System.out.println(factorialvalue);
	}

}