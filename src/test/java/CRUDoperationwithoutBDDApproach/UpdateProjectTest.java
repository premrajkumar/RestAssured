package CRUDoperationwithoutBDDApproach;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
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
		 Response response = reqspec.put("http://rmgtestingserver:8084/projects/TY_PROJ_994");
		 
		 //validation
		 response.getContentType();
		 System.out.println(response.time());
		 System.out.println(response.timeIn(TimeUnit.SECONDS));
		 System.out.println(response.getSessionId());
		 System.out.println(response.getStatusLine());
		 System.out.println(response.getBody().prettyPrint());
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
		 validate.log().all();
		}
	}


