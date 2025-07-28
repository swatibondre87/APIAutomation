package userManagement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.SoftAssertionUtil;

public class validateSoftAssertUtil {
	@Test
	public void validateWithSoftAssertUtil() {


		RestAssured.baseURI = "https://reqres.in/api";

		Response response = given()
				.queryParam("page", 2)
				.when()
				.get("/users?api_key=reqres-free-v1")
				.then()
				.statusCode(StatusCode.SUCCESS.code)
				.extract()
				.response();

		// Assert that the response contains 6 users
		response.then().body("data", hasSize(6));
		SoftAssertionUtil softAssertion= new SoftAssertionUtil();


		softAssertion.assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code, "Status code is not 200");
		softAssertion.assertAll();
		System.out.println("validateWithSoftAssertUtil executed successfully");

	}

}
