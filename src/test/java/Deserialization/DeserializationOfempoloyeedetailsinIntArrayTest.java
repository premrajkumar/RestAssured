package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeeDetails;
import POJOclassforParsing.EmployeesDetailsWithIntArray;

public class DeserializationOfempoloyeedetailsinIntArrayTest {
	@Test
	public void main() throws JsonParseException, JsonMappingException, IOException
	{
		//step-1: create a object for object mapper
		ObjectMapper obj = new ObjectMapper();
		//step2: read the value from object mapper
		EmployeesDetailsWithIntArray value = obj.readValue(new File("./EmployeedetailsInIntArray.json"), EmployeesDetailsWithIntArray.class);
		System.out.println(value.getEname());
		System.out.println(value.getEmpid());
		int[] arr = value.getPhoneNumber();
		System.out.println(arr[1]);
		
	}
}


