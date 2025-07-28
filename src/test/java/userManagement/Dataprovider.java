
package userManagement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Parameters;



public class Dataprovider {
	@DataProvider(name = "testdata")
	public Object[][] testData() {
	    return new Object[][] {
	        {"1", "John"},
	        {"2", "Jane"},
	        {"3", "Bob"}
	    };
	}

	//Test script
	@Test(dataProvider = "testdata")
	@Parameters({"id", "name"})
	public void testEndpoint(String id, String name) {
	    given()
	        .queryParam("id", id)
	        .queryParam("name", name)
	    .when()
	        .get("https://reqres.in/api/users?api_key=reqres-free-v1")
	    .then()
	        .statusCode(200);
	}
}
