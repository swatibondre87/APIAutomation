package userManagement;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.http.Headers;
import io.restassured.http.Header;
import io.restassured.response.*;



public class headerfromResponse {
	@Test
	public void testFetchHeaders() {
		Response response = given()
				.when()
				.get("https://reqres.in/api/users?page=2?api_key=reqres-free-v1")
				.then()
				.extract()
				.response();

		Headers headers = response.getHeaders();
		//if you want to print all headers then comment 244,246,247
		for (Header h : headers) {

		if (h.getName().contains("Server")) {
		//	 System.out.println(h.getName() + " : " + h.getValue()); // to print all header name and values
			assertEquals(h.getValue(),"cloudflare");
			System.out.println("testFetchHeaders Executed Successfully");
		}
		}

	}
}


