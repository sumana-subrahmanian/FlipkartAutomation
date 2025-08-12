package flipkartDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import baseClass.LibraryClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends  LibraryClass{
	private static final Logger logger = LogManager.getLogger(LibraryClass.class);

	@Before
	public void setUp() {
		initializeBrowser();
		openApplication();
		logger.info("Browser launched and navigated to the application");
	}
	@After
	public void tearDown() {
		closeBrowser();
		logger.info("Browser closed");
	}
}
