package com.practise.apitestingframework.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.practise.apitestingframework.utilities.ExcelReader;

import io.restassured.RestAssured;




public class BaseTest {
	
	public static Properties property=new Properties();
	private FileInputStream fis;
	public ExcelReader excel=new ExcelReader(".\\src\\test\\resources\\excel\\Book1.xlsx");
	
	
	@BeforeSuite
	public void setUp() throws IOException
	{
		fis=new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		
		property.load(fis);
		
		RestAssured.baseURI=property.getProperty("baseURI");
		RestAssured.basePath=property.getProperty("basePath");
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		
	}

}
