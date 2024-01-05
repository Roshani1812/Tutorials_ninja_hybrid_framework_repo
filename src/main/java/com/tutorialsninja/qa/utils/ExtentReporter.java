package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentreports=new ExtentReports();
		File extentreportfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html");
		ExtentSparkReporter spark=new ExtentSparkReporter(extentreportfile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Tutorialsninja test automation results report");
		spark.config().setDocumentTitle("Tutorials ninja automation reports");
		spark.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentreports.attachReporter(spark);
		
		Properties prop=new Properties();
		File configfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(configfile);
		prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		extentreports.setSystemInfo("Application URL",prop.getProperty("url"));
		extentreports.setSystemInfo("Browser Name", prop.getProperty("browsername"));
		extentreports.setSystemInfo("Operating system", System.getProperty("os.name"));
		extentreports.setSystemInfo("Username", System.getProperty("user.name"));
		extentreports.setSystemInfo("Java version", System.getProperty("java.version"));
		
		return extentreports;
		
	}
}
