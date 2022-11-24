package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken()
	{
		baseURI="https://api.github.com";
		JSONObject obj = new JSONObject();
		obj.put("name", "RestAssuredrepos1");
		
		given()
		.body(obj)
		.auth().oauth2("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")
		.contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		
		.then().assertThat().statusCode(201).log().all();
		
	}

}
