package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;
import utils.ExtentReport;

import org.testng.annotations.Test;

import core.StatusCode;


public class APIChaining {

	public String generateAuthToken() {


		// Authenticate and get an authorization token
		Response response = given()
				.header("Content-Type", "application/json")
				.body("{\"userName\":\"SwatiBondre\",\"password\":\"Test@1234\"}")
				.when()
				.post("https://bookstore.toolsqa.com/Account/v1/GenerateToken");
		assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
		System.out.println("generateAuthToken exeucted successfully");
		String authToken =  response.path("token");
		System.out.println("authToken: " +authToken);
		return authToken;
} 
	
	@Test

	public String generateUserID() {
		
		
		Response response = given()
				.header("Content-Type", "application/json")
				
				.body("{\"userName\":\"SwatiBondre\",\"password\":\"Test@12345\"}")
				.when()
				.post("https://bookstore.toolsqa.com/Account/v1/User");
		assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
		System.out.println("generateUserID exeucted successfully");
		String userId =  response.path("userId");
		System.out.println("userID: " + userId);
		return userId;
		
	} 

	
	@Test
	public void verifyBookstoreAddBooks() {


		ExtentReport.logInfo("verifyBookstoreAddBooks");
		String authToken = generateAuthToken() ;
	//	String userId = generateUserID();

		Response response = given()
				.header("Content-Type", "application/json")
				.header("Authorization","Bearer " + authToken)
				.body("{\"userId\":\"429ce5d0-5073-47dc-9d96-ae14b0c3e442\",\"collectionOfIsbns\":[{\"isbn\":\"9781449331818\"}]}")
				.when()
				.post("https://bookstore.toolsqa.com/BookStore/v1/Books");
		assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
		System.out.println("verifyBookstoreAddBooks exeucted successfully");
	} 




}
