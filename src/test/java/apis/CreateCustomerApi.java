package apis;

import static io.restassured.RestAssured.given;

import base.BaseTest;
import io.restassured.response.Response;

public class CreateCustomerApi extends BaseTest {
	
	public static Response sendPostReqToCreateCustUsingValidKey(String email, String name, String description)
	{
		Response res =given().auth().basic(config.getProperty("validSecretKey"), "")
		.formParam("email",email)
		.formParam("name", name)
		.formParam("description",description)
		.post(config.getProperty("customerEndPoint")).then().log().all().extract().response();
		return res;
		
	}
	public static Response sendPostReqToCreateCustUsingInvalidKey(String email, String name, String description)
	{
		Response res =given().auth().basic(config.getProperty("invalidSecretKey"), "")
				.formParam("email",email)
				.formParam("name", name)
				.formParam("description",description)
				.post(config.getProperty("customerEndPoint")).then().log().all().extract().response();
		return res;
		
	}

}
