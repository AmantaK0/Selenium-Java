package testScenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.CreateAccountPage;
import objects.PageFiltersPage;
import objects.ShoppingCartPage;
import objects.SignInPage;
import objects.WishListPage;

public class testMethods {
	WebDriver driver;
	
	CreateAccountPage create;
	SignInPage sp;
	PageFiltersPage pf;
	WishListPage wp;
	ShoppingCartPage shp;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1, enabled = false)
	public void createAccount() {
		CreateAccountPage create = new CreateAccountPage(driver);
		create.clickAndCheckTitle();
		create.fillInFormFields("soft", "testing", "soft@hotmail.com", "Strongpass123!", "Strongpass123!");
		create.checkMessage();
		create.signOut();
	} 
	
	@Test(priority = 2)
	public void signIn() {
		SignInPage sp = new SignInPage(driver);
		sp.signIn("demo@hotmail.com", "Strongpass123!");
//		sp.signOut();
	}
	
	@Test(priority = 3) 
	public void checkPageFilters() {
		PageFiltersPage pf = new PageFiltersPage(driver);
		pf.womenDropdown();
		pf.shoppingOptions();
	}
	
	@Test(priority = 4) 
	public void wishList() {
		WishListPage wp = new WishListPage(driver);
		wp.removePriceFilter();
		wp.addToWishlist();
	}

	@Test(priority = 5) 
	public void shoppingCart() {
		ShoppingCartPage shp = new ShoppingCartPage(driver);
		shp.addToCart();
		shp.shoppingCartLink();
	}
//	
//	@Test(priority = 6) 
//	public void emptyShoppingCart() {
//		
//	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
