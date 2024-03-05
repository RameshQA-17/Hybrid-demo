package com.tp.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tp.base.Baseclass;
import com.tp.dataprovider.CustomDataprovider;
import com.tp.factory.Browserfactory;
import com.tp.pages.HomePage;
import com.tp.pages.Loginpages;

public class Logintoapp2 extends Baseclass
{
	@Test(priority = 1,dataProvider = "LoginCredentials",dataProviderClass = CustomDataprovider.class)
           public void loginapp(String username,String password)
           {
        	 
        	  
			Loginpages login=new Loginpages(driver);
           
            HomePage Home = login.loginToApplicatinAdminuser(username, password);
              
            Assert.assertTrue(Home.getwelcomeMessage().contains("Welcome"), "Welcome msg did not appear");
        	   
         //Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Manage']")).isDisplayed(), "login is failed");
        	   
        	Browserfactory.closeActiveSession(driver);
        	
           }
}
