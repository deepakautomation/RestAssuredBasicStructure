package com.restassured.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.restassured.setup.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{

	public static Response createCustomerAPIWithValidAuth(Hashtable<String, String> data) {
		Response response = given().auth().basic(config.getProperty("validSecretKey"), "")
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		return response;
	}

	public static Response createCustomerAPIWithInvalidAuth(Hashtable<String, String> data) {

		Response response = given().auth().basic(config.getProperty("invalidSecretKey"), "")
				.formParam("email", data.get("email"))
				.formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		return response;
	}

}
