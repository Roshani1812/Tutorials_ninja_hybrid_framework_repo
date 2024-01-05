package com.tutorialsninja.qa.basepacakage;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Baseclass {
	

	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public Baseclass()
	{
		prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		dataprop=new Properties();
		File datapropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
		FileInputStream datapropfis=new FileInputStream(datapropfile);
		dataprop.load(datapropfis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis=new FileInputStream(propfile);
			prop.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public WebDriver intializebrowserandOpenapplication(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equals("safari"))
		{
			driver=new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}

}
