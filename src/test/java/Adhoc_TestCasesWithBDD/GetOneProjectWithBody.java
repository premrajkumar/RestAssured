package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

public class GetOneProjectWithBody {
	@Test
	public void getOneProject()
	{
		int ran = new RandomNumber().getrandomNumber(1000);
		JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified"+ran);
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 
		 //step-1 Pre-conditions
		 given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
		//step-1 actions or executions
		.when()
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
