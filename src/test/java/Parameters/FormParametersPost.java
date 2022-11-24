package Parameters;

import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class FormParametersPost {
	@Test
	public void formParametersPost()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		
		//step-1 pre-conditions
		given()
		.formParam("createdBy", "Ramesh")
		.formParam("projectName", "Lara classified"+ran)
		.formParam("status", "created")
		.formParam("teamSize", 14)
		.contentType(ContentType.JSON)
		 
		 //step-2 actions or executions
		 
		 .when()
		 .post("/addProject")
		 
		 //step-3 validation
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .statusLine("HTTP/1.1 201 ")
		 .time(org.hamcrest.Matchers.lessThan(1000L), TimeUnit.MILLISECONDS)
		 .log().all(); 
	}

}
