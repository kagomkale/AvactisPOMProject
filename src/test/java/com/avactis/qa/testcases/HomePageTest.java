package com.avactis.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.SignInPage;

public class HomePageTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
	}
	@Test(priority=1)
	public void  ValidateHomePageTitle() {
		String title= homepage.HomePageTitle();
		Assert.assertEquals(title, "Avactis Demo Store");
	}
	@Test(priority=2)
	public void ValidateAvactisImage() {
		boolean flag = homepage.AvactisImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void validateclickSignInLink() {
		signinpage=homepage.clickSignInLink();
	}
	@AfterMethod
    public void tearDown() {
		driver.quit();
	}
	
}
