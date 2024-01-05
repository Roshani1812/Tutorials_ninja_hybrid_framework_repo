package com.tutorialsninja.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	@FindBy(linkText="HP LP3065")
	private WebElement warningmessage;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement Nosuchproductwarningmessage;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifywarningmessagedisplayed()
	{
		Boolean message=warningmessage.isDisplayed();
		return message;
	}
	
	public Boolean verifyinvalidproductwarningmessagedisplayed()
	{
		Boolean message=Nosuchproductwarningmessage.isDisplayed();
		return message;
	}
}
