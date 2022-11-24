package Adhoc_TestCaseWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetProjectAddingObjectProject {
	@Test
	public void addProject()
	{
			//As we using POST http method-->creating the body
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified8");
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.get("http://rmgtestingserver:8084/projects/");
		 //validation
		 response.getContentType();
		 response.prettyPrint();//print only json body
		 response.peek();//print all values & json body in single line
		 response.print();//print only json body in single line
		 response.prettyPeek();//print all values simillar to (log().all())
		 ValidatableResponse validate = response.then();
		 validate.assertThat().contentType(ContentType.JSON);
		 validate.assertThat().statusCode(200);
		 validate.log().all();//print all values
		}
	

}
