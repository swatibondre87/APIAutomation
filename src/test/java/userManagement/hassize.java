package userManagement;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class hassize {
	@Test
	public void validateResponseHasSize() {
		// Set base URI for the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Send a GET request and store the response in a variable
		Response response = given()
				.when()
				.get("/comments")
				.then()
				.extract()
				.response();

		// Use Hamcrest to check that the response body has a specific size
		assertThat(response.jsonPath().getList(""), hasSize(500));
	}
}



