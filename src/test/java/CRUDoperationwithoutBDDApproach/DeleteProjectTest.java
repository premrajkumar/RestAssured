package CRUDoperationwithoutBDDApproach;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProjectTest 
{
	@Test
	public void deleteproject()
	{
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.delete("http://rmgtestingserver:8084/projects/TY_PROJ_994");
		response.getContentType();
		System.out.println(response.time());
		 System.out.println(response.timeIn(TimeUnit.SECONDS));
		 System.out.println(response.getSessionId());
		 System.out.println(response.getStatusLine());
		 System.out.println(response.getBody().prettyPrint());
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(204);
		validate.log().all();
	}
}
