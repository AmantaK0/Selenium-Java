package objects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WishListPage {
	public WebDriver driver;
	
	public WishListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li[1]/a") public WebElement removePrice;
//	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]") public WebElement lisItem;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[2]/a[1]") public WebElement wishlist;
	
	
	public void removePriceFilter() {
			removePrice.click();
			//Check the items number displayed is increased.
	}
	
	public void addToWishlist() {

		JavascriptExecutor j = (JavascriptExecutor)driver;
	      if (j.executeScript("return document.readyState").toString().equals("complete")){
	         System.out.println("Page has loaded");
	      }
			
		for(int i = 0 ; i < 2; i++) {
			List<WebElement> numberOfItems = driver.findElements(By.cssSelector(".product-items .product-item"));
			WebElement product = numberOfItems.get(i);
			System.out.println(product);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
			Actions action = new Actions(driver);
			action.moveToElement(product);
			action.build().perform();
					
					
			List<WebElement> wishlistItems = driver.findElements(By.cssSelector(".actions-secondary .towishlist"));

			WebElement wl = wishlistItems.get(i);
				
//					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".actions-secondary .towishlist")));
					
			 wl.click();
		 
			 WebElement message = driver.findElement(By.className("success"));
			 String actualMsg = message.getText();
						
			 System.out.println("Contains sequence 'Wish': " + actualMsg.contains("Wish"));
				
			 
			 driver.navigate().back();
		}
				
				//Click on User Profile, and check the correct number of items is displayed (My Wish List (2 items)).
	}

}
