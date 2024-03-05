package com.tp.dataprovider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 

{
  public static String getproperty(String key)
  {
	  
	  Properties pro=new Properties();
	  
	  try {
		pro.load(new FileInputStream(new File("./Configuration/config.properties")));
		
	} catch (FileNotFoundException e) 
	  {
		System.out.println("file not found please check location"+e.getMessage());
		
	} 
	  catch (IOException e) 
	  {
		System.out.println("Could not read the file"+e.getMessage());
		
	}
	  String value=pro.getProperty(key);
	  
	  return value;
	  
	  
	  
  }
	
	
}
