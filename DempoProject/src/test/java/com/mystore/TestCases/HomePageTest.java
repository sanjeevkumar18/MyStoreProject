package com.mystore.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mystore.Base.BaseClass;
import com.mystore.pageobject.HomePage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp();
	}
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test
	public void ValidateMyWishListTest() {
		Log.startTestCase("ValidateMyWishListTest");
		indexpage = new IndexPage();
		loginpage = indexpage.ClickOnSingIn();
		homepage = loginpage.LoginDetails(prop.getProperty("username"), prop.getProperty("password"));
		boolean validateMyWishList = homepage.ValidateMyWishList();
		AssertJUnit.assertTrue(validateMyWishList);
		Log.endTestCase("ValidateMyWishListTest");
	}
	
	@Test
	public void ValidateOrderHistoryandDetailsTest() {
		Log.startTestCase("ValidateMyWishListTest");
		indexpage = new IndexPage();
		loginpage = indexpage.ClickOnSingIn();
		homepage = loginpage.LoginDetails(prop.getProperty("username"), prop.getProperty("password"));
		boolean OrderHistoryResult = homepage.ValidateMyWishList();
		AssertJUnit.assertTrue(OrderHistoryResult);
		Log.endTestCase("ValidateMyWishListTest");
	}	

}
