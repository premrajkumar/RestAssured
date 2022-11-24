package DifferentWayToPostBody;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJOclassforParsing.POJOClassForPostMethod;
import POJOclassforParsing.RandomNumber;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectByPOJOClass {
	@Test
	public void createProjectByPOJO() throws JsonGenerationException, JsonMappingException, IOException
	{
		
		POJOClassForPostMethod post = new POJOClassForPostMethod("Ramesh", "maraclass"+new RandomNumber().getrandomNumber(1000), "created", 12);

		
//		ObjectMapper obj = new ObjectMapper();
//		 
//		obj.writeValue(new File("post1.json"), post);
//		File file = new File("post1.json");
		
		
		//step-1 pre- conditions
		given()
		.body(post)
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
