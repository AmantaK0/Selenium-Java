package objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		
		signIn.click();
		
		email.sendKeys(em); 
		password.sendKeys(pass);
		
		WebElement button = driver.findElement(By.cssSelector("button#send2.action.login.primary"));
		System.out.println(button.getText());
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#send2.action.login.primary")));
		
		button.click();	
		
		//Check your username is displayed on right corner of the page.
	}
	
	public void signOut() {
		dropdown.click();
		signOuBtn.click();
	}
}
