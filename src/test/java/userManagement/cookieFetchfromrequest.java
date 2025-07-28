package userManagement;

import static org.testng.Assert.assertEquals;


import java.util.Map;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import static io.restassured.http.Cookie.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class cookieFetchfromrequest {
	@Test
	public void testFetchCookies() {
		Response response = given()
				.when()
				.get("https://reqres.in/api/users?page=2?api_key=reqres-free-v1")
				.then()
				.extract()
				.response();

		Map<String, String> cookies = response.getCookies();
		Cookies cookies1 = response.getDetailedCookies();
		
		//Task
		for(Cookie c:cookies1 ) {
			if(c.getName().contains("server")) {
				assertEquals(c.getValue(), "cloudflare");
				System.out.println("testFetchCookies Executed Successfully");
				
			}
			}
		
//		cookies1.getValue("server");
//		assertEquals(cookies1.getValue("server"), "cloudflare");
//		assertThat(cookies, hasKey("JSESSIONID"));
//		assertThat(cookies, hasValue("ABCDEF123456"));
	//	System.out.println("testFetchCookies Executed Successfully");
		
		
	}



}
