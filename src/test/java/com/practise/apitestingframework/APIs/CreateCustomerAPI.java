package com.practise.apitestingframework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.practise.apitestingframework.setup.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {
	
	public static Response sendPostReqToCreateCustomerWithValidSecretKey(Hashtable<String,String>data)
	{
		Response response = given().auth().basic(property.getProperty("validateCreateCustomerAPIKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(property.getProperty("endPointURI"));
				
		return response;
	}
	
	public static Response sendPostReqToCreateCustomerWithInValidSecretKey(Hashtable<String,String>data)
	{
		Response response = given().auth().basic(property.getProperty("invalidateCreateCustomerAPIKey"), "")
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(property.getProperty("endPointURI"));
		
		return response;
		
	}

}
