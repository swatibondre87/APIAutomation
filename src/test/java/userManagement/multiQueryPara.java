package userManagement;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class multiQueryPara {
	@Test
	public void testGetUsersWithMultipleQueryParams() {
		Response response =
				given()
				.queryParam("page", 2)
				.queryParam("per_page", 3)
				.queryParam("rtqsdr", 4)
				.when()
				.get("https://reqres.in/api/users?api_key=reqres-free-v1")
				.then()
				.statusCode(200)
				.extract()
				.response();
	}


}
