package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectWithoutURL {
	@Test
	public void updateProject()
	{
		//As we using PUT http method-->updating the body
		 JSONObject jobj = new JSONObject();
		 jobj.put("projectId", "TY_PROJ_994");
		 jobj.put("projectName", "Ramesh");
		 jobj.put("teamSize", 0);
		 jobj.put("createdBy", "akash");
		 jobj.put("createdOn", "21/10/2022");
		 jobj.put("status", "notdone");
		 
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.put();
		 
		 //validation
		 response.getContentType();
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
		 validate.log().all();
		}

}
