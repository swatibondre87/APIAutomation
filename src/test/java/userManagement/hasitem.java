package userManagement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class hasitem {

	@Test
	public void validateResponseHasItems() {
		// Set base URI for the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Send a GET request and store the response in a variable
		Response response = 
				given()
				.when()
				.get("/posts")
				.then()
				.extract()
				.response();

		// Use Hamcrest to check that the response body contains specific items
		assertThat(response.jsonPath().getList("title"), hasItems("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", "qui est esse"));
	}


}
