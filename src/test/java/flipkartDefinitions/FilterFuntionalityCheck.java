package flipkartDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseClass.LibraryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartFilterPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class FilterFuntionalityCheck extends LibraryClass{
	ReusableFunctions re;
	FlipkartSearchpage search;
	FlipkartFilterPage filter;
	private static final Logger logger = LogManager.getLogger(LibraryClass.class);

	@Given("Initialize the filter class")
	public void initialize_the_filter_class() {
	
		re = new ReusableFunctions(driver);
	
	    search = new FlipkartSearchpage(driver);
	    filter = new FlipkartFilterPage(driver);
	    logger.info("initialized objects for filter class");
	}
	@When("Filter based on brand")
	public void filter_based_on_brand() {
	    filter.filterBrand();
	    
	    logger.info("Filtered mobiles mbased on Brand");
	}
	@Then("Filter based on RAM")
	public void filter_based_on_ram() throws InterruptedException {
		re.scrolldown(0, 50);
	    filter.filterRAM();
	    logger.info("Filtered mobiles mbased on RAM");
	}
	@Then("Take screenshot and close")
	public void take_screenshot_and_close() throws IOException {
	
		re.takescreenshot("src/test/resources/screenshot/filter2.png");
//		closeBrowser();
		logger.info("Took screenshot after filtering");
	
	}

}
