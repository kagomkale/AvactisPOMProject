package com.avactis.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.ApparelPage;
import com.avactis.qa.pages.ComputersPage;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.MyCartPage;
import com.avactis.qa.pages.SignInPage;
import com.avactis.qa.pages.SportPage;
import com.avactis.qa.util.ReadExcelParticularRow;
import com.avactis.qa.util.TestUtil;

public class MyCartTest extends TestBase {
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	ApparelPage apparelpage;
	SportPage sportpage;
	ComputersPage computerspage;
	MyCartPage mycartpage;
	ReadExcelParticularRow readData;
	
	public MyCartTest() {
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
		sportpage=new SportPage();
		computerspage=new ComputersPage();
		mycartpage = new MyCartPage();
		readData=new ReadExcelParticularRow();
	//	mycartpage = myaccountpage.MyCartLink();
		//computerspage= myaccountpage.clickonComputerLink();
		//sportpage=myaccountpage.clickonSportLink();
		//computerspage=myaccountpage.clickonComputerLink();
	}
	/*@Test
	public void checkAddcartTitle() {
	mycartpage.validateShoppingCartTitle();
	
		
	}*/
	@Test(priority=1)
	public void AddItemsToCart() throws Throwable {
		apparelpage.selectTshirt(prop.getProperty("Apparel_Name"));
		driver.navigate().refresh();
		apparelpage.selectAddtoCartBtn();
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ajax_loader_text']")));
		sportpage=myaccountpage.clickonSportLink();
		sportpage.selectSportItem(prop.getProperty("Sport_Name"));
		sportpage.selectAddtoCartBtn();
		computerspage=myaccountpage.clickonComputerLink();
		computerspage.selectCategory(prop.getProperty("category_computers"));
		computerspage.selectcomputertItem(prop.getProperty("Notebook_name"));
		computerspage.selectAddtoCartBtn();
		myaccountpage.MyCartLink();
		mycartpage.validateShoppingCartTitle();
		mycartpage.NoOfRowsandColumns();
		mycartpage.clickCheckoutButton();
		}
	
	
    @AfterMethod
	public void tearDown() {
		//driver.quit();
	}


}


