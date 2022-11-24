package POJOclassforParsing;

public class EmployeesdetailsWithTwoSpouse {
	//Step1-Declare The variable Globally
		String ename;
		String empid;
		int phoneNumber;
		String address;
		String emailID;
		Object spouse;
		Object spouse1;
		
		//step2-Create the constructor for initialization
		public EmployeesdetailsWithTwoSpouse(String ename, String empid, int phoneNumber, String address, String emailID,
				Object spouse, Object spouse1) {
			this.ename = ename;
			this.empid = empid;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.emailID = emailID;
			this.spouse = spouse;
			this.spouse1=spouse;
			
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
		public Object getSpouse1() {
			return spouse1;
		}
		public void setSpouse1(Object spouse1) {
			this.spouse1 = spouse1;
		}
}
