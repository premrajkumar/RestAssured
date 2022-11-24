package Deserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.EmployeesdetailsWithTwoSpouse;

public class DeserializationOfEmployeedetailsinSpouseObject {
	@Test
	public void deserialise() throws JsonParseException, JsonMappingException, IOException
	{
		//step-1: create a object for object mapper
				ObjectMapper obj = new ObjectMapper();
				//step2: read the value from object mapper
				EmployeesdetailsWithTwoSpouse value = obj.readValue(new File("./EmployeedetailsTwospouse.json"), EmployeesdetailsWithTwoSpouse.class);
				System.out.println(value.getEmpid());
				System.out.println(value.getSpouse());
		
		
	}

}
