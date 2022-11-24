package EndToEndScenarios;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseAPIClass;
import GenericUtility.EndPointsLibrary;
import POJOclassforParsing.POJOClassForPostMethod;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class CreateProjectAndVerifyDatabase extends BaseAPIClass{
	
	@Test
	public void createProject() throws SQLException
	{
		
POJOClassForPostMethod post = new POJOClassForPostMethod("Ramesh", "maraclass"+jlib.getrandomNumber(1000), "created", 12);

		
//		ObjectMapper obj = new ObjectMapper();
//		 
//		obj.writeValue(new File("post1.json"), post);
//		File file = new File("post1.json");
		
		
		//step-1 pre- conditions
		Response resp = given()
		.body(post)
		.contentType(ContentType.JSON)
		
		//step-2 actions or executions
		.when()
		 .post(EndPointsLibrary.createProject);
		String data = rlib.getJsonData(resp, "projectId");
		System.out.println(data);
		
		String query2="select * from project;";
		String actdata = dlib.readDatafromDBAndValidate(query2, 1, data);
		
		Assert.assertEquals(data, actdata);
		System.out.println("TC is pass");
		 //step-3 validation
		 resp.then()
	 .log().all();
	}
}
