package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Pages.AccountSuccessPage;
import com.tutorialsninja.qa.Pages.HomePage;
import com.tutorialsninja.qa.Pages.RegisterPage;
import com.tutorialsninja.qa.basepacakage.Baseclass;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Baseclass{

	RegisterPage registerpage;
	AccountSuccessPage accountsuccespage;
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		driver=intializebrowserandOpenapplication(prop.getProperty("browsername"));
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		registerpage=homepage.clickOnRegisterButton();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	@Test(priority=1)
	public void Verifyregisterandaccountwithmandatoryfields()
	{
		
		registerpage.enterfirstNameTextField("Roshani");
		registerpage.enterlastNameTextField("Rathi");
		registerpage.enteremailTextField(Utilities.getdateandtimestamp());
		registerpage.entertelephoneTextField("9876543210");
		registerpage.enterpasswordTextField("Roshani@123");
		registerpage.enterconfirmPasswordTextField("Roshani@123");
		registerpage.clickonagreeField();
		
		accountsuccespage=registerpage.clickoncontinueField();
		String actualsuccessheading=accountsuccespage.verifyactualsuccessheadingmessage();
		Assert.assertEquals(actualsuccessheading,"Your Account Has Been Created!","Account success page is not display");
		
	}
	
	@Test(priority=2)
	public void Verifyregisterwithexistingemailaddress()
	{
		
		
		registerpage.enterfirstNameTextField("Roshani");
		registerpage.enterlastNameTextField("Rathi");
		registerpage.enteremailTextField("test1812@gmail.com");
		registerpage.entertelephoneTextField("9876543210");
		registerpage.enterpasswordTextField("Roshani@123");
		registerpage.enterconfirmPasswordTextField("Roshani@123");
		registerpage.clickonagreeField();
		registerpage.clickoncontinueField();
		
		
		String Wearningmessage=registerpage.verifyexistingWearningmessage();
		Assert.assertEquals(Wearningmessage, "Warning: E-Mail Address is already registered!","Warning message regarding duplicate email is not displayed");
		
	}

	@Test(priority=3)
	public void Verifyregisterwithoutfillinganydetails()
	{
		
		
		registerpage.clickoncontinueField();
		
		String actualprivacypolicywarning=registerpage.verifyactualprivacypolicywarning();
		Assert.assertTrue(actualprivacypolicywarning.contains("Warning: You must agree to the Privacy Policy!"),"Privacy policy message is not display");
		
		String actualFirstNameWarning=registerpage.verifyactualFirstNameWarning();
		Assert.assertTrue(actualFirstNameWarning.contains("First Name must be between 1 and 32 characters!"),"Firstname warning message is not display");
		
		
	}

}
