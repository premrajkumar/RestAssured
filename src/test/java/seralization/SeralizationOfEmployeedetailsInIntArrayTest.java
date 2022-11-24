package seralization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesDetailsWithIntArray;

public class SeralizationOfEmployeedetailsInIntArrayTest {
	@Test
	public void employeeIntArray() throws Throwable, JsonMappingException, IOException
	{
		//to give value in integer array
		int[] a= {123456789,987654321};
		//create the object for pojo class
		EmployeesDetailsWithIntArray empdata = new EmployeesDetailsWithIntArray("Rahul", "1234", a, 40000);
		ObjectMapper obj = new ObjectMapper();
		obj.writeValue(new File("EmployeedetailsInIntArray.json"), empdata);
		
	}

}
