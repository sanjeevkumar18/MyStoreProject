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


public class LoginPageTest extends BaseClass{
	
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
	public void ValidationOfLoginPage() {
		 Log.startTestCase("ValidationOfLoginPage");
		 indexpage = new IndexPage();
		 Log.info("User is going to click oc signin");
		 loginpage = indexpage.ClickOnSingIn();
		 Log.info("Enter the Username and Password");
		 homepage = loginpage.LoginDetails(prop.getProperty("username"), prop.getProperty("password"));
		 String getCurrentUrl = homepage.GetCurrentUrl();
		 String homepageurl = "http://automationpractice.com/index.php?controller=my-account";
		 Log.info("Verfying if user is able to login");
		 AssertJUnit.assertEquals(getCurrentUrl, homepageurl);
		 Log.info("Login is success");
		 Log.endTestCase("ValidationOfLoginPage");
	}
}
