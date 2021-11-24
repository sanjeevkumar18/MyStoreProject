package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class AddressPage extends BaseClass {

	Action action= new Action();
	
	@FindBy(xpath = "//span[.='Proceed to checkout']")
	WebElement ProceedToBtn;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public ShippingPage ClickOnProceedBtn() {
		action.click(getDriver(), ProceedToBtn);
		return new ShippingPage();
	}
}
