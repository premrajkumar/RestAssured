package POJOclassforParsing;

public class EmployeesDetailsWithStringArray 
{
	//step1-Create the variables globally
	String ename;
	String empid;
	String address;
	String[] emailID;
	
	//step2-Create the constructor for initialization
	public EmployeesDetailsWithStringArray(String ename, String empid, String address, String[] emailID) 
	{
		this.ename = ename;
		this.empid = empid;
		this.address = address;
		this.emailID = emailID;
	}
	
	public EmployeesDetailsWithStringArray()
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String[] getEmailID() {
		return emailID;
	}


	public void setEmailID(String[] emailID) {
		this.emailID = emailID;
	}
	
	
	
	

}
