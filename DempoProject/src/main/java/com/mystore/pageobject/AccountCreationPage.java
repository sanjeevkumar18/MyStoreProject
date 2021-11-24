package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class AccountCreationPage extends BaseClass{
	
	Action action= new Action();

	@FindBy(xpath = "//h1[.='Create an account']")
	WebElement ValidateHeadingOnly;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean AccountCreation() {
		return action.isDisplayed(getDriver(), ValidateHeadingOnly);
	}
}
