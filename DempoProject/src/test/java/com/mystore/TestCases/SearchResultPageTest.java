package com.mystore.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.mystore.Base.BaseClass;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.utility.Log;

public class SearchResultPageTest extends BaseClass{

	IndexPage indexpage;
	SearchResultPage searchreasultpage;
	
	@BeforeMethod
	public void setup() throws Throwable {
		LaunchApp();
	}
	
	
	@AfterMethod
	public void teardown() {
		getDriver().quit();
	}
	
	@Test
	public void CheckingTheProduct() {
		Log.startTestCase("CheckingTheProduct");
		indexpage = new IndexPage();
		searchreasultpage = indexpage.Searchboxvalidation("t-shirt");
		boolean result = searchreasultpage.IsProductAvailable();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("CheckingTheProduct");
	}
}
