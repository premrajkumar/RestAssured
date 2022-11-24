package seralization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesDetailsWithStringArray;

public class SeralizationOfemployeedetailsInStringArray {
	@Test
	public void employeedetailsinstringarray() throws Throwable, JsonMappingException, IOException
	{
		String[] email= {"rahul97@gamil.com","ramesh87@gamil.com"};
		EmployeesDetailsWithStringArray empdata = new EmployeesDetailsWithStringArray("Rahul", "hello", "hi", email);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("EmployeedetailsInStringArray.json"), empdata);
	}

}
