package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a") public WebElement signIn;
	@FindBy(id = "email") public WebElement email;
	@FindBy(id = "pass") public WebElement password;
	@FindBy(xpath = "//*[@id=\"send2\"]") public WebElement signInBtn;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button") public WebElement dropdown;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a") public WebElement signOuBtn;
	
	
	public void signIn(String em, String pass) {
		
		driver.get("https://magento.softwaretestingboard.com/");
		
		signIn.click();
		
		email.sendKeys(em); 
		password.sendKeys(pass);
		signInBtn.click();	
		//Check your username is displayed on right corner of the page.
	}
	
	public void signOut() {
		dropdown.click();
		signOuBtn.click();
	}
}
