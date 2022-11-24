package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParameterGet {
	@Test
	public void queryParameterGet()
	{
		baseURI="https://reqres.in";
		given()
		.queryParam("page", "2")
		.contentType(ContentType.JSON)
		.when()
		.get("/api/users")
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
	}

}
