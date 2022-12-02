package Prem;

public class SwapAlternate {
	 public static void main(String args[])
	    {
	     String s="This is Java Programming Questions";
	     String[] s1=s.split(" ");
	     for(int i=0;i<s1.length;i++)
	     {
	         if(i%2==0)
	         {
	        String  a=s1[i]; 
	        for(int j=a.length()-1;j>=0;j--)
	        {
	            System.out.print(a.charAt(j));
	        }
	         }
	         else{
	             System.out.println(s1[i]);
	         }
	     }
	    }
}
