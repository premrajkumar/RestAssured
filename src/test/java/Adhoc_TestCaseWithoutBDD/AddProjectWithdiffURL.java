package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithdiffURL {
	@Test
	public void addProject()
	{
			//As we using POST http method-->creating the body
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified7");
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.post("http://rmgtestingserver:8000/addProject");
		 //validation
		 response.getContentType();
		 response.prettyPrint();
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(201);
		 validate.log().all();
		}

}
