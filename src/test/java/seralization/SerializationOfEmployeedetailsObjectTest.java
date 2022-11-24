package seralization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesdetailswithObject;
import POJOclassforParsing.spouse;

public class SerializationOfEmployeedetailsObjectTest {
	@Test
	public void employeedetailsinobject() throws JsonGenerationException, JsonMappingException, IOException
	{
		spouse sp = new spouse("Rahul", 123, "hii");
		EmployeesdetailswithObject empdata = new EmployeesdetailswithObject("rahul", "123", 2451, "sscs", "bcfg", sp);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("EmployeedetailsObject.json"), empdata);
	}

}
