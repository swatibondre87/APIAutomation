package userManagement;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils; 
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import core.StatusCode;



public class postUsersbyJson {
	private static FileInputStream fileInputStreamMethod(String requestBodyFileName)   {
		FileInputStream fileInputStream;
		try {
	    fileInputStream = new FileInputStream
	    		(new File(System.getProperty("user.dir")  + "/Resources/TestData/" + requestBodyFileName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return fileInputStream;
		
		
	}
	
	@Test
	public void validatePostWithJsonAsFile() throws IOException {
	   
	   Response response = given()
	           .body(IOUtils.toString(fileInputStreamMethod("postRequestBody.json")))
	           .header("Content-type", "application/json")
	           
	           .when()
	           .post("https://reqres.in/api/users?api_key=reqres-free-v1");
	  
	   assertEquals(response.statusCode(), StatusCode.CREATED.code);
       System.out.println("validatePostWithJsonAsFile exeucted successfully");
       System.out.println(response.getBody().asString());
	}


	@Test
	public void validatePatchWithJsonAsFile() throws IOException {
	   
	   Response response = given()
	           .body(IOUtils.toString(fileInputStreamMethod("patchRequestBody.json")))
	           .header("Content-type", "application/json")
	           
	           .when()
	           .patch("https://reqres.in/api/users/2?api_key=reqres-free-v1");
	   
	   assertEquals(response.statusCode(),  StatusCode.SUCCESS.code);
       System.out.println("validatePatchWithJsonAsFile exeucted successfully");
       System.out.println(response.getBody().asString());
	}

	
	@Test
	public void validatePutWithJsonAsFile() throws IOException {
	   
	   Response response = given()
	           .body(IOUtils.toString(fileInputStreamMethod("putRequestBody.json")))
	           .header("Content-type", "application/json")
	           
	           .when()
	           .put("https://reqres.in/api/users/2?api_key=reqres-free-v1");
	   
	   assertEquals(response.statusCode(),  StatusCode.SUCCESS.code);
       System.out.println("validatePutWithJsonAsFile exeucted successfully");
       System.out.println(response.getBody().asString());
	}

}
