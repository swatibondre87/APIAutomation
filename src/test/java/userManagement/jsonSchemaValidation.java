package userManagement;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;


public class jsonSchemaValidation {

	@Test
	public void jsonSchemaValidationmethod() {
		File schema = new File("resources/ExpectedSchema.json");

		given()
		.when()
		.get("https://reqres.in/api/users?page=2&api_key=reqres-free-v1")
		.then()
		.assertThat()
		.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchema(schema));
		}

}
