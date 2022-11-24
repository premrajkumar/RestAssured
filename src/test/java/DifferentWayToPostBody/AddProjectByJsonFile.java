package DifferentWayToPostBody;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectByJsonFile {
	@Test
	public void createProjectByJsonFile()
	{
		File file = new File("./src/test/resources/post.json");
		given()
		.body(file)
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
