package Prem;

public class MissingNumber {
	public static void main(String args[]) {
	       int[] arr={2,4,8,12,16,20};
	       int[] c=new int[15];
	       int j=0;
	       for(int i=0;i<arr.length-1;i++)
	       {
	           int diff=arr[i+1]-arr[i];
	           int count=1;
	           while(diff>1)
	           {
	               //System.out.println(arr[i]+count+" ");
	               c[j]=arr[i]+count;
	               j++;
	               count++;
	               diff--;
	           }
	       }
	       
	    for(int k=0;k<c.length;k++)
	    {
	        if(c[k]==6 || c[k]==10 || c[k]==14 || c[k]==18)
	        {
	            System.out.println(c[k]+" ");
	        }
	    }
	}
}
