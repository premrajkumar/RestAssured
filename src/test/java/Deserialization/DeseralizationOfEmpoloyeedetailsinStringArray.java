package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesDetailsWithIntArray;
import POJOclassforParsing.EmployeesDetailsWithStringArray;

public class DeseralizationOfEmpoloyeedetailsinStringArray {
	@Test
	public void main() throws JsonParseException, JsonMappingException, IOException
	{
		//step-1: create a object for object mapper
		ObjectMapper obj = new ObjectMapper();
		//step2: read the value from object mapper
		EmployeesDetailsWithStringArray value = obj.readValue(new File("./EmployeedetailsInStringArray.json"), EmployeesDetailsWithStringArray.class);
		System.out.println(value.getEmpid());
		String[] arr = value.getEmailID();
		System.out.println(arr[1]);
	}

}
