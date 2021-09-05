package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {

	@DataProvider()
	public Object [][] getData(){
	Object[][] data = new Object[3][2]; 
		
		data[0][0] = "mngr332061";
		data[0][1] = "bUqened";
		
		data[1][0] =  "mngr332061";
		data[1][1] = "bUqened";
		
		data[2][0] =  "mngr332061";
		data[2][1] = "bUqened";
		
		return data;
	}
	
	@DataProvider()
	public Object [][] getDataFromExcel() throws Exception{
		String excelFileName = System.getProperty("user.dir") + "/testDataInputFiles/TestData.xlsx";
		String sheetName = "TestData";
		ExcelDriver excelDriver = new ExcelDriver();
		excelDriver.openWorkbook(excelFileName);
		Object [][] data;
		int rowCount = excelDriver.getRowCount(sheetName);
		int cellCount = excelDriver.getCellCountFromARow(sheetName, 1);
		data = new Object [rowCount + 1][cellCount];
		for(int row=0;row<=rowCount; row++) {
			for(int cell=0;cell< cellCount;cell++) {
				data[row][cell] = excelDriver.getCellData(sheetName,row,cell);
			}
		}
		return data;
	}
	
}

/*
 * 1.
Question 1
Which annotation is used to pass multiple test data to a test case?

1 / 1 point

@Parameter


@DataProvider


@TestProvider


@DataSuplier

Correct
Correct! @DataProvider annotation is used to pass test data to a test case

2.
Question 2
The Data-Driven testing approach lets you?

1 / 1 point

Reading from Database


Reading from Excel sheet


Test a feature or functionality with multiple sets of test data where data can be any external source like Excel or Database

Correct
Correct! Testing a feature/functionality with multiple sets of test data is data-driven testing. 

3.
Question 3
Which of the following are valid classes in Apache POI?

1 / 1 point

Sheet

Correct
Correct! Sheet class represent a sheet of an excel file


Row

Correct
Correct! Row class represent a row of a sheet


Cell

Correct
Correct! Cell class represent a cell of a row


Coloumn

4.
Question 4
Which attribute tell the test case about the test data source class? 

1 / 1 point

dataProviderClass


dataProvider

Correct
Correct! dataProviderClass is an attribute which defines the class where data source is defiend

**
*/
