package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.LibraryClass;
import pages.FlipkartResultPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class FlipkartResulTest extends  LibraryClass{
	ReusableFunctions re;
	FlipkartSearchpage search;
	FlipkartResultPage result;
	WebDriver driver;
	@BeforeClass
	public void initiallize() {
		this.driver = LibraryClass.driver;
		re = new ReusableFunctions(driver);
		search = new FlipkartSearchpage(driver);
		result = new FlipkartResultPage(driver);
		
	}
	
//	@Test(priority = 1)
//	public void searchMobile() {
//		
//	}
	
	@Test(priority = 1)
	public void resultClick() {
		result.clickResult();
	}
	
	@Test(priority = 2)
	public void changeWndow() {
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

		// assuming you started with only 1 tab, the new one is at index 1
		driver.switchTo().window(windowHandles.get(1));

	}
	
	@Test(priority = 3)
	public void getProductDetails() {
		WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//h1//span")
		        ));
		result.productDetails("Product name", name);
	}
	@AfterClass
	public void last() throws IOException {
		
		System.out.println("search result class");

		re.takescreenshot("src/test/resources/screenshot/flipkartResultSearch.png");

		re.getTitle();
		
	}
}
