package com.practise.apitestingframework.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.practise.apitestingframework.setup.BaseTest;


public class DataUtil extends BaseTest {
	
	@DataProvider(name="data1",parallel=true)
	public Object[][] getData(Method m)
	{
		String sheetname=property.getProperty("sheetname");
		
		/*String sheetNameFromProperties=property.getProperty("sheetname");
		System.out.println("Sheet name from properties file is :"+sheetNameFromProperties);*/
		
		int rows=excel.getRowCount(sheetname);
		System.out.println("Total rows are : "+rows);
		
		String testName=m.getName();
		System.out.println("Test name is: "+testName);
		
        int testCaseStart=1;
		
		for(testCaseStart=1;testCaseStart<=rows;testCaseStart++)
		{
			
			String name=excel.getCellData(property.getProperty("sheetname"), 0, testCaseStart);
			if(name.equalsIgnoreCase(testName))
				break;
		}
		
		System.out.println("Actual test case start at row number: "+testCaseStart);
		
		/*
		 * Get total number of rows in a test case
		 */
		int dataStartRowNum=testCaseStart+2;
		
		int testRows=0;
		
		while(!excel.getCellData(property.getProperty("sheetname"), 0, dataStartRowNum+testRows).equals(""))
		{
			testRows++;
			
		}
		
		System.out.println("Total number of rows in a test case are : "+testRows);
		
		/*
		 * Get total number of columns in a test case
		 */
		
		int testcolumns=0;
		int colStartColNum=testCaseStart+1;
		
		while(!excel.getCellData(property.getProperty("sheetname"), testcolumns, colStartColNum).equals(""))
		{
			testcolumns++;
		
		}
		System.out.println("Total number of columns in a test case are : "+testcolumns);
		
		
		Object[][]data=new Object[testRows][1];
		
		int i=0;
		
		for(int rowNum=dataStartRowNum;rowNum<(dataStartRowNum+testRows);rowNum++)
		{
			Hashtable<String, String>table=new Hashtable<String, String>();
			
			for(int colNum=0;colNum<testcolumns;colNum++)
			{
				String testData=excel.getCellData(property.getProperty("sheetname"), colNum, rowNum);
				String colName=excel.getCellData(property.getProperty("sheetname"), colNum, colStartColNum);
				table.put(colName,testData);
			}
			
			data[i][0]=table;
			i++;
			
		}
		return data;
	}


}
