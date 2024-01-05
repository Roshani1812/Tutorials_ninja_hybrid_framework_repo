package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.LoginPage;
import com.tutorialsninja.qa.basepacakage.Baseclass;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Baseclass{
	
	
	public LoginTest()
	{
		super();
	}
	public WebDriver driver;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup()
	{
		driver=intializebrowserandOpenapplication(prop.getProperty("browsername"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		loginpage=homepage.clickOnLoginButton();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	
	@DataProvider(name="ValidCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		Object[][] data=Utilities.getTestDataFromExcel("Login_data");
		return data;
	}
	
	
	@Test(priority=1,dataProvider = "ValidCredentialsSupplier")
	public void Verifyloginwithvalidcredentials(String email, String password)
	{
		loginpage.enterEmailAddress(email);
		loginpage.enterPassword(password);
		AccountPage accountpage=loginpage.clickOnLoginButton();
		Assert.assertTrue(accountpage.getDisplaystausofedityouraccountinformationoption());
	
	}
	
	@Test(priority=2)
	public void Verifyloginwithinvalidcredentials()
	{
		
		loginpage.enterEmailAddress(Utilities.getdateandtimestamp());
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage=loginpage.retriveemailpasswordnotmatchingwariningMessageText();
		Assert.assertEquals(actualWarningMessage, dataprop.getProperty("actualWarningMessage"));
		
	}
	
	@Test(priority=3)
	public void Verifyloginwithinavalidemailandvalidpassword()
	{
		
		loginpage.enterEmailAddress(Utilities.getdateandtimestamp());
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage=loginpage.retriveemailpasswordnotmatchingwariningMessageText();
		Assert.assertEquals(actualWarningMessage, dataprop.getProperty("actualWarningMessage"));
		
		
	}
	
	@Test(priority=4)
	public void Verifyloginwithvalidemailandinvalidpassword()
	{
		
		loginpage.enterEmailAddress(prop.getProperty("validemail"));
		loginpage.enterPassword(dataprop.getProperty("invalidpassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage=loginpage.retriveemailpasswordnotmatchingwariningMessageText();
		Assert.assertEquals(actualWarningMessage, dataprop.getProperty("actualWarningMessage"));
		
		
	}
	
	@Test(priority=5)
	public void Verifyloginwithoutprovidingcredentials()
	{
		
		loginpage.clickOnLoginButton();
		String actualWarningMessage=loginpage.retriveemailpasswordnotmatchingwariningMessageText();
		Assert.assertEquals(actualWarningMessage, dataprop.getProperty("actualWarningMessage"));
	}
	
	
	
	
	
	

}
