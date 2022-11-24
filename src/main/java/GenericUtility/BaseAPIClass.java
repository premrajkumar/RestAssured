package GenericUtility;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
	
public DatabaseUtility dlib= new DatabaseUtility();
public JavaUtility jlib=new JavaUtility();
public RestAssuredLibrary rlib= new RestAssuredLibrary();


@BeforeSuite
public void bsConfig() throws SQLException 
{
	dlib.getConnection();
	baseURI="http://rmgtestingserver";
	port=8084;	
}

@AfterSuite
public void asConfig()
{
	dlib.closeConnection();
}
}
