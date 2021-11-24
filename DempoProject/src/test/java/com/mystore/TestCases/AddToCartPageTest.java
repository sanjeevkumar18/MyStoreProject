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

public class AddToCartPageTest extends BaseClass{
	
	SearchResultPage searchpageresult;
	IndexPage indexpage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test
	public void ValidatingAddtocartpage() {
		Log.startTestCase("ValidatingAddtocartpage");
		indexpage = new IndexPage();
		searchpageresult = indexpage.Searchboxvalidation("t-shirt");
		addtocartpage = searchpageresult.SearchPage();
		addtocartpage.EnterTheQuality("2");
		addtocartpage.SelectTheSize("M");
		addtocartpage.ClickOnAddToCartBtn();
		boolean ResultMsg = addtocartpage.ValidateAddToCartMessage();
		AssertJUnit.assertTrue(ResultMsg);
		Log.endTestCase("ValidatingAddtocartpage");
	}
}
