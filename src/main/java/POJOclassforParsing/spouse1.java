package POJOclassforParsing;

public class spouse1 {
	//Step1-Declare The variable Globally
			String ename;
			int phone;
			String email;
			
			//step2-Create the constructor for initialization
			public spouse1(String ename, int phone, String email) {
				super();
				this.ename = ename;
				this.phone = phone;
				this.email = email;
			}
			
			//Step3-Create the getters and setters
			public String getEname() {
				return ename;
			}
			public void setEname(String ename) {
				this.ename = ename;
			}
			public int getPhone() {
				return phone;
			}
			public void setPhone(int phone) {
				this.phone = phone;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			

}
