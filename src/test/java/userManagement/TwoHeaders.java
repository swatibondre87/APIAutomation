package userManagement;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class TwoHeaders {
	@Test
	public void testWithTwoHeaders() {
		given()
		.header("Authorization", "bearer ywtefdu13tx4fdub1t3ygdxuy3gnx1iuwdheni1u3y4gfuy1t3bx")
		.header("Content-Type", "application/json")
		.when()
		.get("https://reqres.in/api/users/2?api_key=reqres-free-v1")
		.then()
		.statusCode(200);
		System.out.println("testWithTwoHeaders Executed Successfully");
	}


}
