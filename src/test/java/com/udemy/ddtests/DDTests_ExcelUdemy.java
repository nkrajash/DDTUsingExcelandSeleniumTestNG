package com.udemy.ddtests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDTests_ExcelUdemy {

		//Identify Test cases column by scanning the entire 1st row
		//once column is identified then scan entire test case column to identify Purchase test case row
		//after you grab purchase test case row = pull all the data of that row and feed into test

		public ArrayList<String> getData(String testcaseName) throws IOException
		{
			//fileInputStream argument
			ArrayList<String> a=new ArrayList<String>();
	
			FileInputStream fis=new FileInputStream("E:\\Data\\Selenium-workspace\\DatadrivenTestsusingExcelusingSeleniumTestNG\\resources\\demodata.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			System.out.println(workbook);
			int sheets=workbook.getNumberOfSheets();
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
				{
					XSSFSheet sheet=workbook.getSheetAt(i);
					
					//Identify Test cases column by scanning the entire 1st row
					Iterator<Row>  rows= sheet.iterator();// sheet is collection of rows
					Row firstrow= rows.next();
					Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
					int coloumn = 0;
					while(ce.hasNext())
					{
						Cell value=ce.next();
				
						if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							coloumn++;
							break;
						}
					}
					System.out.println(coloumn);
			
					////once column is identified then scan entire test case column to identify Purchase test case row
					while(rows.hasNext())
					{
			
						Row r=rows.next();
				
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName))
						{
							////after you grab purchase test case row = pull all the data of that row and feed into test
							Iterator<Cell>  cv=r.cellIterator();
							while(cv.hasNext())
							{
								Cell c= cv.next();
								if(c.getCellType() == CellType.STRING)
								{
									a.add(c.getStringCellValue());
								}
								else{
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
						}
					}
				}
			}
			return a;
		}
	
}
