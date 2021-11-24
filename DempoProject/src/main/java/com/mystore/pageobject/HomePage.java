package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class HomePage extends BaseClass{
	
	Action action= new Action();
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement MyWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement OrderHistoryandDetails;
	
	public HomePage() {
		PageFactory.initElements(getDriver(),this);
	}

	public boolean ValidateMyWishList() {
		return action.isDisplayed(getDriver(), MyWishList);
	}
	
	public void ValidateOrderHistoryandDetails() {
		action.isDisplayed(getDriver(), OrderHistoryandDetails);
	}
	
	public String GetCurrentUrl() {
		String currentUrl = getDriver().getCurrentUrl();
		return currentUrl;
	}
}
