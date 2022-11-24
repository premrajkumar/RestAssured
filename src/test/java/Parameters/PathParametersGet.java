package Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParametersGet {
	@Test
	public void pathParameters()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.pathParam("pid", "TY_PROJ_884")
		.contentType(ContentType.JSON)
		.when()
		.get("/projects/{pid}")
		.then()
		.statusCode(200)
		.log()
		.all();	
		
	}

}
