package POJOclassforParsing;

public class EmployeesDetailsWithIntArray {
	
	//step1-Create the variables globally
	String ename;
	String empid;
	int[] phoneNumber;
	int salary;
	
	//step2-Create the constructor for initialization
	public EmployeesDetailsWithIntArray(String ename, String empid, int[] phoneNumber, int salary) {
		this.ename = ename;
		this.empid = empid;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
	}
	
	public EmployeesDetailsWithIntArray()
	{
		
	}

	//Step3-Create the getters and setters
	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public int[] getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
