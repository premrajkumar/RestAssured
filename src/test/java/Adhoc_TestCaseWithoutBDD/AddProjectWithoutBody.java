package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectWithoutBody {
	@Test
	public void addProject()
	{
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.post("http://rmgtestingserver:8084/addProject");
		 //validation
		 response.getContentType();
		 response.prettyPrint();
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(201);
		 validate.log().all();
		}
	

}
