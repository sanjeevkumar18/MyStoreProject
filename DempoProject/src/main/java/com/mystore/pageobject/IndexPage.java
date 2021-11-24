package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;


public class IndexPage extends BaseClass {
	
	Action action= new Action();
	
	@FindBy(linkText = "Sign in")
	WebElement signinbtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement mystoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchproductbox;

	@FindBy(name = "submit_search")
	WebElement searchbutton;	

	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage ClickOnSingIn() {
		action.click(getDriver(), signinbtn);
		return new LoginPage();	
	}
	
	public boolean ValidateLogo() {
		return action.isDisplayed(getDriver(), mystoreLogo);
	}
	
	public String GetTitle() {
		 String title = getDriver().getTitle();
		 return title;
	}
	
	public SearchResultPage Searchboxvalidation(String searchbox) {
		action.type(searchproductbox, searchbox);
		action.click(getDriver(), searchbutton);
		return new SearchResultPage();
	}
	
	
	
}	