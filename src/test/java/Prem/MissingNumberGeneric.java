package Prem;

public class MissingNumberGeneric {
	public static void main(String[] args) {
	int[] arr={2,4,8,12,16,20};
    for(int i=0;i<arr.length-1;i++)
    {
        int diff=arr[i+1]-arr[i];
        int count=1;
        while(diff>1)
        {
            //System.out.println(arr[i]+count+" ");
            int sum=arr[i]+count;
            if(sum%2==0)
            {
            	System.out.println(sum);
            }
            count++;
            diff--;
        }
    }
	}
}
