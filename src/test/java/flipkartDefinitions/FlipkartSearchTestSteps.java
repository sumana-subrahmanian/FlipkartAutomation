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

public class FlipkartSearchTestSteps extends LibraryClass{

		ReusableFunctions re;

	    FlipkartSearchpage search;

	    private static final Logger logger = LogManager.getLogger(LibraryClass.class);

	    @Given("To launch the browser and enter url")
	    public void to_launch_the_browser_and_enter_url() {
			
		

	        logger.info("Application Launched");
			re = new ReusableFunctions(driver);

	        search = new FlipkartSearchpage(driver);



		}
	 
	    @When("Enter text in the search field")
	    public void enter_text_in_the_search_field() {

			search.search("Mobiles");

			logger.info("Searched Mobiles");

			search.clicksearch();

			logger.info("Clicked Search");

		}

	    @Then("Search the result should get displayed")
	    public void search_the_result_should_get_displayed() {

		    re.getTitle();

		    logger.info("Naviagted to result page");

		}
	 

	 
}
