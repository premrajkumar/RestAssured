package CRUDOperationWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DeleteProject {
	@Test
	public void delete()
	{
		//step-1 actions or executions
		when()
		.delete("http://rmgtestingserver:8084/projects/TY_PROJ_930")
		
		//step-2 validations
		.then()
		.statusCode(204)
		.statusLine("HTTP/1.1 204 ")
		.time(org.hamcrest.Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
		.log().all();
	}

}
