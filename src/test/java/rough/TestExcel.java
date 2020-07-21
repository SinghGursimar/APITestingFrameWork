package rough;

import utilities.ExcelReader;

public class TestExcel {

	public static void main(String[] args) {
		ExcelReader excel = new ExcelReader(".\\src\\test\\java\\excel\\testData.xlsx");
		System.out.println(excel.getRowCount("testdata"));
		System.out.println(excel.getColumnCount("testdata"));
		int rownum=excel.getRowCount("testdata");
		int colnums=excel.getColumnCount("testdata");
		
		String testName="validateCustomerCreationUsingValidKey";
		String breaker="";
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
			//System.out.println(tcN);
			if(tcN.equalsIgnoreCase(breaker))
			{
				tcEnd=i;
			}
			
		}
		System.out.println("TC ends from "+tcEnd);
		
		//Print the details of the test case
		for(int i =tcStart+2;i<tcEnd;i++)
		{
			for(int j=0;j<colcnt;j++)
			{
				System.out.print(" | "+excel.getCellData("testdata",j, i));
				
			}
			System.out.println("");	
		}
	}

}
