package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAndGetRequestForRequestChainingWithoutBDD_DoubleTest {
	String value;
	RequestSpecification reqspec;	
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
		 reqspec = RestAssured.given();
		 reqspec.body(jobj);
		 reqspec.contentType(ContentType.JSON);
		 
		 //actions
		 Response response = reqspec.post("http://rmgtestingserver:8084/addProject");
		 value = response.jsonPath().get("projectId");
		 System.out.println(value);
	}
	
	@Test
	public void getProjectByRequestChaining()
	{
		reqspec.pathParam("pid", value);
		Response req = reqspec.get("http://rmgtestingserver:8084/projects/{pid}");
		req.getBody().prettyPrint();
	}
}
