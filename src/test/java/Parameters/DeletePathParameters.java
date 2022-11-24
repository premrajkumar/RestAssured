package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeletePathParameters {
	@Test
	public void deleteparam()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.pathParam("pid", "TY_PROJ_884")
		.contentType(ContentType.JSON)
		.when()
		.delete("/projects/{pid}")
		.then()
		.statusCode(204)
		.log()
		.all();
		
	}

}
