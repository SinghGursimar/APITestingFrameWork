package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import apis.DeleteCustomerApi;
import base.BaseTest;
import extentReports.ExtentListeners;
import io.restassured.response.Response;
import utilities.DataUtil;

public class DeleteCustomer extends BaseTest {
	
	@Test(dataProviderClass = DataUtil.class,dataProvider = "DataFromSingleSheet",priority = 0)
	public void deleteCustomerWithValidCustId(String id)
	{
			
			Response res = DeleteCustomerApi.sendDelReqToDeleteCustomerWithValidCustomerID(id);
					
					System.out.println(res.prettyPrint());
					System.out.println("Status code of the response"+res.getStatusCode());
					String CustomerId =res.jsonPath().get("id").toString();
					
					System.out.println("Customer deleted and the Id is :-"+CustomerId );
					ExtentListeners.testReport.get().info("Customer deleted and the Id is :-"+CustomerId );
					Assert.assertEquals(id, CustomerId);
			
		}
	}


