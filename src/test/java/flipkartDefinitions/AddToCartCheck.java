package flipkartDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseClass.LibraryClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlipkartAddToCartPage;
import pages.FlipkartResultPage;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;

public class AddToCartCheck extends LibraryClass{
	ReusableFunctions re;
	FlipkartSearchpage search;
	FlipkartResultPage result;
	FlipkartAddToCartPage addToCart;
	
	private static final Logger logger = LogManager.getLogger(LibraryClass.class);

	@Given("Initialize the addtoCart class")
	public void initialize_the_addtoCart_class() {
	    re= new ReusableFunctions(driver);
	    search = new FlipkartSearchpage(driver);
	    result = new FlipkartResultPage(driver);
	    addToCart =  new FlipkartAddToCartPage(driver);
	    logger.info("initialized objects for add to cart class");
	}
	@When("Add to cart")
	public void add_to_cart() {
		result.clickResult();
		re.windowhandling();
	    addToCart.clickAddToCart();
	    logger.info("added to cart");
	}
	@Then("Take Screenshot then close browser")
	public void take_Screenshot_then_close_browser() throws IOException {
		re.takescreenshot("src/test/resources/screenshot/addedToCart.png");
		logger.info("Took screenshot of cart");
	}

}
