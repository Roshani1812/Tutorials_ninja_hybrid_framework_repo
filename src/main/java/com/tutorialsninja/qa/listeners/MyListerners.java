package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListerners implements ITestListener{
	ExtentReports extentreport;
	ExtentTest extentTest;
	String testName;
	
	@Override
	public void onStart(ITestContext context) {
		extentreport = ExtentReporter.generateExtentReport();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		testName=result.getName();
		extentTest = extentreport.createTest(testName);
		extentTest.log(Status.INFO, testName+" started executing");
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, testName+" Got successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String destinationscreenshotpath= Utilities.captureScreenshot(driver, testName);
		System.out.println(result.getThrowable());
		
		extentTest.addScreenCaptureFromPath(destinationscreenshotpath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName+" Got failed");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+" Got Skipped");
	}

	

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
		String pathofectentreport=System.getProperty("user.dir")+"\\test-output\\extentReports\\extentreport.html";
		File extentreportfilepath=new File(pathofectentreport);
		try {
			Desktop.getDesktop().browse(extentreportfilepath.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
