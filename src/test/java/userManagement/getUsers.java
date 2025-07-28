package userManagement;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentReport;
import utils.FailRetry;
import utils.JsonReader;
import utils.PropertyReader;


public class getUsers extends BaseTest{
	@Test(groups= "regression")
	public void getUserData() {
	     ExtentReport.logInfo("getUserData");
		given()
		.when()
		.get("https://reqres.in/api/users/2?api_key=reqres-free-v1")
		.then()
		.assertThat()
		.statusCode(200);
	}


	@Test
	public void validateGetResponseBody() {
		// Set base URI for the API
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		// Send a GET request and validate the response body using 'then'
		given()
		.when()
		.get("/todos/1")
		.then()
		.assertThat()
		.statusCode(200)
		.body(not(isEmptyString()))
		.body("title", equalTo("delectus aut autem"))
		.body("userId", equalTo(1));
	}


	@Test(groups= {"SmokeSuite","RegressionSuite"}, retryAnalyzer = FailRetry.class)
	public void verifyStatusCodeDelete() {
	
     ExtentReport.logInfo("verifyStatusCodeDelete");

		Response resp = 
				given()
				.delete("https://reqres.in/api/users/2?api_key=reqres-free-v1");
		assertEquals(resp.getStatusCode(), 200);
		System.out.println("verifyStatusCodeDelete executed successfully");


	}

	@Test(groups= "RegressionSuite", retryAnalyzer = FailRetry.class)
	public void validateWithDataFromPropertiesFile(){
		
		ExtentReport.logInfo("validateWithDataFromPropertiesFile");

		String server = PropertyReader.propertyReader("config.properties", "server");

		System.out.println("Server Address is: " +server);
		Response resp = 
				given()
				.queryParam("page", 2)
				.when()
				.get(server); //RestAssured


		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println("validateWithDataFromPropertiesFile exeucted successfully");
	}

//	@Test	
//	public void Test() throws Exception, ParseException {
//		JsonReader.getJsonArrayData("languages", 0);
//		JSONArray jsonArray = getJsonArray("contact");
//
//
//		Iterator<Object> iterator = jsonArray.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}
//
//	}


	@Test()
	public void validateWithTestDataFromJson() throws Exception {
		//		String username = JsonReader.getTestData("username");
		//		String password = JsonReader.getTestData("password");

		//    System.out.println("username from json is: " + username + "    password from json is: " + password);


		Response resp = given()
				.auth()
				.basic(JsonReader.getTestData("username"), JsonReader.getTestData("password"))
				.when()
				.get("https://postman-echo.com/basic-auth"); //RestAssured

		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println("validateWithTestDataFromJson executed successfully");

	}





}




