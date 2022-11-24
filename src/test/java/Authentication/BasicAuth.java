package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth 
{
	@Test
	public void basicAuth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202).log().all();
	}
	
	@Test
	public void preEmptiveAuth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202).log().all();
	}
	
	@Test
	public void basicDigestiveAuth()
	{
		baseURI="http://rmgtestingserver";
		port=8084;
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then()
		.assertThat()
		.statusCode(202).log().all();
	}
	
	
	

}
