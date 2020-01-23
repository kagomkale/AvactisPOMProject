package com.avactis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class MyAccountPage extends TestBase {
	
	@FindBy(xpath="//span/span[contains(text(),'Aditi')] ")
	WebElement userNameLabel; 
	@FindBy(xpath="//a[contains(text(),'Apparel')]")
	WebElement ApparelLink;
	@FindBy(xpath="//a[contains(text(),'Computers')]")
	WebElement ComputersLink;
	@FindBy(xpath="//a[text()='DVD']")
	WebElement DVDLink;
	@FindBy(xpath="//a[contains(text(),'Furniture')]")
	WebElement FurnitureLink;
	@FindBy(xpath="//div[@class='header-navigation']/ul/li/a[text()='Sport']")
	WebElement SportLink;
	@FindBy(xpath="//a[contains(text(),'Digital Distribution')]")
	WebElement DigitalDistributionLink;
	@FindBy(xpath="//a[contains(text(),'My cart')]")
	WebElement MyCartLink;
	@FindBy(xpath="//a[contains(text(),'Checkout')]")
	WebElement CheckoutLink;
	@FindBy(xpath="//a[contains(text(),'Sign Out')]")
	WebElement SignOutLink;
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	WebElement MyAccountLink;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String verifyTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ApparelPage clickonApparelLink() {
		ApparelLink.click();
		return new ApparelPage();
	}
	public ComputersPage clickonComputerLink() {
		ComputersLink.click();
		return new ComputersPage();
	}
	public DVDPage clickonDVDVLink() {
		DVDLink.click();
		return new DVDPage();
	}
	public FurniturePage clickonFurnitureLink() {
		FurnitureLink.click();
		return new FurniturePage();
	}
	public SportPage clickonSportLink() {
		SportLink.click();
		return new SportPage();
	}
	public DigitalDistributionPage DigDisLink() {
		DigitalDistributionLink.click();
		return new DigitalDistributionPage();
	}
	public MyCartPage MyCartLink() {
		MyCartLink.click();
		return new MyCartPage();
	}

}
