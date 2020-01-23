package com.avactis.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.avactis.qa.base.TestBase;

public class CheckOutPage extends TestBase{
	@FindBy(name="shippingInfo[Streetline1]")
	WebElement address1;
	@FindBy(name="shippingInfo[Streetline2]")
	WebElement address2;
	@FindBy(xpath="//input[@name='paymentModule[method_code]']")
	WebElement billingRadioBtn;
	@FindBy(xpath="//input[ @value='BCE5D24D-666C-43CA-94A0-D6F775903BE2_1']")
	WebElement ShippingOptionBtn;
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	
	public String getAddress1() {
		String address_1=address1.getAttribute("value");
		//System.out.println(address_1);
		return address_1;
	}
	public String getAddress2() {
		String address_2=address2.getAttribute("value");
		//System.out.println(address_2);
		return address_2;
	}
	public void clickbillingbtn() {
		//Actions action=new Actions(driver);
		//action.moveToElement(billingRadioBtn).build().perform();
		boolean flag=billingRadioBtn.isSelected();
		if(flag=false)
				 {
			billingRadioBtn.click();	
				}else {
					System.out.println("Shipping method is already selected.");
				}
	}
	public void shippingBtnOption() {
		boolean flag=ShippingOptionBtn.isSelected();
		if(flag=false)
				 {
			ShippingOptionBtn.click();	
				}else {
					System.out.println("Shipping method is already selected.");
				}
		
	}
}
