package Prem;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

public class OccuranceOfDigit {
	@Test
	public void main()
	{
		String s="premkumar";
		int count=0;
		//LinkedHashMap<Character, Integer> list = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char s1=s.charAt(i);
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)==s1)
				{
					count++;
					//list.put(s.charAt(i), count);
				}	
			}
			System.out.println(s1+"  "+count);	
		}
	}

}
