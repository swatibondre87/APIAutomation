package userManagement;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class builderPatternImplementationRequestResponse {


	private RequestSpecification requestSpec;
	private ResponseSpecification responseSpec;

	@Test
	public void testRestAssuredBuilderPattern() {


		requestSpec =  getRequestSpecificationBuilder("1", "application/json");
		given()
		.spec(requestSpec)
		.when()
		.get("/posts")
		.then()
		.spec(getResponseSpecificationBuilder(200, "application/json"));
	}
	

	private RequestSpecification getRequestSpecificationBuilder(String queryParam, String contentType) {
		
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://jsonplaceholder.typicode.com")
				.setContentType(contentType)
				.addQueryParam("userId", queryParam)
				.build();
		return requestSpec;
	}

	
	@Test

	private ResponseSpecification getResponseSpecificationBuilder(int statusCode, String contentType) {

		responseSpec =  new ResponseSpecBuilder()
				.expectStatusCode(statusCode)
				.expectContentType(contentType)
				.build();
		return responseSpec;

	}

}
