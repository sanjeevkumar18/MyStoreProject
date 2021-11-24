package com.mystore.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.mystore.Base.BaseClass;
import com.mystore.pageobject.AccountCreationPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.LoginPage;
import com.mystore.utility.Log;

public class AccountCreationPageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginpage;
	AccountCreationPage acccreationpage;
	
	@BeforeMethod
	public void setup() throws Throwable {
		LaunchApp();
	}
	
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test
	public void CreatingAccTest() {
		Log.startTestCase("CreatingAccTest");
		indexpage = new IndexPage();
		loginpage = indexpage.ClickOnSingIn();
		acccreationpage =loginpage.CreatingAcc("sanjeevkumar2k01@gmail.com");
		boolean accountCreation = acccreationpage.AccountCreation();
		AssertJUnit.assertTrue(accountCreation);
		Log.endTestCase("CreatingAccTest");
	}
}	
