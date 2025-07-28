package userManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class formParam {

//    @BeforeClass
//    public void setup() {
//        // Set base URI for the API
//        RestAssured.baseURI = "https://reqres.in/api";
//    }

    @Test
    public void testCreateUserWithFormParam() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("name", "swati")
                .formParam("job", "tester")
                .when()
                .post("https://reqres.in/api/users?api_key=reqres-free-v1")
                .then()
             //   .statusCode(200)
                .extract()
                .response();

        // Assert that the response contains the correct name and job values
        response.then().body("name", equalTo("swati"));
        response.then().body("job", equalTo("tester"));
    }
}

