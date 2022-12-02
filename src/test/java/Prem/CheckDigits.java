package Prem;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class CheckDigits {
	@Test
	public void main()
	{
		int num=142857;
		int res=num*2;
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		int count=0;
		while(num>0)
		{
			int r=num%10;
			list.add(r);
			count++;
			num=num/10;
		}
		
		while(res>0)
		{
			int r1=res%10;
			list1.add(r1);
			res=res/10;
		}
		
		int mycount=0;
		for(Integer li:list)
		{
			for(int i=0;i<list1.size();i++)
			{
				if(li==list1.get(i))
				{
					mycount++;
					list1.remove(i);
				}
			}
		}
		
		if(mycount==count)
		{
			System.out.println("ok");
		}
		else
		{
			System.out.println("not ok");
		}
	}

}
