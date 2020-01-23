package com.avactis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class SportPage extends TestBase {
	public SportPage() {
		PageFactory.initElements(driver, this);
	}
	public void selectSportItem(String spname) {
		driver.findElement(By.xpath("//h3[contains(text(),'" +spname+ "')]")).click();
	}
	 public void selectAddtoCartBtn() {
	    	driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();
	 }

}
