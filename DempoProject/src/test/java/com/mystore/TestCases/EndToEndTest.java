package com.mystore.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mystore.Base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.PaymentPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest  extends BaseClass{

	IndexPage indexpage;
	SearchResultPage searchreasultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addresspage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummarypage;
	OrderConfirmationPage ordercnfrmpage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test
	public void EndToEndTesting() {
		Log.startTestCase("EndToEndTesting");
		indexpage = new IndexPage();
		searchreasultpage = indexpage.Searchboxvalidation("t-shirt");
		addtocartpage = searchreasultpage.SearchPage();
		addtocartpage.EnterTheQuality("2");
		addtocartpage.SelectTheSize("M");
		addtocartpage.ClickOnAddToCartBtn();
		orderpage = addtocartpage.ProceedBtnInCartPage();
		loginpage = orderpage.ProceedTocheckout();
		addresspage = loginpage.LoginDetails1(prop.getProperty("username"), prop.getProperty("password"));
		shippingpage =addresspage.ClickOnProceedBtn();
		shippingpage.ClickThecheckbox();
		paymentpage = shippingpage.ClickTheProceedBtn();
		ordersummarypage = paymentpage.clickOnPaymentMethod();	
		ordercnfrmpage = ordersummarypage.ClickTheConfirmMyOrder();
		String validateTheMessage = ordercnfrmpage.ValidateTheMessage();
		String ExpectedThemessage = "Your order on My Store is complete.";
		AssertJUnit.assertEquals(validateTheMessage, ExpectedThemessage);
		Log.endTestCase("EndToEndTesting");
	}
}
