package Adhoc_TestCaseWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteProjectWithdiffUrl {
	@Test
	public void deleteproject()
	{
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.delete("http://rmgtestingserver:8008/projects/TY_PROJ_994");
		response.getContentType();
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(204);
		validate.log().all();
	}

}
