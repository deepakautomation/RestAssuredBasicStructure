package com.restassured.rough;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.utilities.ExcelReader;

public class Testparameterization {
	
	
	@Test
	public void testData(Hashtable<String, String> data) {
		System.out.println(data.get("Runmode")+"=="+data.get("name"));
	}

	
	@DataProvider
	public static Object[][] getData(Method m) {
		
		ExcelReader excel = new ExcelReader(
				"C:\\Users\\Deepak Sood\\canada\\RestAssured\\src\\test\\resources\\excel\\testdata.xlsx");

		int rows = excel.getRowCount(Constants.Data_Sheet);
		System.out.println("Total rows are : " + rows);

		String testName = m.getName();
		System.out.println("Test name is : "+testName);

		// Find the test case start row

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(Constants.Data_Sheet, 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}

		System.out.println("Test case starts from row num: " + testCaseRowNum);

		// Checking total rows in test case

		int dataStartRowNum = testCaseRowNum + 2;

		int testRows = 0;
		while (!excel.getCellData(Constants.Data_Sheet, 0, dataStartRowNum + testRows).equals("")) {

			testRows++;
		}

		System.out.println("Total rows of data are : " + testRows);

		// Checking total cols in test case

		int colStartColNum = testCaseRowNum + 1;
		int testCols = 0;

		while (!excel.getCellData(Constants.Data_Sheet, testCols, colStartColNum).equals("")) {

			testCols++;

		}

		System.out.println("Total cols are : " + testCols);

		// Printing data

		Object[][] data = new Object[testRows][1];

		int i = 0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			Hashtable<String, String> table = new Hashtable<String, String>();

			for (int cNum = 0; cNum < testCols; cNum++) {

				// System.out.println(excel.getCellData(config.getProperty("testDataSheetName"),
				// cNum, rNum));
				String testData = excel.getCellData(Constants.Data_Sheet, cNum, rNum);
				String colName = excel.getCellData(Constants.Data_Sheet, cNum, colStartColNum);

				table.put(colName, testData);

			}

			data[i][0] = table;
			i++;

		}

		return data;
	}
}
