package userManagement;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import bsh.ParseException;
import io.restassured.response.Response;

public class singleQueryPara {
	@Test
	public void validateStatusCodeGetUser(){

    Response resp = 
				given()
				.queryParam("page", 2)
				.when()
				.get("https://reqres.in/api/users?page=2&api_key=reqres-free-v1"); //RestAssured


		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
	}


}
