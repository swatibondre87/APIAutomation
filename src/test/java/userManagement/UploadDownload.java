package userManagement;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

@Test
public class UploadDownload {

	
	
	public void FileUploadExample(){
		
			File file = new File("resources/demo.txt");
			Response response = given()
					.multiPart("file", file)
					.when()
					.post("https://example.com/upload");
			        System.out.println(response.getStatusCode());
			
			
		
		
	}
}
