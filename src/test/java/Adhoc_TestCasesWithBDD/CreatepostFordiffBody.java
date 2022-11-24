package Adhoc_TestCasesWithBDD;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

public class CreatepostFordiffBody {
	@Test
	public void createProject()
	{
		int ran = new RandomNumber().getrandomNumber(1000);
		JSONObject jobj = new JSONObject();
		 jobj.put("createvcvgdBy", "Ramesh");
		 jobj.put("projvvnectName", "Lara classified"+ran);
		 jobj.put("stathbbbus", "created");
		 jobj.put("teajbbbmSize", 14);
		 
		 //step-1 Pre-conditions
		 given()
		 .body(jobj)
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
