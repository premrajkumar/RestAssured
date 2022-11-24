package POJOclassforParsing;

public class EmployeesdetailswithObject 
{
	//Step1-Declare The variable Globally
	String ename;
	String empid;
	int phoneNumber;
	String address;
	String emailID;
	Object spouse;
	
	//step2-Create the constructor for initialization
	public EmployeesdetailswithObject(String ename, String empid, int phoneNumber, String address, String emailID,
			Object spouse) {
		super();
		this.ename = ename;
		this.empid = empid;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.emailID = emailID;
		this.spouse = spouse;
	}

	public EmployeesdetailswithObject()
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public Object getSpouse() {
		return spouse;
	}

	public void setSpouse(Object spouse) {
		this.spouse = spouse;
	}
	
	

	
}
