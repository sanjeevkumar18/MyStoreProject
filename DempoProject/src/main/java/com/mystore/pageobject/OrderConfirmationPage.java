package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;

public class OrderConfirmationPage extends BaseClass{
	
	@FindBy(xpath = "//strong[.='Your order on My Store is complete.']")
	WebElement ConfirmMessage;
	
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public String ValidateTheMessage() {
		String ConfirmMsg = ConfirmMessage.getText();
		return ConfirmMsg;
	}

}
