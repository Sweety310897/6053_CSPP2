import java.util.Scanner;
public class StudentDetails
{
	public static void main(String[] args) {
		 
		Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int rollno = sc.nextInt();
        double subj1 = sc.nextDouble();
        double subj2 = sc.nextDouble();
        double subj3 = sc.nextDouble();
        Student s = new Student(name,rollno,subj1,subj2,subj3);
	}
}
class Student{
	String name;
	int rollno;
	double subj1,subj2,subj3;

	public Student(String name,int rollno, double subj1, double subj2, double subj3)
	{
		this.name = name;
		this.rollno = rollno;
		this.subj1 = subj1;
		this.subj2 = subj2;
		this.subj3 = subj3;
		System.out.println((subj1+subj2+subj3)/3);
	}
}