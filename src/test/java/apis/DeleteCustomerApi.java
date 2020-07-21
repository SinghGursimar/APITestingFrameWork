package apis;

import static io.restassured.RestAssured.given;

import base.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerApi extends BaseTest {
	public static Response sendDelReqToDeleteCustomerWithValidCustomerID(String id)
	{
		
		Response res =given().log().all().auth().basic(config.getProperty("validSecretKey"), "")
		.delete(config.getProperty("customerEndPoint")+"/"+id).then().log().all().extract().response();
		return res;
		
	} 

}
