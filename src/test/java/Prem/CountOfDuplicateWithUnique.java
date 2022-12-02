package Prem;

import java.util.HashMap;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class CountOfDuplicateWithUnique {
	@Test
	public void main()
    {
        String s="premkumar";
     HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
     for(int i=0;i<s.length();i++)
     {
         if(!hash.containsKey(s.charAt(i)))
         {
             hash.put(s.charAt(i),1);
         }
         else{
            int val=hash.get(s.charAt(i));
            val++;
            hash.put(s.charAt(i),val);
         }
     }
     for(Entry map:hash.entrySet())
     {
         System.out.println(map.getKey()+"  "+map.getValue());
     }
 
    }
	
	@Test
	public void main1()
	{
		String s="premkumar";
	     HashMap<Character,Integer> hash=new HashMap<Character,Integer>();
	     for(int i=0;i<s.length();i++)
	     {
	         if(!hash.containsKey(s.charAt(i)))
	         {
	             hash.put(s.charAt(i),1);
	         }
	         else{
	            int val=hash.get(s.charAt(i));
	            val++;
	            hash.put(s.charAt(i),val);
	         }
	     }
	     for(Entry map:hash.entrySet())
	     {
	         System.out.println(map.getKey()+"  "+map.getValue());
	     }
	 
	}

}
