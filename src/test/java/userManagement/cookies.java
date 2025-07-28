package userManagement;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import static io.restassured.RestAssured.given;
import static io.restassured.http.Cookie.*;
import static org.hamcrest.Matchers.equalTo;

public class cookies {
	@Test
	public void testUseCookies() {
		Cookie cookies = new Cookie.Builder("cookieKey1", "cookieValue1")
				.setComment("using cookie key")
				.build();

		given()
		.cookie(cookies)
	//	.cookie("cookieKey1","cookieValue1")
	//	.cookie("cookieKey2", "cookieValue2")
		.when()
		.get("https://reqres.in/api/users?page=2?api_key=reqres-free-v1")
		.then();
	//	.statusCode(200);
		
		
		System.out.println("testUseCookies Executed Successfully");


	}


}
