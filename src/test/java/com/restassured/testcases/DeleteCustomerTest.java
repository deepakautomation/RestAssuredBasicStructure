package com.restassured.testcases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.API.CreateCustomerAPI;
import com.restassured.API.DeleteCustomerAPI;
import com.restassured.setup.BaseTest;
import com.restassured.utilities.DataUtil;
import com.restassured.utilities.TestUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

public class DeleteCustomerTest extends BaseTest{
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void deleteCustomer(Hashtable<String, String> data) {
		
	
		Response response = DeleteCustomerAPI.deleteCustomerRequestWithValidId(data);
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		
		//for validation
		
		/*JSONObject jsonObject = new JSONObject(response.asString());
		System.out.println(jsonObject.has("id"));
		
		Assert.assertTrue(jsonObject.has("id"),"ID is not present");
*/
		
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"id is not present");
		String actualID = TestUtil.returnJsonKeyValue(response.asString(), "id");
		
		/*String actualID = jsonObject.getString("id").toString();*/
		System.out.println(actualID);
		
		Assert.assertEquals(actualID, data.get("id"));
		
		System.out.println("Object key value is "+TestUtil.returnJsonKeyValue(response.asString(), "deleted"));
	}
	
	
	
	
	
}
