package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateProjectWithoutBody {
	@Test
	public void update()
	{
		 //step-2 actions or executions
		 
		 when()
		 .put("http://rmgtestingserver:8084/projects/TY_PROJ_4170")
		 
		 //step-3 validation
		 .then()
		 .statusCode(200)
		 .statusLine("HTTP/1.1 200 ")
		 .time(org.hamcrest.Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		 .log().all();
		 
		 
	}


}
