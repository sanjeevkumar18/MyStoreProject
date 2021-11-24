package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class OrderSummaryPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement ConfirmMyOrder;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public OrderConfirmationPage ClickTheConfirmMyOrder() {
		action.click(getDriver(), ConfirmMyOrder);
		return new OrderConfirmationPage();
	}

}
