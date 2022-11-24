package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithoutEndpoint {
	@Test
	public void addProject()
	{
		//defect
			//As we using POST http method-->creating the body
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", 12345);
		 jobj.put("projectName", 12245);
		 jobj.put("status", 14752);
		 jobj.put("teamSize", "14");
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.post("http://rmgtestingserver:8084/");
		 //validation
		 response.getContentType();
		 response.prettyPrint();
		 
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(201);
		 validate.log().all();
		}

}
