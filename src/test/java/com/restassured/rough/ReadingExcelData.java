package com.restassured.rough;

import com.restassured.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader(
				"C:\\Users\\Deepak Sood\\canada\\RestAssured\\src\\test\\resources\\excel\\testdata.xlsx");

		int rows = excel.getRowCount(Constants.Data_Sheet);

		System.out.println(rows);

		// Get the row of test case start
		String testName = "validateCreateCustomerAPIWithValidSecretkey";

		int testCaseRowNum = 1;

		for (testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++) {

			String testCaseName = excel.getCellData(Constants.Data_Sheet, 0, testCaseRowNum);

			if (testCaseName.equalsIgnoreCase(testName))
				break;

		}
		System.out.println(testCaseRowNum + "Test case starts from here");

		// find the no of rows(excel) in each test

		int dataStartRowNum = testCaseRowNum + 2;

		int testRows = 0;

		while (!excel.getCellData(Constants.Data_Sheet, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;
		}

		System.out.println("total no of rows in tc are " + testRows);

		// checking total cols in Test case

		int testCols = 0;
		int colStartColNum = testCaseRowNum + 1;

		while (!excel.getCellData(Constants.Data_Sheet, testCols, colStartColNum).equals("")) {

			testCols++;
		}

		System.out.println("total cols are " + testCols);

		// printing data

		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {

			for(int cNum = 0; cNum<testCols; cNum++){
				System.out.println(excel.getCellData(Constants.Data_Sheet, cNum, rNum));
			}
			{
		}

		}
	}
}
