package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

public class UpdateProjectWithDiffBody {
	@Test
	public void update()
	{
		int ran = new RandomNumber().getrandomNumber(100);
		JSONObject jobj = new JSONObject();
		 jobj.put("credBy", "Ramesh");
		 jobj.put("projvvectName", "Lara classified14"+ran);
		 jobj.put("projecbbbtId","TY_PROJ_4170");
		 jobj.put("creaccctedOn", "07/11/2022");
		 jobj.put("stdvdvatus", "created");
		 
		 
		 //step-1 Pre-conditions
		 given()
		 .body(jobj)
		 .contentType(ContentType.JSON)
		 
		 //step-2 actions or executions
		 
		 .when()
		 .put("http://rmgtestingserver:8084/projects/TY_PROJ_4170")
		 
		 //step-3 validation
		 .then()
		 .statusCode(200)
		 .statusLine("HTTP/1.1 200 ")
		 .time(org.hamcrest.Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		 .log().all();
		 
		 
	}

}
