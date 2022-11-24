package DifferentWayToPostBody;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectWithHashMap {
	@Test
	public void createProject()
	{
		HashMap<Object, Object> hash = new HashMap<Object, Object>();
		 hash.put("createdBy", "Ramesh");
		 hash.put("projectName", "Lara classified"+new RandomNumber().getrandomNumber(1000));
		 hash.put("status", "created");
		 hash.put("teamSize", 14);
		 
		//step-1 Pre-conditions
		 given()
		 .body(hash)
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
