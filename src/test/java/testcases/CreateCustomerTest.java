package testcases;

import org.testng.Assert;
import apis.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import extentReports.ExtentListeners;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.DataUtil;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateCustomerTest extends BaseTest {
	
		
	
//	@Test(dataProviderClass = DataUtil.class,dataProvider = "Data")
//	public void validateCustomerCreationUsingValidKey(String email, String name, String description)
//	{
//		
//		Response res =given().auth().basic(config.getProperty("validSecretKey"), "")
//		.formParam("email",email)
//		.formParam("name", name)
//		.formParam("description",description)
//		.post(config.getProperty("customerEndPoint")).then().log().all().extract().response();
//		
//		System.out.println(res.prettyPrint());
//		System.out.println("Status code of the response"+res.getStatusCode());
//	}
//	@Test(dataProviderClass = DataUtil.class,dataProvider = "Data")
//	public void validateCustomerCreationUsingInvalidKey(String email, String name, String description)
//	{		
//		Response res =given().auth().basic(config.getProperty("invalidSecretKey"), "")
//				.formParam("email",email)
//				.formParam("name", name)
//				.formParam("description",description)
//				.post(config.getProperty("customerEndPoint")).then().log().all().extract().response();
//				
//		
//		System.out.println(res.prettyPrint());
//		System.out.println("Status code of the response"+res.getStatusCode());
//		//added validation
//		Assert.assertEquals(res.getStatusCode(), 200);
//	}
	@Test(dataProviderClass = DataUtil.class,dataProvider = "DataFromSingleSheet",priority = 0)
	public void validateCustomerCreationUsingValidKey(String email, String name, String description)
	{
		Response res = CreateCustomerApi.sendPostReqToCreateCustUsingValidKey(email, name, description);
				
				//System.out.println(res.prettyPrint());
				System.out.println("Status code of the response"+res.getStatusCode());
				String CustomerId =res.jsonPath().get("id").toString();
		
		System.out.println("Customer add and the Id is :-"+CustomerId );
		ExtentListeners.testReport.get().info("Customer added and the Id is :-"+CustomerId );
	}
	@Test(dataProviderClass = DataUtil.class,dataProvider = "DataFromSingleSheet",priority = 1,enabled = false)
	public void validateCustomerCreationUsingInvalidKey(String email, String name, String description)
	{
		Response res =CreateCustomerApi.sendPostReqToCreateCustUsingInvalidKey(email, name, description);
				
				System.out.println(res.prettyPrint());
				System.out.println("Status code of the response"+res.getStatusCode());
		
		System.out.println(" | "+ email+" | "+name+" | "+description);
		Assert.assertEquals(res.getStatusCode(), 401);
		
	}
	

	

}
