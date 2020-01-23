package com.avactis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class ApparelPage extends TestBase{
	//but writing such xpath is not good idea as it varies for each product so dont usepage facory in this
	/*@FindBy(xpath="//h3[contains(text(),'Custom T-Shirt ')]")
	WebElement CustomTshirt;*/
	public ApparelPage() {
		PageFactory.initElements(driver, this);
	}
	public void selectTshirt(String name) {
		driver.findElement(By.xpath("//h3[contains(text(),'"+name+"')]")).click();
	}
    public void selectAddtoCartBtn() {
    	driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();
    }
}
