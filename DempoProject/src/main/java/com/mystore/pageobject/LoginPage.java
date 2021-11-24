package com.mystore.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class LoginPage  extends BaseClass{
	
	Action action= new Action();

	@FindBy(id = "email")
	WebElement EmailAddress;
	
	@FindBy(id = "passwd")
	WebElement Password;
	
	@FindBy(id = "SubmitLogin")
	WebElement Login;
	
	@FindBy(id = "email_create")
	WebElement CreateNewAccout;
	
	@FindBy(name = "SubmitCreate")
	WebElement CreateNewAccoutBtn;

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage LoginDetails(String uname , String passwd) {
		action.type(EmailAddress, uname);
		action.type(Password, passwd);
		action.click(getDriver(), Login);
		return new HomePage();
	}
	
	public AddressPage LoginDetails1(String uname , String passwd) {
		action.type(EmailAddress, uname);
		action.type(Password, passwd);
		action.click(getDriver(), Login);
		return new AddressPage();
	}
	
	public AccountCreationPage CreatingAcc(String newEmail) {
		action.type(CreateNewAccout,newEmail);
		action.click(getDriver(), CreateNewAccoutBtn);
		return new AccountCreationPage();
	}
}
