package com.practise.apitestingframework.utilities;



import org.testng.annotations.DataProvider;

import com.practise.apitestingframework.setup.BaseTest;

public class DataUtilSimple_KeptForUnderstanding extends BaseTest{
	
	@DataProvider(name="data")
	public Object[][] getData()
	{
		String sheetname="validateCreateCustomerAPI";
		
		int row=excel.getRowCount(sheetname);  //2
		int column=excel.getColumnCount(sheetname);	   //3	
		
		System.out.println(row);
		System.out.println(column);
				
		Object[][]data=new Object[row-1][column];
		
		for(int rownum=2;rownum<=row;rownum++)
		{
			for(int colnum=0;colnum<column;colnum++)
			{
				data[rownum-2][colnum]=excel.getCellData(sheetname, colnum, rownum);
			}
			
		}
		
		return data;
	}

}
