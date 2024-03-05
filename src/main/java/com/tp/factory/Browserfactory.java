package com.tp.factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tp.dataprovider.ConfigReader;



public class Browserfactory 
{

	
	public static void classAllsession(WebDriver driver)
	{
		driver.quit();
	}
	public static void closeActiveSession(WebDriver driver)
	{
		driver.close();
	}
	
	
	public static String captureCurrentDateAndTime()
	{
		String date= new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy").format(new java.util.Date());
		return date;
	}
	
	public static void captureScreenshot(WebDriver driver)
	{
		try 
		{
			org.openqa.selenium.io.FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File("./Screenshots/Screenshot_"+ Utility.captureCurrentDateAndTime()+".png"));
			
			System.out.println("Screenshot captured in screeshots directory");
		} 
		
		catch (WebDriverException e) 
		{
			System.out.println("could not take the screenshot"+e.getMessage());
			
		} catch (IOException e)
		{
			System.out.println("could not take the screenshot"+e.getMessage());
		}
	}
	public static WebElement getElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		
		highlightElement(driver, element);
		
         return element;
	}
	
	
	public static void highlightElement(WebDriver driver,WebElement element)
	{
       
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red;');",element);
		
		Utility.sleep(1);
		
		js.executeScript("arguments[0].setAttribute('style','border:3px solid black;');",element);
		
		
	}
	
	public static void sleep(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e)
		{
			
		}
	}
		
   public static void type(WebDriver driver,WebElement element,String value)
   {
	   try 
	   {
		element.sendKeys(value);
	   } 
	   catch (Exception e) 
	  {
		System.out.println("Not able to type-Trying values using javascriptExecutor");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].value=arguments[1]",element,value);
	  }
   }
	
	public static void clickElement(WebDriver driver,WebElement ele)
	{
		try 
		{
			ele.click();
		} 
		catch (Exception e) 
		{
          System.out.println("Normal click failed:Trying click using javascriptExecutor");
          
          JavascriptExecutor js=(JavascriptExecutor) driver;
          
          js.executeScript("arguments[0].click()",ele);

		}
	}
	
	
	
	public static WebDriver main(String appurl)
   
   {
	   
      WebDriver driver=new ChromeDriver();
	   
	   driver.manage().window().maximize();
	   
	
	   
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("pageload"))));
	  
	  driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("scriptTimeout"))));
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getproperty("implicitwait"))));
	   
	   driver.get(appurl);
	   
	   return driver;
   }
     public static WebDriver startBrowser(String browser,String appurl)
     {
    	 WebDriver driver=null;
    	 
    	 if(browser.equalsIgnoreCase("chrome"))
    	 {
    		 driver=new ChromeDriver();
    	 }
    	 else if(browser.equalsIgnoreCase("Firefox"))
        {
    	    driver=new FirefoxDriver();	 
    	 }else if(browser.equalsIgnoreCase("Edge"))
    	 {
    		 driver=new EdgeDriver();
    	 }else 
    	 {
			System.out.println("sorry currently we do not support"+browser);
		}
    	 
    	 driver.manage().window().maximize();
    	 driver.get(appurl);
    	 return driver;
     }
	}


