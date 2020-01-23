package com.avactis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.ApparelPage;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.SignInPage;
import com.avactis.qa.pages.SportPage;

public class SportPageTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	//ApparelPage apparelpage;
	SportPage sportpage;
	
	public SportPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		homepage =new HomePage();
		homepage.clickSignInLink();
		signinpage= new SignInPage();
		myaccountpage = signinpage.signIn(prop.getProperty("email"), prop.getProperty("password"));	
		//apparelpage=new ApparelPage();
		sportpage=new SportPage();
		sportpage= myaccountpage.clickonSportLink();
		
	}
	@Test
	public void SelectIteminSport() {
		//apparelpage.selectTshirt("Custom T-Shirt");
		sportpage.selectSportItem(prop.getProperty("Sport_Name"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
