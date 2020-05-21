package com.practise.apitestingframework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practise.apitestingframework.APIs.CreateCustomerAPI;
import com.practise.apitestingframework.listeners.ExtentListeners;
import com.practise.apitestingframework.setup.BaseTest;
import com.practise.apitestingframework.utilities.DataUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomer extends BaseTest{
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data1")
	public void createCustomerWithValidSecretKey(Hashtable<String,String>data)
	{
		Response response=CreateCustomerAPI.sendPostReqToCreateCustomerWithValidSecretKey(data);
		
		ExtentListeners.testReport.get().info(data.toString());
		
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data1")
	public void createCustomerWithInValidSecretKey(Hashtable<String,String>data)
	{
		Response response=CreateCustomerAPI.sendPostReqToCreateCustomerWithInValidSecretKey(data);
		
		ExtentListeners.testReport.get().info(data.toString());
		
		response.prettyPrint();
				
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	

}
