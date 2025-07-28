package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import utils.JsonReader;

public class validateTestDataJson {
	@Test(description = "Validate the status code for GET users endpoint")
	public void validateWithTestDataFromJson() throws Exception {
		String username = JsonReader.getTestData("username");
		String password = JsonReader.getTestData("password");
		System.out.println("username from json is: " + username + " password from json is: " + password);

		Response resp = given()
				.auth()
				.basic(username, password)
			//	.basic(JsonReader.getTestData("username"), JsonReader.getTestData("password"))
				.when()
				.get("https://postman-echo.com/basic-auth"); //RestAssured

		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println("validateWithTestDataFromJson executed successfully");

	}

}
