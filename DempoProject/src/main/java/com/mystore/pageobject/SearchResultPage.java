package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class SearchResultPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(xpath = "//div[@class='product-container']")
	WebElement searchproduct;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean IsProductAvailable() {
		return action.isDisplayed(getDriver(), searchproduct);
	}
	
	public AddToCartPage SearchPage() {
		action.click(getDriver(), searchproduct);
		return new AddToCartPage();
	}
}
