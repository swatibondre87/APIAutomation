package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;

public class cookApplicationAPI {


	@Test
    public void validatePostEggsCollect() {
      

        // Authenticate and get an authorization token
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer a26ede1c63ec581a997b4df97428b08476f09317")
                .when()
                .post("http://coop.apps.symfonycasts.com/api/4491/eggs-collect");
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println("validatePostEggsCollect exeucted successfully");
        System.out.println(response.getBody().asString());
       } 
}
