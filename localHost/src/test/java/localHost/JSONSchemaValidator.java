package localHost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaValidator {

	
	
	@Test
	public void SchamaValidation() {
		baseURI="https://reqres.in/";
		
		given().
		   get("api/users?page=2").
		then().
		       assertThat().body(matchesJsonSchemaInClasspath("schama.json")).
		    statusCode(200);
		    
		
	}
}
