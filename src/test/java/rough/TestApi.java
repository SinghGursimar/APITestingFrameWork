package rough;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import base.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.ExcelReader;

public class TestApi extends BaseTest {
public static Properties config = new Properties();
	
	static FileInputStream fis ;
	public static  ExcelReader excel=new ExcelReader(".\\src\\test\\java\\excel\\TestData.xlsx");
	public static void main(String[] args) {
		try {
			fis= new FileInputStream(".\\src\\test\\java\\properties\\config.properties");
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = config.getProperty("baseuri");
		RestAssured.basePath=config.getProperty("basepath");
		
		Response res =given().log().all().auth().basic(config.getProperty("validSecretKey"),"")
				.delete(config.getProperty("customerEndPoint")+"cus_Hf88VlvbPpKT14").then().log().all().extract().response();
			
		
	}

}
