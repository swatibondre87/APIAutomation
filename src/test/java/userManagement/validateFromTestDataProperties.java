package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.JsonReader;
import utils.PropertyReader;

public class validateFromTestDataProperties {
	
	@Test
	public void validateWithDataFromPropertiesFile() throws Exception{

		String server = PropertyReader.propertyReader("config.properties", "server");
		String endpoint = JsonReader.getTestData("endpoint");
		String URL = server + endpoint;
		System.out.println("URL is: " + URL);
		Response resp = 
				given()
				.queryParam("page", 2)
				.when()
				.get(URL); //RestAssured


		int actualStatusCode = resp.statusCode();  //RestAssured
		assertEquals(actualStatusCode, 200); //Testng
		System.out.println("validateWithDataFromPropertiesFile exeucted successfully" +URL);
	}


}
