package com.selenium.pagetests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.utility.WebdriverInstance;

public class ContactUsFormPage extends WebdriverInstance{
	ContactUsFormPage contactUsFormPage;
	
	@BeforeClass
	public void run() {
		setUp();
		contactUsFormPage = new ContactUsFormPage();
	}
	
	//CREATING TEST CASES
	
	@Test(priority=0)
	public String verifyPageTitle() {
		String pageTitle = contactUsFormPage.verifyPageTitle();
		Assert.assertEquals(pageTitle, "Learn Selenium Automation Testing");
		return pageTitle;
	}
	
	@Test(priority=1)
	public void enterCustName() {
		contactUsFormPage.enterName("John");
		//Reporter.log(...)
	}
	
	@Test(priority=2)
	public void enterCustEmail() {
		contactUsFormPage.enterEmail("john@doe.com");
		//Reporter.log(...)
	}
	
	@Test(priority=3)
	public void enterCustMessage() {
		contactUsFormPage.enterMessage("This is the message");
		//Reporter.log(...)
	}
	
	@Test(priority=4)
	public void clickSendButton() {
		contactUsFormPage.clickOnSendButton();
		//Reporter.log(...)
	}
}
