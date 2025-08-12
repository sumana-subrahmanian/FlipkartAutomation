package flipkartDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.LibraryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartResultPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class ResultPageTest extends LibraryClass{
	ReusableFunctions re;
	FlipkartSearchpage search;
	FlipkartResultPage result;
	private static final Logger logger =  LogManager.getLogger(LibraryClass.class);
	@Given("Initialize the result page class")
	public void initialize_the_result_page_class() {
	    re = new ReusableFunctions(driver);
		search = new FlipkartSearchpage(driver);
		result = new FlipkartResultPage(driver);
		logger.info("initialized objects for result page class");
	}
	@When("Click on the result and change the window")
	public void click_on_the_result_and_change_the_window() {
	    result.clickResult();
	    re.windowhandling();
	    logger.info("clicked on the result and switched the wndow");
	}
	@Then("Get product name")
	public void get_product_name() {
		WebElement name = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//h1//span")
		        ));
		result.productDetails("Product name", name);
		logger.info("got product name ");
	}
	@Then("Close browser aafter taking screenshot")
	public void close_browser_aafter_taking_screenshot() throws IOException {
		re.takescreenshot("src/test/resources/screenshot/ResultSearch.png");
		logger.info("Took screenshot of result page");

	}

}
