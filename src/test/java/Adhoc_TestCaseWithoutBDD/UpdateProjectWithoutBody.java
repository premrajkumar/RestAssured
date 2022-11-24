package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectWithoutBody {
	@Test
	public void updateProject()
	{		 
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 
		 //actions
		 Response response = reqspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_994");
		 
		 //validation
		 response.getContentType();
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
		 validate.log().all();
		}

}
