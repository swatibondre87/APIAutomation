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

public class deserializationResponsePojo {

	@Test
	public void validatePatchWithResponsePojo() {
		String job = "Automation Test Leader SDET";
		postRequestBody patchRequest = new postRequestBody();
		patchRequest.setJob(job);

		Response response = given()
				.body(patchRequest)
				.header("Content-type", "application/json")
				.when()
				.patch("https://reqres.in/api/users/2?api_key=reqres-free-v1");

		postRequestBody responseBody = response.as(postRequestBody.class);
		System.out.println(responseBody.getJob());
		assertEquals(responseBody.getJob(), job);
		assertEquals(response.getStatusCode(), StatusCode.SUCCESS.code);
		System.out.println("validatePatchWithResponsePojo exeucted successfully");
		System.out.println(response.getBody().asString());
	}



	@Test
	public void validatePostWithResponsePojoListObject() {

		String name = "pune";
		String temperature = "30";

		List<String> listlanguage = new ArrayList<>();
		listlanguage.add("Java");
		listlanguage.add("Python");

		cityRequest cityRequest1 = new cityRequest();
		cityRequest1.setName(name);
		cityRequest1.setTemperature(temperature);

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

		postRequestBody responseBody = response.as(postRequestBody.class);
		System.out.println(responseBody.getCityRequestBody().get(0).getName());
		System.out.println(responseBody.getCityRequestBody().get(0).getTemperature());

		System.out.println(responseBody.getLanguages());
		assertEquals(responseBody.getCityRequestBody().get(0).getName(),name);
		assertEquals(responseBody.getCityRequestBody().get(0).getTemperature(), temperature);

		assertEquals(response.statusCode(), StatusCode.CREATED.code);
		System.out.println("validatePostWithResponsePojoListObject exeucted successfully");
		System.out.println(response.getBody().asString());
	}

}
