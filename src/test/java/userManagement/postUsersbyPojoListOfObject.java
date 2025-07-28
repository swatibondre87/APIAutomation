package userManagement;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import core.StatusCode;
import io.restassured.response.Response;
import pojo.cityRequest;
import pojo.postRequestBody;

public class postUsersbyPojoListOfObject {


	@Test
	public void validatePostWithPojoListObject() {

		List<String> listlanguage = new ArrayList<>();
		listlanguage.add("Java");
		listlanguage.add("Python");

		cityRequest cityRequest1 = new cityRequest();
		cityRequest1.setName("pune");
		cityRequest1.setTemperature("30");

		cityRequest cityRequest2 = new cityRequest();
		cityRequest2.setName("delhi");
		cityRequest2.setTemperature("40");

		List<cityRequest> cityRequests = new ArrayList<>();
		cityRequests.add(cityRequest1);
		cityRequests.add(cityRequest2);

		postRequestBody postRequest = new postRequestBody();
		postRequest.setJob("Automation tester");
		postRequest.setName("Swati");
		postRequest.setLanguages(listlanguage);
		postRequest.setCityRequestBody(cityRequests);

		Response response = given()
				.body(postRequest)
				.header("Content-type", "application/json")

				.when()
				.post("https://reqres.in/api/users?api_key=reqres-free-v1");

		assertEquals(response.statusCode(), StatusCode.CREATED.code);
		System.out.println("validatePostWithPojoListObject exeucted successfully");
		System.out.println(response.getBody().asString());
	}
}
