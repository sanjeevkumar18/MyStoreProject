package com.mystore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
//	public static WebDriver driver; 

	//change the driver from webdriver driver to threadlocal driver bcoz of parallel exsicution 
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		// get the driver from thread local
		return driver.get();
	}
	
	static Action action= new Action();
	
	
	@BeforeSuite
	public void loadconfig() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j2.xml");
		
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	


		
	public static void LaunchApp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		String Browsername = prop.getProperty("browser");
		
		if(Browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		}else if(Browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}	else if(Browsername.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());
		}
		/*
		 * else if(Browsername.equalsIgnoreCase("Chromium")) {
		 * WebDriverManager.chromiumdriver().setup(); driver.set(new
		 * ChromiumDriverManager()); }
		 */
		
		
		
		getDriver().manage().window().maximize();
		action.implicitWait(getDriver(), 10);
		action.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		}
		
	@AfterMethod
	public void aftermethod() {
		ExtentManager.endReport();
	}
	
	
	
	}

