package DataProvider;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import POJOclassforParsing.POJOClassForPostMethod;
import io.restassured.http.ContentType;

public class GetDatafromExcel {
	@Test(dataProvider = "abde")
	public void createMultipleData(String CreatedBy, String ProjectName, String Status, int TeamSize)
	{
		POJOClassForPostMethod multidata = new POJOClassForPostMethod(CreatedBy, ProjectName, Status, TeamSize);
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
	
	
	@DataProvider(name="abde")
	public Object[][] getDataFromExcel1() throws EncryptedDocumentException, IOException
	{
		JavaUtility jv = new JavaUtility();
		int ran = jv.getrandomNumber(1000);
		ExcelUtility ex = new ExcelUtility();
		//Object[][] data = ex.getTwoDimensionalData("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1");
		Object[][] data= new Object[4][4];
		data[0][0]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 1, 0);
		data[0][1]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 1, 1)+ran;
		data[0][2]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 1, 2);
		data[0][3]=Integer.parseInt(ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 1, 3));
		
		data[1][0]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 2, 0);
		data[1][1]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 2, 1)+ran;
		data[1][2]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 2, 2);
		data[1][3]=Integer.parseInt(ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 2, 3));
		
		data[2][0]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 3, 0);
		data[2][1]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 3, 1)+ran;
		data[2][2]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 3, 2);
		data[2][3]=Integer.parseInt(ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 3, 3));
		
		data[3][0]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 4, 0);
		data[3][1]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 4, 1)+ran;
		data[3][2]=ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 4, 2);
		data[3][3]=Integer.parseInt(ex.getDataFromExcel("./src/test/resources/dataProvider Restassured.xlsx", "Sheet1", 4, 3));
		
		return data;
	}

}
