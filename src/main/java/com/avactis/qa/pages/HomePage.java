package com.avactis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class HomePage extends TestBase{
	//Page Factory-Object Repository
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement SignIn;
	@FindBy(xpath="//a[@class='site-logo']")
	WebElement avactisLogo;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	//Actions or Functionality
	
		public String HomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean AvactisImage() {
			return avactisLogo.isDisplayed();
		}
		
	    public SignInPage clickSignInLink() {
		SignIn.click();
		return new SignInPage();
	}

}
