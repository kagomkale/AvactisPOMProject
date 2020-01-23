package com.avactis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class SignInPage extends TestBase {
	//Page Factory-Object Repository
	//declare the webelement
	@FindBy(xpath="//input[@name='email']")
	WebElement emailId;
	@FindBy(xpath="//input[@name='passwd']")
	WebElement password;
	@FindBy(xpath="//input[@value='Sign In']")
	WebElement signInButton;
	@FindBy(xpath="//button[text()='Register']")
	WebElement RegisterButton;
	@FindBy(xpath="//a[@class='site-logo']")
	WebElement avactisLogo;
	//to initialize the webElement using page factory
	//constructor method
	public SignInPage() {
		//initialize the PageFactory 
		PageFactory.initElements(driver, this);
		}
	//Actions or Functionality
	
	public String SignInPageTitle() {
		return driver.getTitle();
	}
	
	public boolean AvactisImage() {
		return avactisLogo.isDisplayed();
	}
	public MyAccountPage signIn(String em,String pwd ) {
		emailId.sendKeys(em);
		password.sendKeys(pwd);
		signInButton.click();
		return new MyAccountPage();
	}
	public void RegisterUser() {
		RegisterButton.click();
	}
}
