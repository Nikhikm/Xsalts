package com.Xsalts.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Utilities 
{
	//public static String sheetName ="Sheet1"; 
	public static Object [][] data;
	
	@DataProvider
	public static Object[][] providedata(String sheetName) throws IOException
	{
       Object[][] data= getFormData(sheetName);
	   return data;
    
	}
	

	public static Object[][] getFormData(String sheetName) throws IOException   
	{
		FileInputStream file = new FileInputStream("C:\\Users\\User\\eclipse-workspace2\\Xsalts\\src\\test\\resources\\TestData\\Book1.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet(sheetName);
		data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) 
			{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}
	
}
