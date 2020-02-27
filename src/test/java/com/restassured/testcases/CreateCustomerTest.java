package com.restassured.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.API.CreateCustomerAPI;
import com.restassured.setup.BaseTest;
import com.restassured.utilities.DataUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class CreateCustomerTest extends BaseTest{
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithValidSecretkey(Hashtable<String, String> data) {
		
	
		Response response = CreateCustomerAPI.createCustomerAPIWithValidAuth(data);
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
	}
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithInvalidSecretkey(Hashtable<String, String> data) {
		
		Response response = CreateCustomerAPI.createCustomerAPIWithInvalidAuth(data);
		response.prettyPrint();
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.statusCode(), 200);
		
	}
	
	
	/*@DataProvider
	public Object[][] getData(Method m){
		
		String sheetName = "validateCreateCustomerAPI";
		String sheetName = m.getName();
		
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getRowCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
		data[0][0] = excel.getCellData(sheetName, 0, 2);
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		data[0][2] = excel.getCellData(sheetName, 2, 2);
				
		data[0][0]="Deep";
		data[0][1]="abc@gmail.com";
		data[0][2]="description";
		
		
		for(int rowNum = 2; rowNum<=rows; rowNum++) {
			
			for (int colsNum = 0; colsNum < cols; colsNum++) {
				
				data[rowNum-2][colsNum]=excel.getCellData(sheetName, colsNum, rowNum);;
				
			}
		}
		
		return data;
	}*/

}
