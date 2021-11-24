package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class PaymentPage  extends BaseClass{
	

	Action action= new Action();
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	 WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummaryPage clickOnPaymentMethod() {
		action.click(getDriver(), bankWireMethod);
		return new OrderSummaryPage();
	}

}
