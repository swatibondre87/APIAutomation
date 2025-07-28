package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;
import pojo.postRequestBody;

public class postUsersbyPojo {

	@Test
	public void validatePostWithPojo() {

		postRequestBody postRequest = new postRequestBody();
		postRequest.setName("Swati");
		postRequest.setJob("Automation tester");
		

		Response response = given()
				.body(postRequest)
				.header("Content-type", "application/json")

				.when()
				.post("https://reqres.in/api/users?api_key=reqres-free-v1");

		assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
		System.out.println("validatePostWithPojo exeucted successfully");
		System.out.println(response.getBody().asString());
	}

	
	@Test
	public void validatePutWithPojo() {

		postRequestBody putRequest = new postRequestBody();
		putRequest.setName("Swati Bondre");
		putRequest.setJob("Automation tester Lead");
		

		Response response = given()
				.body(putRequest)
				.header("Content-type", "application/json")
				.when()
				.put("https://reqres.in/api/users/2?api_key=reqres-free-v1");

		assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
		System.out.println("validatePutWithPojo exeucted successfully");
		System.out.println(response.getBody().asString());
	}
	
	@Test
	public void validatePatchWithPojo() {

		postRequestBody patchRequest = new postRequestBody();
		patchRequest.setJob("Automation Test Leader SDET");
	
      Response response = given()
				.body(patchRequest)
				.header("Content-type", "application/json")
				.when()
				.patch("https://reqres.in/api/users/2?api_key=reqres-free-v1");

		assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
		System.out.println("validatePatchWithPojo exeucted successfully");
		System.out.println(response.getBody().asString());
	}
}
