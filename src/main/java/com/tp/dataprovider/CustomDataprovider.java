package com.tp.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomDataprovider 

{
	@DataProvider(name="LoginCredentilas")
	public static Object[][] getLoginCredentials()
	{
		Object[][] arr=ExcelReader.getDatafromexcel("LoginCredentials");
		return arr;
			
	}
}