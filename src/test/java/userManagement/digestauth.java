package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;

public class digestauth {
	@Test(description = "Validate the status code for GET users endpoint")
	public void validateResponseBodyGetDigestAuth() {

	   Response resp = given()
	           .auth()
	           .digest("postman", "password")
	           .when()
	           .get("https://postman-echo.com/digest-auth"); //RestAssured

	   int actualStatusCode = resp.statusCode();  //RestAssured
	   assertEquals(actualStatusCode, StatusCode.SUCCESS.code); //Testng
	   System.out.println(resp.body().asString());

	}


}
