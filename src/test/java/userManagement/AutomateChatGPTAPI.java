package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;



public class AutomateChatGPTAPI {

	@Test(description= "Validate status code for GET list models")
	public void getListModels() {

		Response resp =
				given()
				.header("Authorization", "Bearer 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")
				.when()
				.get("https://api.openai.com/v1/models");
		assertEquals(resp.statusCode(), StatusCode.SUCCESS.code);
		System.out.println(resp.getBody().asString());
		System.out.println("Testcase getListModels executed successfully");

	}

	
	
	@Test(description= "Validate status code for GET retrieve models")
	public void getRetrieveModel() {

		Response resp =
				given()
				.header("Authorization", "Bearer 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")
				.pathParam("model-id", "whisper-1")
				.when()
				.get("https://api.openai.com/v1/models/:model-id");
		assertEquals(resp.statusCode(), StatusCode.SUCCESS.code);
		System.out.println(resp.getBody().asString());
		System.out.println("Testcase getRetrieveModel executed successfully");

	}

}
