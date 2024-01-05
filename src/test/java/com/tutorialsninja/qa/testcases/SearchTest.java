package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.SearchPage;
import com.tutorialsninja.qa.basepacakage.Baseclass;

public class SearchTest extends Baseclass {
	
	public SearchTest()
	{
		super();
	}
	
	public WebDriver driver;
	HomePage homepage;
	SearchPage searchpage;
	
	@BeforeMethod
	public void setup()
	{
		driver=intializebrowserandOpenapplication(prop.getProperty("browsername"));
		homepage=new HomePage(driver);
		
	}
	@Test(priority=1)
	public void VerifyingsearchwithValidProduct()
	{
		
		homepage.enterIntoSearchField("HP");
		searchpage=homepage.clickOnSerachButton();
		Assert.assertTrue(searchpage.verifywarningmessagedisplayed(),"Valid product is not display");
	}
	
	@Test(priority=2)
	public void VerifyingsearchwithnonvalidProduct()
	{
		
		homepage.enterIntoSearchField("Honda");
		searchpage=homepage.clickOnSerachButton();
		Assert.assertEquals("abcd","No search product message is display");
	}
	
	@Test(priority=3,dependsOnMethods = "VerifyingsearchwithnonvalidProduct")
	public void Verifysearchwithoutanyproduct()
	{
		searchpage=homepage.clickOnSerachButton();
		Assert.assertTrue(searchpage.verifyinvalidproductwarningmessagedisplayed(),"No search product message is display");

	}

	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
