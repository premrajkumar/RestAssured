package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatePostWithoutBody {
	@Test
	public void addProject()
	{
		//defect
			//As we using POST http method-->creating the body
		 //preconditions
		 given()
		 .contentType(ContentType.JSON)
		 
		 //step-2 actions or executions
		 
		 .when()
		 .post("http://rmgtestingserver:8084/addProject")
		 
		 //step-3 validation
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .statusLine("HTTP/1.1 201 ")
		 .time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		 .log().all();
		 
		 
	}

}
