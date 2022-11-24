package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectWithDiffContent {
	@Test
	public void getAllProjects()
	{
		//step-1 actions or executions
		when()
		.get("http://rmgtestingserver:8084/projects/")
		
		//step-2 validation
		.then()
		.contentType(ContentType.TEXT)
		.statusCode(200)
		.time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
