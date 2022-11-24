package JsonPath;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class JsonPathStaticResponseBodyValidation {
	@Test
	public void validate()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("http://rmgtestingserver:8084/projects");
		response.getContentType();
		JsonPath path = response.jsonPath();
		Object value = path.get("[0].projectId");
		System.out.println(value);
		Assert.assertEquals(value, "TY_PROJ_1013");
		ValidatableResponse validate = response.then();
		validate.log().all();
		
	}

}
