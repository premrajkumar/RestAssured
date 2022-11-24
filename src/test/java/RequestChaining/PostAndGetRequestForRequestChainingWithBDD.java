package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostAndGetRequestForRequestChainingWithBDD {
	@Test
	public void createAndGetRequestByPathParameter()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		 
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified"+ran);
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 
		 Response request = given().body(jobj).contentType(ContentType.JSON)
		 .when().post("/addProject");
		 
		 String proid = request.jsonPath().get("projectId");
		 System.out.println(proid);
		 request.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		 
		 given().pathParam("prid", proid)
		 .when().get("/projects/{prid}")
		 .then().assertThat().statusCode(200).log().all();
		
	}
	
	@Test
	public void createAndGetRequestByVariable()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		 
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		JSONObject jobj = new JSONObject();
		 jobj.put("createdBy", "Ramesh");
		 jobj.put("projectName", "Lara classified"+ran);
		 jobj.put("status", "created");
		 jobj.put("teamSize", 14);
		 
		 Response request = given().body(jobj).contentType(ContentType.JSON)
		 .when().post("/addProject");
		 
		 String proid = request.jsonPath().get("projectId");
		 System.out.println(proid);
		 request.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		 
		 //given().pathParam("prid", proid)
		 when().get("/projects/"+proid)
		 .then().assertThat().statusCode(200).log().all();
		
	}


}
