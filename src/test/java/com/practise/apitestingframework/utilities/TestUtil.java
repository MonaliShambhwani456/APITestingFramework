package com.practise.apitestingframework.utilities;

import org.json.JSONObject;

import com.practise.apitestingframework.listeners.ExtentListeners;

public class TestUtil {
	
	
	public static boolean jsonHasKey(String response,String key)
	{
		JSONObject jsonObject=new JSONObject(response);
		
		ExtentListeners.testReport.get().info("Validating the presence of key: "+key);
		
		return jsonObject.has(key);
	}
	
	public static String getJsonKeyValue(String response,String key)
	{
		JSONObject jsonObject=new JSONObject(response);
		
		ExtentListeners.testReport.get().info("Validating Value of Key : "+key);
		
		return jsonObject.get(key).toString();
	}

	

}
