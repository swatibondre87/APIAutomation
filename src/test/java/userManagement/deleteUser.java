package userManagement;

import org.testng.annotations.Test;

import core.StatusCode;

import static io.restassured.RestAssured.given;
import io.restassured.response.*;
import static org.testng.Assert.assertEquals;

public class deleteUser {
	@Test(description="validate 204 for Delete user",groups= {"RegressionSuite","B_User"})
	public void verifyStatusCodeDelete() {


		Response resp = 
				given()
				.delete("https://reqres.in/api/users/2?api_key=reqres-free-v1");
		assertEquals(resp.getStatusCode(),StatusCode.NO_CONTENT.code);
		System.out.println("verifyStatusCodeDelete executed successfully");


	}


}
