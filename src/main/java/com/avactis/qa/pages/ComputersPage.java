package com.avactis.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class ComputersPage extends TestBase {
		public ComputersPage() {
			PageFactory.initElements(driver, this);
		}
		public void selectCategory(String categoryname) {
			driver.findElement(By.xpath("//h3/a[contains(text(),'"+categoryname+"')]")).click();
		}
		public void selectcomputertItem(String cmname) {
			driver.findElement(By.xpath("//h3[text()='"+cmname+"']")).click();
		}
		 public void selectAddtoCartBtn() {
		    	driver.findElement(By.xpath("//input[@value='Add To Cart']")).click();
		    }


}
