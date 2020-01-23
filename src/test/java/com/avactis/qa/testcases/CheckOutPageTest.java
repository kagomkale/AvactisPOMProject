package com.avactis.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import com.avactis.qa.base.TestBase;
import com.avactis.qa.pages.ApparelPage;
import com.avactis.qa.pages.CheckOutPage;
import com.avactis.qa.pages.ComputersPage;
import com.avactis.qa.pages.HomePage;
import com.avactis.qa.pages.MyAccountPage;
import com.avactis.qa.pages.MyCartPage;
import com.avactis.qa.pages.SignInPage;
import com.avactis.qa.pages.SportPage;
import com.avactis.qa.util.ReadExcelParticularRow;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;


public class CheckOutPageTest extends TestBase  {
	HomePage homepage;
	SignInPage signinpage;
	MyAccountPage myaccountpage;
	ApparelPage apparelpage;
	SportPage sportpage;
	ComputersPage computerspage;
	MyCartPage mycartpage;
	CheckOutPage checkoutpage;
	ReadExcelParticularRow readData;
	private static Logger Log = Logger.getLogger(CheckOutPageTest.class.getName());
	
	
	public CheckOutPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		DOMConfigurator.configure("log4j.xml");
		Reporter.log("Application Launched successfully");
		Log.info("Testing started");
		homepage =new HomePage();
		homepage.clickSignInLink();
		signinpage= new SignInPage();
		myaccountpage = signinpage.signIn(prop.getProperty("email"), prop.getProperty("password"));	
		Log.info("Successful Signup");
		apparelpage=new ApparelPage();
		apparelpage= myaccountpage.clickonApparelLink();
		sportpage=new SportPage();
		computerspage=new ComputersPage();
		mycartpage = new MyCartPage();
		checkoutpage=new CheckOutPage();
		readData=new ReadExcelParticularRow();
}
	
	@Test
	public void AddItemsToCart() throws Throwable {
		apparelpage.selectTshirt(prop.getProperty("Apparel_Name"));
		driver.navigate().refresh();
		apparelpage.selectAddtoCartBtn();
		Log.info("One Item added to cart");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ajax_loader_text']")));
		sportpage=myaccountpage.clickonSportLink();
		sportpage.selectSportItem(prop.getProperty("Sport_Name"));
		sportpage.selectAddtoCartBtn();
		Log.info("Second item added to cart");
		computerspage=myaccountpage.clickonComputerLink();
		computerspage.selectCategory(prop.getProperty("category_computers"));
		computerspage.selectcomputertItem(prop.getProperty("Notebook_name"));
		computerspage.selectAddtoCartBtn();
		Log.info("third item added to cart");
		myaccountpage.MyCartLink();
		mycartpage.validateShoppingCartTitle();
		mycartpage.NoOfRowsandColumns();
	    checkoutpage=mycartpage.clickCheckoutButton();
	    //direct to new page
	    //verify billing address
	   String actual_title_address1= checkoutpage.getAddress1();
	   readData.ReadExcelRow(9,1);
	    Assert.assertEquals(actual_title_address1, readData.ReadExcelRow(10,1),"Shipping address line 1 is not matched");
	    System.out.println("Address line1 of Registered User is matched ");
	    String actual_title_address2=checkoutpage.getAddress2();
	    String expected_title_address2=readData.ReadExcelRow(11,1);
	    Assert.assertEquals(actual_title_address2, expected_title_address2,"Shipping address line 2 is not matched");
	    System.out.println("Address line2 of Registered User is matched ");
	    //check billing options
	    checkoutpage.clickbillingbtn();
	    //check shipping options
	    checkoutpage.shippingBtnOption();
	    Reporter.log("Shipping and Billing verified");
	   }

/*	@Test
	public void CheckData() throws Exception  {
		readData.ReadExcelRow();	
	}*/
		
/*	@DataProvider
	public Object[][] getTestDataAvoctis() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}*/
	
	
    @AfterMethod
	public void tearDown() {
    	
		driver.quit();
		Log.info("Browser closed");
		Reporter.log("User is Logged out and application is closed");
	}
/*public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1,

        String outputDirectory) {
	// TODO Auto-generated method stub
	 

	        // Second parameter of this method ISuite will contain all the suite executed.

	        for (ISuite iSuite : arg1) {

	         //Get a map of result of a single suite at a time

	            Map<String,ISuiteResult> results =    iSuite.getResults();

	         //Get the key of the result map

	            Set<String> keys = results.keySet();

	        //Go to each map value one by one

	            for (String key : keys) {

	             //The Context object of current result

	            ITestContext context = results.get(key).getTestContext();

	            //Print Suite detail in Console

	             System.out.println("Suite Name->"+context.getName()

	                    + "::Report output Ditectory->"+context.getOutputDirectory()

	                     +"::Suite Name->"+ context.getSuite().getName()

	                     +"::Start Date Time for execution->"+context.getStartDate()

	                     +"::End Date Time for execution->"+context.getEndDate());

	            

	             //Get Map for only failed test cases

	            IResultMap resultMap = context.getFailedTests();

	            //Get method detail of failed test cases

	            Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

	            //Loop one by one in all failed methods

	            System.out.println("--------FAILED TEST CASE---------");

	            for (ITestNGMethod iTestNGMethod : failedMethods) {

	                //Print failed test cases detail

	                System.out.println("TESTCASE NAME->"+iTestNGMethod.getMethodName()

	                        +"\nDescription->"+iTestNGMethod.getDescription()

	                        +"\nPriority->"+iTestNGMethod.getPriority()

	                        +"\n:Date->"+new Date(iTestNGMethod.getDate()));

	                

	            }*/

	        

	        

	        


}




