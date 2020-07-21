package utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataUtil extends BaseTest 
{
	
	@DataProvider(name = "Data")
	public Object[][] getData(Method M)
	{	
		String sheetName = M.getName();
	int rows =excel.getRowCount(sheetName);
	System.out.println(rows);
	int columns = excel.getColumnCount(sheetName);
	System.out.println(columns);
		Object [][] data = new Object[rows-1][columns];
		
		for(int i=2;i<=rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				data[i-2][j]=excel.getCellData(sheetName,j, i);
			}
		}
		
		return data;
		
	}
	@DataProvider(name = "DataFromSingleSheet",parallel = true)
	public Object[][] getDataFromSingleSheet(Method m)
	{
		System.out.println(excel.getRowCount("testdata"));
		System.out.println(excel.getColumnCount("testdata"));
		int rownum=excel.getRowCount("testdata");
		int colnums=excel.getColumnCount("testdata");
		
		String testName=m.getName();
		String breaker="*";
		int tcStart=0;
		int tcEnd=0;
		
		//Get start of Test Case
		for(int i=1;i<=rownum;i++)
		{
			String tcN=excel.getCellData("testdata",0, i);
			//System.out.println(tcN);
			if(tcN.equalsIgnoreCase(testName))
			{
				tcStart=i;
			}
			
		}
		System.out.println("TC starts from "+tcStart);
		//get the column count
		int colcnt = 0;
		while(!excel.getCellData("testdata",colcnt,(tcStart+1)).equals(""))
		{
			colcnt=colcnt+1;
			
		}
		System.out.println("Column count is "+colcnt);
		//Get end of Test Case
		for(int i =tcStart;i<=rownum;i++)
		{
			String tcN=excel.getCellData("testdata",0, i);
			System.out.println(tcN);
			if(tcN.equalsIgnoreCase(breaker))
			{
				tcEnd=i;
				break;
			}
			
		}
		System.out.println("TC ends from "+tcEnd);
		System.out.println(" row count for object "+((tcEnd-(tcStart+2))));
		Object [][] data = new Object[(tcEnd-(tcStart+2))][colcnt];
		//Print the details of the test case
		for(int r=0, i =tcStart+2;i<tcEnd;r++,i++)
		{
			for(int j=0;j<colcnt;j++)
			{
				data[r][j]=excel.getCellData("testdata",j, i);
				
			}
			
		}
		return data;
	}

}
