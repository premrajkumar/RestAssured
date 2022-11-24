package DifferentWayToPostBody;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

public class AddprojectByJsonObject {
	@Test
	public void createProjectByJsonObject()
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


