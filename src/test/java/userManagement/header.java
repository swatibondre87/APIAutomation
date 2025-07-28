package userManagement;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class header {
	@Test
	public void testGetUserListWithHeader() {



		given()
		.header("Content-Type", "application/json")

		.when()
		.get("https://reqres.in/api/users/2?api_key=reqres-free-v1")
		.then()
		.statusCode(200);
		System.out.println("testGetUserListWithHeader executed successfully");
	}

	}
