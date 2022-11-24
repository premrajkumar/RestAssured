package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetOneprojectWithoutUrl {
	@Test
	public void getOneProject()
	{
		//step-1 actions or executions
		when()
		.get()
		
		//step-2 validation
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.statusLine("HTTP/1.1 200 ")
		.time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		.log().all();
	}


}
