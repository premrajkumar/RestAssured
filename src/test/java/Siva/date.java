package Siva;

public class date {

	public static void main(String[] args) {
		String s="12-30-45 AM";
		String[] a = s.split("-");
		String[] b = s.split(" ");
		
		if (b[1].equals("AM")) {
			if (a[0].equals("12")) {
				a[0]="0";
			}
			
			for(int i=0; i<a.length;i++)
			{
			System.out.println(a[i]);
			}
		
		}
		else {
			System.out.println(s);
		}
	}
}
