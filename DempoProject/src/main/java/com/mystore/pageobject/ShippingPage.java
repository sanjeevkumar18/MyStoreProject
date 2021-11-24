package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class ShippingPage extends BaseClass{

	Action action= new Action();
	
	@FindBy(id = "cgv")
	WebElement checkbox;
	
	@FindBy(name = "processCarrier")
	WebElement ProceedToCheckoutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver() ,this);
	}
	
	public void ClickThecheckbox() {
		action.click(getDriver(), checkbox);
	}
	
	public PaymentPage ClickTheProceedBtn() {
		action.click(getDriver(), ProceedToCheckoutBtn);
		return new PaymentPage();
	}
}
