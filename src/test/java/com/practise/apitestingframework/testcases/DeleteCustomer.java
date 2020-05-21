package com.practise.apitestingframework.testcases;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.practise.apitestingframework.APIs.CreateCustomerAPI;
import com.practise.apitestingframework.APIs.DeleteCustomerAPI;
import com.practise.apitestingframework.listeners.ExtentListeners;
import com.practise.apitestingframework.setup.BaseTest;
import com.practise.apitestingframework.utilities.DataUtil;
import com.practise.apitestingframework.utilities.TestUtil;

import io.restassured.response.Response;

public class DeleteCustomer extends BaseTest {
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data1")
	public void deleteCustomer(Hashtable<String,String>data)
	{
		Response response=DeleteCustomerAPI.sendDeleteReqToDeleteCustomerWithValidID(data);
		
		ExtentListeners.testReport.get().info(data.toString());
		
		response.prettyPrint();
		
		System.out.println(response.getStatusCode());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Convert all this in TestUtil class 
		
		/*JSONObject jsonObject=new JSONObject(response.asString());
		
		System.out.println("Check presence for ID key: "+jsonObject.has("id"));
		System.out.println("Value of ID Key is: "+jsonObject.get("id"));
		
		System.out.println("Check presence for object key: "+jsonObject.has("object"));
		System.out.println("Value of object Key is: "+jsonObject.get("object"));
		
		System.out.println("Check presence for deleted key: "+jsonObject.has("deleted"));
		System.out.println("Value of deleted Key is: "+jsonObject.get("deleted"));*/
		
		/*
		 * Check for ID key
		 */
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"ID is not present");
		System.out.println("id key value is: "+TestUtil.getJsonKeyValue(response.asString(),"id"));
		Assert.assertEquals(TestUtil.getJsonKeyValue(response.asString(), "id"), data.get("id"),"ID is not matching");
		
		
		/*
		 * Check for object key
		 */
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "object"),"object is not present");
        System.out.println("Object key value is: "+TestUtil.getJsonKeyValue(response.asString(),"object"));
				
        /*
		 * Check for deleted key
		 */
        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "deleted"),"deleted is not present");
		System.out.println("Delected key value is: "+TestUtil.getJsonKeyValue(response.asString(),"deleted"));
				
		
	}

}
