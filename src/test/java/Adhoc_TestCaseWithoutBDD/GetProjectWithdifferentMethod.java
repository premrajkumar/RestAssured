package Adhoc_TestCaseWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProjectWithdifferentMethod {
	@Test
	public void getAllproject()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.post("http://rmgtestingserver:8084/projects");
		response.getContentType();
		response.prettyPrint();
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
