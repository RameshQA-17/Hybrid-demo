package com.tp.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelReader 

{
	@DataProvider(name = "registationData")
	public static Object[][] getDatafromexcel(String sheetName)

	{
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File("./Testdata/Testing1.xlsx")));
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not found" + e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Could not load file");
		}
		
	    int rowcount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
	 
	    int columncount=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
	    
	    Object[][] arr=new Object[rowcount-1][columncount];
	    
	   
	    
	    for(int i=1;i<rowcount;i++)
	    {
	    	for(int j=0;j<columncount;j++)
	    	{
	    		
	    		String value="";
	    	
	    		CellType type = wb.getSheet(sheetName).getRow(i).getCell(j).getCellType();
	    		
	    		if(type==CellType.NUMERIC)
	    		{
	    			 value =String.valueOf(wb.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue());
	    		}
	    		
	    		else if(type==CellType.STRING)
	    		{
	    			  value=wb.getSheet("Sample").getRow(i).getCell(j).getStringCellValue();
	    		}
	    		else if(type==CellType.BOOLEAN)
	    		{
	    			value=String.valueOf(wb.getSheet(sheetName).getRow(i).getCell(j).getBooleanCellValue());
	    			
	    		}
	    		else if(type==CellType.BLANK)
	    		{
	    			value="";
	    		}
	    		
	    		arr[i-1][j]=value;
	}
	    	
	    }
	     return arr;
	}
	}



