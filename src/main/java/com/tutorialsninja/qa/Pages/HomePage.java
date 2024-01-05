package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;

	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement clickonsearchbutton;
	
	@FindBy(linkText="HP LP3065")
	private WebElement warningmessage;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccountDropMenu()
	{
		myAccountDropMenu.click();
	}
	
	public  LoginPage clickOnLoginButton()
	{
		loginButton.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterButton()
	{
		registerButton.click();
		return new RegisterPage(driver);
	}
	
	public void enterIntoSearchField(String text)
	{
		searchTextField.sendKeys(text);
	}
	
	public SearchPage clickOnSerachButton()
	{
		clickonsearchbutton.click();
		return new SearchPage(driver);
	}
	
	
	
}
