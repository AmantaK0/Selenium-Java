package objects;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShoppingCartPage {

	public WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"wishlist-sidebar\"]/li[1]/div/div") public WebElement viewElement;
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[3]/div[3]/div[2]/div/div/a") public WebElement wlLink;
	
	public void addToCart() {
		 
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewElement);
			wlLink.click();
			
			int i = 0;
			
			while(driver.findElement(By.className("toolbar-number")).isDisplayed()) {
				
				List<WebElement> numberOfItems = driver.findElements(By.cssSelector(".product-items .product-item"));
				WebElement product = numberOfItems.get(i);
				
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
				
				Actions action = new Actions(driver);
				action.moveToElement(product);
				action.build().perform();
				
				List<WebElement> wishlistItems = driver.findElements(By.cssSelector(".actions-primary .tocart"));
				
				WebElement wl = wishlistItems.get(i);
				
				wl.click();
				
				WebElement size = driver.findElement(By.id("option-label-size-143-item-167"));
				size.click();
				 
			    WebElement color = driver.findElement(By.id("option-label-color-93-item-49"));
			    color.click();
				 
				 
				WebElement btn = driver.findElement(By.id("product-addtocart-button"));
				btn.click();
				
				//Check successful message
		  }
	}
	
	public void shoppingCartLink() {
		WebElement shoppingCartLink = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
		shoppingCartLink.click();
		
		WebElement viewAndEditLink = driver.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[5]/div/a"));
		viewAndEditLink.click();
		
		String expectedTitle = "Shopping Cart Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		//Verify that the prices sum for all items is equal to Order Total price in the Summary section.
	}
}


