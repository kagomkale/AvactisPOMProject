package com.avactis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.ApparelPage;
import com.avactis.qa.pages.ComputersPage;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.SignInPage;
import com.avactis.qa.pages.SportPage;

public class ApparelPageTest extends TestBase{
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	ApparelPage apparelpage;
	
	public ApparelPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage =new HomePage();
		homepage.clickSignInLink();
		signinpage= new SignInPage();
		myaccountpage = signinpage.signIn(prop.getProperty("email"), prop.getProperty("password"));	
		apparelpage=new ApparelPage();
		apparelpage= myaccountpage.clickonApparelLink();
	}
	@Test
	public void SelectIteminApparel() {
		//apparelpage.selectTshirt("Custom T-Shirt");
		apparelpage.selectTshirt(prop.getProperty("Apparel_Name"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
