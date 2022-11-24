package seralization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeeDetails;

public class SerializationOfEmployeedetailsTest 
{
	@Test
	public void employeeDetails() throws JsonGenerationException, JsonMappingException, IOException
	{
		//step-1 create object for the POJO class
		EmployeeDetails empdata=new EmployeeDetails("as", "tyss", 12, "banglore", "as54@gmail.com");
		//step-2 create the object for the object mapper
		ObjectMapper obj = new ObjectMapper();
		//step-3 write the values to json file
		obj.writeValue(new File("employeeDetail.json"), empdata);
	}
}
