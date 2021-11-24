package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class OrderPage extends BaseClass{
	
	Action action= new Action();

	@FindBy(id = "product_price_1_3_0")
	WebElement unitprice;
	
	@FindBy(xpath  = "//span[@id ='total_price']")
	WebElement totalprice;
	
	@FindBy(xpath = "//span[.='Proceed to checkout']")
	WebElement ProceedBtn;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getunitprice() {
		String UnitPriceInString = unitprice.getText();
		String unit = UnitPriceInString.replaceAll("[^a-zA-Z0-9]","");
		double FinalUnitPrice = Double.parseDouble(unit);
		return FinalUnitPrice/100;
	}
	
	public double gettotalprice() {
		String TotalPriceInString = totalprice.getText();
		String total = TotalPriceInString.replaceAll("[^a-zA-Z0-9]","");
		double FinalTotalPrice = Double.parseDouble(total);
		return FinalTotalPrice/100;
	}
	
	public LoginPage ProceedTocheckout() {
		action.click(getDriver(), ProceedBtn);
		return new LoginPage();
	}
}