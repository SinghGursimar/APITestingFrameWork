package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import utilities.ExcelReader;

public class BaseTest {
	
	public static Properties config = new Properties();
	
	FileInputStream fis ;
	public static  ExcelReader excel=new ExcelReader(".\\src\\test\\java\\excel\\TestData.xlsx");
	
	@BeforeSuite
	public void setUp() 
	{
		
		try {
			fis= new FileInputStream(".\\src\\test\\java\\properties\\config.properties");
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RestAssured.baseURI = config.getProperty("baseuri");
		RestAssured.basePath=config.getProperty("basepath");
		 
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		
	}

}
