package com.practise.apitestingframework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.practise.apitestingframework.setup.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{
	
	public static Response sendDeleteReqToDeleteCustomerWithValidID(Hashtable<String,String>data)
	{
		
		//This is a delete API
		Response response = given().auth().basic(property.getProperty("validateCreateCustomerAPIKey"), "")
			         .delete(property.getProperty("endPointURI")+"/"+data.get("id"));
				
		return response;
	}
	
	
	

}
