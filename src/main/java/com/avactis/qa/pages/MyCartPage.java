package com.avactis.qa.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.avactis.qa.base.TestBase;

public class MyCartPage extends TestBase {
	
	@FindBy(xpath="//table[@summary='Shopping cart']")
	WebElement ShoppingCartTitle;
	@FindBy(xpath="//div[@class='form-group']/a[contains(text(),'Checkout')]")
	WebElement checkoutButton;
	
	public MyCartPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public void validateShoppingCartTitle() {
		String title=ShoppingCartTitle.getAttribute("summary");
		Assert.assertEquals(title, "Shopping cart","Title of My Cart page not matched");
	}
	public void NoOfRowsandColumns() throws ParseException {
		List <WebElement>col= driver.findElements(By.xpath("//table[@summary='Shopping cart']/tbody/tr/th"));
		System.out.println("No. of columns are " +col.size());
		List <WebElement>row=driver.findElements(By.xpath("//table[@summary='Shopping cart']/tbody/tr/td[1]"));
		System.out.println("No. of rows are " +row.size());
        for(int i =2;i<=(row.size()+1);i++) {
        	String max;
        	max=driver.findElement(By.xpath("//table[@summary='Shopping cart']/tbody/tr["+i+"]/td[2]/h3")).getText();
        	System.out.println("Description of"+i+"product is: "+max);
        	if(max.contains("T-shirt")) {
        		Assert.assertEquals(max,prop.getProperty("Apparel_Name"),"The cart item is same as booked ");
        		//continue;
        	} else if(max.contains("Eagle")) {
        		Assert.assertEquals(max, prop.getProperty("Sport_Name"),"The cart item is same as booked ");
        		//continue;
        	} else if(max.contains("Laptop")) {
        		Assert.assertEquals(max, prop.getProperty("Notebook_name"),"The cart item is same as booked ");
        		//continue;
        	}

	     }
     }
	public CheckOutPage clickCheckoutButton() {
		checkoutButton.click();
		return new CheckOutPage();
	}
}
