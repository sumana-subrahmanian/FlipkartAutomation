package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.LibraryClass;
import pages.FlipkartAddToCartPage;
import pages.FlipkartResultPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class FlipkartAddToCartTest extends LibraryClass{
	ReusableFunctions re;

	FlipkartAddToCartPage addcart;
	
	@BeforeClass
	public void initiallize() {
		
		re = new ReusableFunctions(driver);
		addcart = new FlipkartAddToCartPage(driver);
		
	}
	
	@Test(priority = 1)
	public void addToCart() throws InterruptedException {
		addcart.clickAddToCart();
		
		Thread.sleep(3000);

	}
	@Test(priority = 2)
	public void cart() throws InterruptedException {
		addcart.goToCart();
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void last() throws IOException {
		System.out.println("add to cart class");
		re.takescreenshot("src/test/resources/screenshot/cart.png");

		re.getTitle();
		
	}
}
