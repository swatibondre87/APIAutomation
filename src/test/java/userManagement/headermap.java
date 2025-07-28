package userManagement;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class headermap {
	@Test
	public void testTwoHeaderWithMap() {
		// Set base URI for the API
		RestAssured.baseURI = "https://reqres.in/api";

		// Create a Map to hold headers
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Authorization", "Bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx");

		// Send a GET request with headers
		given()
		.headers(headers)
		.when()
		.get("https://reqres.in/api/users/2?api_key=reqres-free-v1")
		.then()
		.statusCode(200);
		System.out.println("testTwoHeaderWithMap Executed Successfully");
	}
}



