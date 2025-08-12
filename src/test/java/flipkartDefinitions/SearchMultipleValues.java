package flipkartDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseClass.LibraryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class SearchMultipleValues extends LibraryClass{
	
	ReusableFunctions re;

    FlipkartSearchpage search;
    String text;
    private static final Logger logger = LogManager.getLogger(LibraryClass.class);

	@Given("Launch the browser and enter url")
	public void launch_the_browser_and_enter_url() {

        logger.info("Application Launched");
		re = new ReusableFunctions(driver);

        search = new FlipkartSearchpage(driver);


	}
	@When("Enter {string} in the search field")
	public void enter_in_the_search_field(String string) {
		text = string;
		search.search(string);

		logger.info("Searched "+string);

		search.clicksearch();

		logger.info("Clicked Search");

	}
	@Then("Search  result should get displayed")
	public void search_result_should_get_displayed() {
		re.getTitle();

	    logger.info("Naviagted to result page");
	}
	@Then("Take screenshot then close browser")
	public void take_screenshot_then_close_browser() throws IOException {
		re.takescreenshot("src/test/resources/screenshot/Search"+text+".png");
        logger.info("Took screenshot");
        closeBrowser();
        logger.info("Closed Browser");
	}

}
