package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class FormParameterPostReqRes {
	@Test
	public void formParameterPostReqRes()
	{
		baseURI="https://reqres.in";
		
		//step-1 pre-conditions
		given()
		.formParam("name", "premkumar")
		.formParam("job", "QA")
		.contentType(ContentType.JSON)
		 
		 //step-2 actions or executions
		 
		 .when()
		 .post("/api/users")
		 
		 //step-3 validation
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .statusLine("HTTP/1.1 201 ")
		 .time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		 .log().all();
	}

}
