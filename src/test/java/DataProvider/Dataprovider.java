package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import POJOclassforParsing.POJOClassForPostMethod;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class Dataprovider 
{
	
	@Test(dataProvider = "abcd")
	public void createMultipleData(String CreatedBy, String ProjectName, String Status, int TeamSize)
	{
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		POJOClassForPostMethod multidata = new POJOClassForPostMethod(CreatedBy, ProjectName+ran, Status, TeamSize);
		given()
		.body(multidata)
		.contentType(ContentType.JSON)
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		.then()
		.assertThat()
		 .statusCode(201)
		 .statusLine("HTTP/1.1 201 ")
		 .time(org.hamcrest.Matchers.lessThan(2000L), TimeUnit.MILLISECONDS)
		 .log().all();
	}

	@DataProvider(name="abcd")
	public Object[][] getMultipleData()
	{
		Object[][] obj = new Object[3][4];
		
		obj[0][0]="Rahul";
		obj[0][1]="Remote TY";
		obj[0][2]="created";
		obj[0][3]=123;
		
		obj[1][0]="Sharath";
		obj[1][1]="hi";
		obj[1][2]="created";
		obj[1][3]=147;
		
		obj[2][0]="Ram";
		obj[2][1]="eshwar";
		obj[2][2]="created";
		obj[2][3]=258;
		
		return obj;
	}
	

}
