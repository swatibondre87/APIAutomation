package userManagement;

import static org.testng.Assert.assertEquals;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathPara {
	@Test(description = "Validate the status code for GET users endpoint")
	public void validateResponseBodyGetPathParam() {


		String raceSeasonValue = "2017";
		Response response = 
				 given()
				.pathParam("raceSeason", raceSeasonValue)
				.when()
				.get("http://ergast.com/api/f1/{raceSeason}/circuits.json"); //RestAssured


		int actualStatusCode = response.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println(response.body().asString());


	}


}
