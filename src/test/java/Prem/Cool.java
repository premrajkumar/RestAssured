package Prem;

public interface Cool {
	
	int y=10;
	
}

interface Tester
{
	void disp();
}

class Sample1 implements  Cool,Tester
{
	public void disp()
	{
		System.out.println("hi");
	}

}

class MultipleInheritance1 {
	public static void main(String[] args) {
		Sample s1=new Sample();
	System.out.println(s1.y);
	s1.disp();
	}

}

