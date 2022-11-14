package com.selenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class WebdriverInstance {
	public static WebDriver driver;
	public static String baseURL="https://learn-selenium-automation-testing.blogspot.in";
	
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(baseURL);
	}
	
	
	@AfterMethod
	public void verifyResults(ITestResult results) {
		if(results.getStatus()==ITestResult.FAILURE) {
			Reporter.log("Failed"+results.getTestName());
		}else if(results.getStatus()==ITestResult.SKIP) {
			Reporter.log("Skipped"+results.getTestName());
		}else {
			Reporter.log("Passed"+results.getTestName());
		}
	}
}
