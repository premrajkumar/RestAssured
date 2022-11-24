package seralization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesdetailsWithTwoSpouse;
import POJOclassforParsing.spouse;
import POJOclassforParsing.spouse1;

public class SerialisationOfEmployeeDetailsTwoSpouse {
	@Test
	public void main() throws JsonGenerationException, JsonMappingException, IOException
	{
		spouse sp = new spouse("assdf", 12, "jnbjbjhb");
		spouse1 sp1 = new spouse1("cgfcfd", 12,"bjbh");
		EmployeesdetailsWithTwoSpouse empdata = new EmployeesdetailsWithTwoSpouse("hjhhj", "huhhu", 12, "njjbj", "bjbhb", sp, sp1);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("EmployeedetailsTwospouse.json"), empdata);
	}

}
