package com.avactis.qa.base;
/*
 * Author Kalyani
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.avactis.qa.util.TestUtil;
import com.avactis.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	//public static Logger Log = Logger.getLogger(Logger.class.getName());
	
	public TestBase() {
		try 
		{
		prop = new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\configs\\config.properties");
		prop.load(ip);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
 		if(browserName.equals("Chrome")) {
 			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kalyani\\eclipse-workspace\\webdrivertraining\\test\\resources\\chromedriver.exe");
 			driver= new ChromeDriver();
 		} else if(browserName.contentEquals("Firefox")) {
 			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kalyani\\eclipse-workspace\\webdrivertraining\\test\\resources\\geckodriver-64bit.exe");
 			 driver= new FirefoxDriver();
 		} else {
 			System.out.println("No browser value is given");
 		}
 		
 		
 	/*	e_driver = new EventFiringWebDriver(driver);
 		//now create object of eventlistenerhandler to register it with eventfiringwebdriver
 		eventListener=new WebEventListener();
 		e_driver.register(eventListener);
 		driver=e_driver;*/
 		driver.manage().window().maximize();
 		driver.manage().deleteAllCookies();
 		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
 		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
 		
 		driver.get(prop.getProperty("url"));
 	}
 	

}