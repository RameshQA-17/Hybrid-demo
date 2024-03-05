package com.tp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 

{
	
     WebDriver driver;
     
     public HomePage(WebDriver driver)
     {
    	 this.driver=driver;
    	 
     }
     
     private By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
     
     public String getwelcomeMessage()
     {
    	   String welcometext = driver.findElement(welcomeMsg).getText();
    	   
    	   return welcometext;
     }
}
