package com.restassured.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.restassured.setup.BaseTest;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest{

	public static Response deleteCustomerRequestWithValidId(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				
				.delete(config.getProperty("customerAPIEndpoint")+"/"+data.get("id"));
		
		return response;
	}

}
