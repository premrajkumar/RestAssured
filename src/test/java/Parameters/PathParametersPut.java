package Parameters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PathParametersPut {
	@Test
	public void pathParametersPut()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("projectId", "TY_PROJ_884");
		jobj.put("projectName", "s3_SimpleProject_sss141");
		jobj.put("teamSize", 200);
		jobj.put("createdBy", "sujana4");
		jobj.put("createdOn", "21/10/2022");
		jobj.put("status", "string");
		
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.body(jobj)
		.pathParam("pid", "TY_PROJ_884")
		.contentType(ContentType.JSON)
		.when()
		.put("/projects/{pid}")
		.then()
		.statusCode(200)
		.log()
		.all();
		
	}

}
