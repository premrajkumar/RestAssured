package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostAndGetRequestForRequestChainingWithoutBDD_SingleTest {
		
	@Test
	public void CreateProjectByRequestChaining()
	{
		//As we using POST http method-->creating the body
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		 JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified"+ran);
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 
		 //preconditions
		 RequestSpecification reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.post("http://rmgtestingserver:8084/addProject");
		 String value = response.jsonPath().get("projectId");
		 System.out.println(value);
		 ValidatableResponse val = response.then();
		 val.assertThat().statusCode(201);
		val.log().all();
		 
		 
		 reqspec.pathParam("pid", value);
		Response response1 = reqspec.get("http://rmgtestingserver:8084/projects/{pid}");
		response1.getContentType();
		ValidatableResponse val1 = response1.then();
		val1.assertThat().statusCode(200);
		val1.log().all();
		
	}
	

}
