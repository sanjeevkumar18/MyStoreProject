package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class AddToCartPage extends BaseClass {
	
	Action action= new Action();

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement AddToCartBtn;
	
	@FindBy(id = "quantity_wanted")
	WebElement quality;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(xpath = "//i[@class='icon-ok']")
	WebElement AddToCartMessage;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement ProcedeToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	public void EnterTheQuality(String Quality1) {
		action.type(quality, Quality1);
	}
	
	public void SelectTheSize(String Size) {
		action.selectByVisibleText(Size,size);
	}
	
	public void ClickOnAddToCartBtn() {
		action.click(getDriver(), AddToCartBtn);
	}
	
	public boolean ValidateAddToCartMessage() {
		action.fluentWait(getDriver(), AddToCartMessage, 10);
		return action.isDisplayed(getDriver(), AddToCartMessage);
	}
	
	public OrderPage ProceedBtnInCartPage() {
		action.fluentWait(getDriver(), ProcedeToCheckoutBtn, 10);
		action.JSClick(getDriver(), ProcedeToCheckoutBtn);
		return new OrderPage(); 
	}
	
	
}
