
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        long n = s.nextInt();
        long count = 0;
        int i;
        for(i = 0;i<n;i++){
        	if(i%10 == 7){
        		count++;
        	}
        	if(i/10 == 7){
        		count++;
        	}

        }
        System.out.println(count);
    }
}