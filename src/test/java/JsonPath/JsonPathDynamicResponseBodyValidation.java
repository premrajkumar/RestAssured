package JsonPath;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonPathDynamicResponseBodyValidation {
	@Test
	public void dynamicValidate()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("http://rmgtestingserver:8084/projects");
		response.getContentType();
		JsonPath path = response.jsonPath();
		String value = path.getString("projectName");
		//System.out.println(value);
		Assert.assertTrue(value.contains("maniqs12"));
		
	}
	
	@Test
	public void dynamicValidate1()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("http://rmgtestingserver:8084/projects");
		//response.getContentType();
		JsonPath path = response.jsonPath();
		List<String> value = path.get("projectName");
		System.out.println(value);
		boolean flag = false;
		for (String projectname : value) 
		{
			if(projectname.equalsIgnoreCase("maniqs12"))
			{
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("TC is Pass");
	}
	
	@Test
	public void dynamicValidate2()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("http://rmgtestingserver:8084/projects");
		//response.getContentType();
		JsonPath path = response.jsonPath();
		List<String> value = path.get("projectId");
		System.out.println(value);
		boolean flag = false;
		for (String projectname : value) 
		{
			if(projectname.equalsIgnoreCase("TY_PROJ_1013"))
			{
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("TC is Pass");
	}

}


