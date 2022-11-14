package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selenium.utility.WebdriverInstance;

public class ContactUsFormPage extends WebdriverInstance {
	
	@FindBy(how=How.NAME, using="name")
	//tek how. vendos tipin e laocator-it qe do perdor, ndersa tek using= vendos vlerem=n.
	static WebElement name;     //because the elements are not changing
	
	@FindBy(how=How.NAME, using="name")
	static WebElement email;
	
	@FindBy(how=How.NAME, using="name")
	static WebElement message;
	
	@FindBy(how=How.NAME, using="name")
	static WebElement send;
	
	//initialize page factory using constructor
	public ContactUsFormPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public void enterName(String names) {
		name.sendKeys(names);
	}
	
	public void enterEmail(String emails) {
		email.sendKeys(emails);
	}
	
	public void enterMessage(String messages) {
		message.sendKeys(messages);
	}
	
	public void clickOnSendButton() {
		send.submit();
	}
}
