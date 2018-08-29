public class area_of_Circle {
	
	public static double area(int r)
	{ 
		double area1 = pi() * r * r;
		return area1;
	}
	public static double pi()
	{
		double pi_value = 3.14;
		return pi_value;
	}
	public static void main(String[] args)
	{
		
		//area_of_Circle a = new area_of_Circle();
		//Scanner s = new Scanner(System.in);
		double areaofcircle = area(4);
		System.out.println(areaofcircle);
	}
}
