package com.tp.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.tp.dataprovider.ConfigReader;
import com.tp.factory.Browserfactory;

public class Baseclass

{
   
	
   protected WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		 Browserfactory.startBrowser(ConfigReader.getproperty("browser"), ConfigReader.getproperty("appURL"));
		 
	}
	
	@AfterClass
	public void teardown()
	{
		Browserfactory.closeActiveSession(driver);
	}
}
