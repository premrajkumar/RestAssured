package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetProjectWithDiffURL {
	@Test
	public void getAllProjects()
	{
		//step-1 actions or executions
		when()
		.get("http://rmgtestingserver:8741/projects/")
		
		//step-2 validation
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
