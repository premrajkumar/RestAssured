package Prem;

import org.testng.annotations.Test;

public class ArrayRotationProgram {
	
	@Test
	public void main()
	{
		int[] arr= {1,7,19,24,25,32,42};
		for(int j=0;j<3;j++)
		{
		int temp = arr[0];
		for(int i=0;i<arr.length-1;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=temp;
		
		for(int k=0;k<arr.length;k++)
		{
		System.out.print(arr[k]+" ");
		}
		System.out.println();
	}

	}

}
