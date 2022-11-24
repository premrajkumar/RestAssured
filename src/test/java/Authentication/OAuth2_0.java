package Authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2_0 {
	
	@Test
	public void oauthAuthentication()
	{
	
		//Create a request to generate accesss token 
		Response resp = given()
		 .formParam("client_id", "my api")
		 .formParam("client_secret", "628dee350abc1270216ef590370a3317")
		 .formParam("grant_type", "client_credentials")
		 .formParam("redirect_uri", "http://example.com")
		 .formParam("code", "authorization_code")
		 
	    .when()
	     .post("http://coop.apps.symfonycasts.com/token");
		
		resp.then().log().all();
	     
	    //Capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		
		//Create another request and use the token to access the APIs
		given()
		 .auth().oauth2(token)
		 //.pathParam("USER_ID", 1914)
		 
		.when()
		 .post("http://coop.apps.symfonycasts.com/api/4027/eggs-count")
		 
		.then().log().all();
			 
	}
}
