package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.LibraryClass;
import pages.FlipkartFilterPage;
import pages.FlipkartResultPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class FlipkartFilterTest extends LibraryClass{
	
	
	ReusableFunctions re;
	FlipkartSearchpage search;
	FlipkartResultPage result;
	FlipkartFilterPage filter;
	@BeforeClass
	public void initiallize() {
		
		re = new ReusableFunctions(driver);
		search = new FlipkartSearchpage(driver);
		result = new FlipkartResultPage(driver);
		filter = new FlipkartFilterPage(driver);
		
	
	}
	
	@Test
	public void testFilterBrand() {
		filter.filterBrand();
	}
	
	@Test
	public void testFilterRAM() throws InterruptedException {
		re.scrolldown(0, 50);
		filter.filterRAM();
	}
	
	@AfterClass
	public void last() throws IOException {
		System.out.println("filter class");

		re.takescreenshot("src/test/resources/screenshot/filter.png");

	}
}
