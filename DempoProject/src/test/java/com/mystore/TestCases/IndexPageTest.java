package com.mystore.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import com.mystore.Base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexpage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		LaunchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void ValidatingTheLogo() {
		Log.startTestCase("ValidatingTheLogo");
		indexpage = new IndexPage();
		boolean validateLogo = indexpage.ValidateLogo();
		AssertJUnit.assertTrue(validateLogo);
		Log.endTestCase("ValidatingTheLogo");
	}
	
	@Test
	public void ValidatingTheTitle() {
		Log.startTestCase("ValidatingTheTitle");
		String getTitle = indexpage.GetTitle();
		AssertJUnit.assertEquals(getTitle, "My Store");
		Log.endTestCase("ValidatingTheTitle");
	}
}
