package Adhoc_TestCaseWithoutBDD;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GEtAllProjectwithDiffContentType {
	@Test
	public void getAllproject()
	{
		RequestSpecification reqspec = RestAssured.given();
		Response response = reqspec.get("http://rmgtestingserver:8084/projects");
		response.getContentType();
		response.prettyPrint();
		System.out.println(response.time());
		 System.out.println(response.timeIn(TimeUnit.SECONDS));
		 System.out.println(response.getSessionId());
		 System.out.println(response.getStatusLine());
		 System.out.println(response.getBody().prettyPrint());
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
	}

}
