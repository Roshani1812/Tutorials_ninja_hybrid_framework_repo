package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(xpath="//input[@name='email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailpasswordnotmatchingwaring;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmailAddress(String email)
	{
		emailTextField.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		passwordTextField.sendKeys(pwd);
	}
	
	public AccountPage clickOnLoginButton()
	{
		loginButton.click();
		return new AccountPage(driver);
	}
	
	public String retriveemailpasswordnotmatchingwariningMessageText()
	{
		String warningtext=emailpasswordnotmatchingwaring.getText();
		return warningtext;
	}
}
