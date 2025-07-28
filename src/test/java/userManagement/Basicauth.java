package userManagement;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Basicauth {

@Test()
public void validateResponseBodyGetBasicAuth() {

   Response resp = given()
           .auth()
           .basic("postman", "password")
           .when()
           .get("https://postman-echo.com/basic-auth"); //RestAssured

   int actualStatusCode = resp.statusCode();  //RestAssured
   assertEquals(actualStatusCode, 200); //Testng
   System.out.println(resp.body().asString());

}



}
