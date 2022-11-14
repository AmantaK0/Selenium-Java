package objects;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver driver) {  
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	} 

	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a") public WebElement createAcc;
	@FindBy(id = "firstname") public WebElement firstName;
	@FindBy(id = "lastname") public WebElement lastName;
	@FindBy(xpath = "//*[@id=\"is_subscribed\"]") public WebElement signUpForNewsletter;
	@FindBy(id = "email_address") public WebElement email;
	@FindBy(xpath = "//*[@id=\"password\"]") public WebElement password;
	@FindBy(xpath = "//*[@id=\"password-confirmation\"]") public WebElement confirmPassword;
	@FindBy(xpath = "//*[@id=\"form-validate\"]/div/div[1]/button") public WebElement createAccBtn;
	@FindBy(className = "message-success") public WebElement signUpMsg;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button") public WebElement dropdown;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a") public WebElement signOut;
	

	public void clickAndCheckTitle() { 
		
			driver.get("https://magento.softwaretestingboard.com/");
		
			createAcc.click();
			
			String expectedTitle = "Create New Customer Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
			 
            String actualTitle = driver.getTitle();
			
            Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void fillInFormFields(String fName,String lName,String eMail,String pass,String cpass ) {
	
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			signUpForNewsletter.click();
			email.sendKeys(eMail);
			password.sendKeys(pass);
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", email);
			
			confirmPassword.sendKeys(cpass);
			createAccBtn.click();
	}
	
	public void checkMessage() {
		
		String icon = ((JavascriptExecutor)driver).executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",signUpMsg).toString();
		String actual = signUpMsg.getText();

		String expected = "Thank you for registering with Fake Online Clothing Store.";
		
		String expectedText = icon + expected;
		String actualText = icon + actual;
		 
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void signOut() {
			dropdown.click();
			signOut.click();
	}
}