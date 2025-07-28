package userManagement;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Arrays;
import java.util.List;

public class contains {

	@Test
	public void validateListContainsInOrder() {
		// Set base URI for the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Send a GET request and store the response in a variable
		Response response = given()
				.when()
				.get("/comments?postId=1")
				.then()
				.extract()
				.response();

		// Use Hamcrest to check that the response body contains specific items in a specific order
		List<String> expectedEmails = Arrays.asList("Eliseo@gardner.biz", "Jayne_Kuhic@sydney.com", "Nikita@garfield.biz","Lew@alysha.tv","Hayden@althea.biz");
		assertThat(response.jsonPath().getList("email"), contains(expectedEmails.toArray(new String[0])));
	}
}





