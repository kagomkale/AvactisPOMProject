package com.avactis.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.ComputersPage;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.SignInPage;
import com.avactis.qa.pages.SportPage;

public class ComputersPageTest extends TestBase{
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	//ApparelPage apparelpage;
	//SportPage sportpage;
	ComputersPage computerspage;
	
	public ComputersPageTest() {
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
		//sportpage=new SportPage();
		computerspage=new ComputersPage();
		computerspage= myaccountpage.clickonComputerLink();
		
	}
	@Test
	public void SelectIteminComputers() {
		//apparelpage.selectTshirt("Custom T-Shirt");
		computerspage.selectCategory(prop.getProperty("category_computers"));
		computerspage.selectcomputertItem(prop.getProperty("Notebook_name"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
