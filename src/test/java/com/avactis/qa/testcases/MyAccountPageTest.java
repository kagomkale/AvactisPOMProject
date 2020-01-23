package com.avactis.qa.testcases;

import org.testng.Assert;
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

public class MyAccountPageTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	ApparelPage apparelpage;
	ComputersPage computerspage;
	SportPage sportpage;
	public MyAccountPageTest() {
		super();
	}
@BeforeMethod
public void setUp() {
	initialization();
	homepage =new HomePage();
	homepage.clickSignInLink();
	signinpage= new SignInPage();
	apparelpage=new ApparelPage();
	computerspage=new ComputersPage();
	sportpage= new SportPage();
	myaccountpage = signinpage.signIn(prop.getProperty("email"), prop.getProperty("password"));	
}
@Test(priority=1)
public void verifyMyAccountPageTitle() {
	String title=myaccountpage.verifyTitle();
	Assert.assertEquals(title, "Avactis Demo Store","My account page title is not matched");
}
//need to check correct xpath
 /*@Test(priority=2)
public void verifyUserNameTest() {
	Assert.assertTrue(myaccountpage.verifyCorrectUserName());
}*/
@Test(priority=2)
public void verifyApparelLink() {
	apparelpage=myaccountpage.clickonApparelLink();
}
@Test(priority=3)
public void verifyComputersLink() {
	computerspage=myaccountpage.clickonComputerLink();
}
@Test(priority=4)
public void verifySportLink() {
	sportpage= myaccountpage.clickonSportLink();
}
@AfterMethod
public void tearDown() {
	driver.quit();
}

}
