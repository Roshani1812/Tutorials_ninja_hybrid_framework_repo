package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telephoneTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@name='confirm']")
	private WebElement confirmPasswordTextField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueField;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement existingWearningmessage;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement actualprivacypolicywarning;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement actualFirstNameWarning;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterfirstNameTextField(String firstName)
	{
		firstNameTextField.sendKeys(firstName);
	}
	
	public void enterlastNameTextField(String lastName)
	{
		lastNameTextField.sendKeys(lastName);
	}
	
	public void enteremailTextField(String email)
	{
		emailTextField.sendKeys(email);
	}
	
	public void entertelephoneTextField(String telephone)
	{
		telephoneTextField.sendKeys(telephone);
	}
	
	public void enterpasswordTextField(String pwd)
	{
		passwordTextField.sendKeys(pwd);
	}
	
	public void enterconfirmPasswordTextField(String pwd)
	{
		confirmPasswordTextField.sendKeys(pwd);
	}
	
	public void clickonagreeField()
	{
		agreeField.click();
	}
	
	public AccountSuccessPage clickoncontinueField()
	{
		continueField.click();
		return new AccountSuccessPage(driver);
	}
	
	public String verifyexistingWearningmessage()
	{
		String warningmessage=existingWearningmessage.getText();
		return warningmessage;
	}
	
	public String verifyactualprivacypolicywarning()
	{
		String actualprivacypolicywarningmessage=actualprivacypolicywarning.getText();
		return actualprivacypolicywarningmessage;
	}
	
	public String verifyactualFirstNameWarning()
	{
		String actualFirstNameWarningmessage=actualFirstNameWarning.getText();
		return actualFirstNameWarningmessage;
	}
	
}
