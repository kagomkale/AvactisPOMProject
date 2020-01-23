package com.avactis.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.SignInPage;

public class SignInPageTest extends TestBase{
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	
	
	public SignInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage =new HomePage();
		homepage.clickSignInLink();
	    signinpage = new SignInPage();
	}
	@Test(priority=1)
	public void ValidateSignInPageTitle() {
		String title= signinpage.SignInPageTitle();
		Assert.assertEquals(title, "Avactis Demo Store");
	}
	@Test(priority=2)
	public void AvactisImageTest() {
			boolean flag = signinpage.AvactisImage();
			Assert.assertTrue(flag);
		}
	@Test(priority=3)
	public void signInTest() {
		myaccountpage = signinpage.signIn(prop.getProperty("email"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
