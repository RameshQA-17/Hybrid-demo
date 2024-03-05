package com.tp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Loginpages 

{
    WebDriver driver;
	
	public Loginpages(WebDriver driver)                           
	{
		
		//constructor
		
	    this.driver=driver;
	}
	private By user=By.xpath("//input[@name='email1']");                 //Locator's
	
	private	By pass=By.xpath("//input[@name='password1']");
	
	private By loginbutton=By.xpath("//button[text()='Sign in']");
	
		
	public HomePage loginToApplicatinAdminuser(String username,String password)
	{
		driver.findElement(user).sendKeys(username);                        // Actions
		
		driver.findElement(pass).sendKeys(password);
		
		driver.findElement(loginbutton).click();
		
		HomePage home=new HomePage(driver);
		
		return PageFactory.initElements(driver, HomePage.class);
				
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
