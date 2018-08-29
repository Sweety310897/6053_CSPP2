
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        int i;
        int temp = 1;
        for(i = 0;i<=n;i++){
        	temp = i;
        	while(temp!=i){
        		if(temp%10 == 7){
        			count++;
        		}
        		temp = temp/10;

        	}

        }
        System.out.println(count);
    }
}