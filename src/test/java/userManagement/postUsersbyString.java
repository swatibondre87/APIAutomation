package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;

public class postUsersbyString {
	

	@Test
    public void validatePostWithString() {
      

        // Authenticate and get an authorization token
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Swati\",\"job\":\"Automation Tester\"}")
                .when()
                .post("https://reqres.in/api/users?api_key=reqres-free-v1");
        assertEquals(response.getStatusCode(), StatusCode.CREATED.code);
        System.out.println("validatePostWithString exeucted successfully");
        System.out.println(response.getBody().asString());
       } 

	
	@Test
    public void validatePutWithString() {
      

        // Authenticate and get an authorization token
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"swati Bondre\",\"job\":\"Automation Test Lead\"}")
                .when()
                .put("https://reqres.in/api/users/2?api_key=reqres-free-v1");
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println("validatePutWithString exeucted successfully");
        System.out.println(response.getBody().asString());
     } 
	
	@Test
    public void validatePatchWithString() {
      

        
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Swati Laxman Bondre\"}")
                .when()
                .patch("https://reqres.in/api/users/2?api_key=reqres-free-v1");
        assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
        System.out.println("validatePatchWithString exeucted successfully");
        System.out.println(response.getBody().asString());
               

       
    } 

}
