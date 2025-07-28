package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.BaseTest;
import io.restassured.response.Response;
import utils.ExtentReport;
import utils.FailRetry;

public class getErgast extends BaseTest{
	@Test(description = "Validate the status code for GET users endpoint", groups= "RegressionSuite", retryAnalyzer = FailRetry.class)
	public void validateResponseBodyGetPathParam() {
	
		ExtentReport.logInfo("validateResponseBodyGetPathParam");


		String raceSeasonValue = "2017";
		Response response = given()
				.pathParam("raceSeason", raceSeasonValue)
				.when()
				.get("http://ergast.com/api/f1/{raceSeason}/circuits.json"); //RestAssured


		int actualStatusCode = response.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println(response.body().asString());
		System.out.println("validateResponseBodyGetPathParam executed successfully");


	}

}
