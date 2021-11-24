package com.mystore.TestCases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mystore.Base.BaseClass;
import com.mystore.pageobject.AddToCartPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.OrderPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{

	IndexPage indexpage;
	SearchResultPage searchreasultpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	@BeforeMethod
	public void setup() throws Throwable {
		LaunchApp();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	

	@Test
	public void ValidateOrderPageTest() {
		Log.startTestCase("ValidateOrderPageTest");
		indexpage = new IndexPage();
		searchreasultpage = indexpage.Searchboxvalidation("t-shirt");
		addtocartpage = searchreasultpage.SearchPage();
		addtocartpage.EnterTheQuality("2");
		addtocartpage.SelectTheSize("M");
		addtocartpage.ClickOnAddToCartBtn();
		orderpage = addtocartpage.ProceedBtnInCartPage();
		Double getunitprice = orderpage.getunitprice();
		Double gettotalprice = orderpage.gettotalprice();
		Double TheValueIs = (getunitprice * 2)+2;
		AssertJUnit.assertEquals(gettotalprice, TheValueIs);
		Log.endTestCase("ValidateOrderPageTest");
		
		
		
	}
}
