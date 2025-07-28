package userManagement;

import org.testng.annotations.Test;

import core.StatusCode;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class allData {
	@Test
	public void testGetUsersWithQueryParameters() {
		RestAssured.baseURI = "https://reqres.in/api";

		Response response = given()
				.queryParam("page", 2)
				.when()
				.get("/users?page=2&per_page=3&api_key=reqres-free-v1")
				.then()
				.statusCode(StatusCode.SUCCESS.code)
				.extract()
				.response();

		// Assert that the response contains 6 users
		response.then().body("data", hasSize(3));

		// Assert that the first user in the list has the correct values
		response.then().body("data[0].id", is(4));
		response.then().body("data[0].email", is("eve.holt@reqres.in"));
		response.then().body("data[0].first_name", is("Eve"));
		response.then().body("data[0].last_name", is("Holt"));
		response.then().body("data[0].avatar", is("https://reqres.in/img/faces/4-image.jpg"));
	}
}



