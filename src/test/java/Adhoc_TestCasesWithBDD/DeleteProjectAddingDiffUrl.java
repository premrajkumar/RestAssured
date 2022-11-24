package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class DeleteProjectAddingDiffUrl {
	@Test
	public void delete()
	{
		//step-1 actions or executions
		when()
		.delete("http://rmgtestingserver:80dfd/projects/TY_PROJ_930")
		
		//step-2 validations
		.then()
		.statusCode(204)
		.statusLine("HTTP/1.1 204 ")
		.time(org.hamcrest.Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
