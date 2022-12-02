package Prem;

import java.util.Scanner;

import org.testng.annotations.Test;

public class CheckDigits1 {
	@Test
	public void main()
	{
		int no = new Scanner(System.in).nextInt();
		int num1 = no*2;
		int sum=0;
		int sum1=0;
		
		while(no!=0)
		{
			int rem = no%10;
			sum=sum+rem;
			no=no/10;
		}
		
		while(num1!=0)
		{
			int rem1=num1%10;
			sum1=sum1+rem1;
			num1=num1/10;
		}
		
		if(sum==sum1)
		{
			System.out.println("Number is similar");
		}
		else
		{
			System.out.println("Number is not similar");
		}
	}

}
