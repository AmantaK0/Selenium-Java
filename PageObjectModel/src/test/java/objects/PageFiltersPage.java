package objects;

import java.awt.Color;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageFiltersPage {
	
	WebDriver driver;
	
	public PageFiltersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ui-id-4") public WebElement womenDropdown;
	@FindBy(xpath = "//*[@id=\"ui-id-9\"]") public WebElement tops;
	@FindBy(xpath = "//*[@id=\"ui-id-11\"]") public WebElement jackets;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]/div[1]") public WebElement colorDropdown;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[4]/div[2]/div/div/a[1]/div") public WebElement colorBlack;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]/div[1]") public WebElement price;
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/div[3]/div[2]/ol/li[1]/a") public WebElement firstPrice;
	
	
	
	public void womenDropdown() {
			womenDropdown.click();
			Actions action = new Actions(driver);
			action.moveToElement(womenDropdown);
			action.moveToElement(tops);
			action.build().perform();
			jackets.click();
	}
	
	public void shoppingOptions() {
			colorDropdown.click();
			colorBlack.click();
			
			List<WebElement> elemsColor = driver.findElements(By.id("option-label-color-93-item-49"));
			
			for(WebElement we : elemsColor){
				
				String outlineColor = we.getCssValue("outline-color");
				
				String color[];  
				color = outlineColor.replace("rgba(", "").split(",");       
				String actualColor = String.format("#%02x%02x%02x", Integer.parseInt(color[0].trim()), Integer.parseInt(color[1].trim()), Integer.parseInt(color[2].trim()));  
				System.out.println("Convert rgb to hex : " + actualColor);
				 
				String expectedColor = "#ff5501";
				 
				Assert.assertEquals(actualColor, expectedColor);
			} 
			
			price.click();
			firstPrice.click();
			
			List<WebElement> numberOfItems = driver.findElements(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li"));
			int actualLength = numberOfItems.size();
			int expectedLength = 1;
			
			Assert.assertEquals(actualLength, expectedLength);
			
	}
}
