package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.PropertyReader;

public class validateDataPropertiesFile {
	@Test
	public void validateWithDataFromPropertiesFile(){


		String server = PropertyReader.propertyReader("config.properties", "server");
		
		System.out.println("Server Address is: " + server);
		Response resp = 
				given()
				.queryParam("page", 2)
				.when()
				.get(server); //RestAssured


		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println("validateWithDataFromPropertiesFile exeucted successfully");
	}

}
