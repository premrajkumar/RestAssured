package CRUDOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetOneProject {
	@Test
	public void getOneProject()
	{
		//step-1 actions or executions
		when()
		.get("http://rmgtestingserver:8084/projects/TY_PROJ_840")
		
		//step-2 validation
		.then()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.statusLine("HTTP/1.1 200 ")
		.time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		.log().all();
	}

}
