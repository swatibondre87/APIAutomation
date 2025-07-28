package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;
import pojo.postRequestBody;

public class postUsersbyPojoList {

	
	@Test
	public void validatePostWithPojoList() {

		List<String> listlanguage = new ArrayList<>();
		listlanguage.add("Java");
		listlanguage.add("Python");
		
		postRequestBody postRequest = new postRequestBody();
		postRequest.setJob("swati");
		postRequest.setName("Automation tester");
		postRequest.setLanguages(listlanguage);

		Response response = given()
				.body(postRequest)
				.header("Content-type", "application/json")
				
				.when()
				.post("https://reqres.in/api/users?api_key=reqres-free-v1");

		assertEquals(response.statusCode(), StatusCode.CREATED.code);
		System.out.println("validatePostWithPojoList exeucted successfully");
		System.out.println(response.getBody().asString());
	}
}
