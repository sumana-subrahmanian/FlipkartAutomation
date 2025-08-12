package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReusableFunctions;

public class LibraryClass {
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	static ReusableFunctions re;
	private static final Logger logger = LogManager.getLogger(LibraryClass.class);
	
	@BeforeTest
	public static void openApp() {
		loadConfig();
		initializeBrowser();
		openApplication();
		re = new ReusableFunctions(driver);
		
	}
	
	@AfterTest
	public static void closeApp() {
		closeBrowser();
	}
	//load Config.property
	public static void loadConfig() {
		try {
			FileInputStream fis = new FileInputStream("/src/test/resources/Cnnfiguration.Properties/Config.property");
			config.load(fis);
			logger.info("Read property info");
		}
		catch(IOException e){
			System.out.println("Failed to load configuration : "+e);
		}
	}
	
	 //old function
//    public static void initializeBrowser() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    }
 
	
	//new function
	public static void initializeBrowser() {
		loadConfig();
		String browser = config.getProperty("browser","chrome");
		
		int implicitWait = Integer.parseInt(config.getProperty("implicitWait","10"));
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Launching Chrome");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Launching Firefox");
		}
		else {
			throw new RuntimeException("Unsupported browser");
		}
		
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	}
	
//    public static void openApplication() {
//    	String url = config.getProperty("url");
//        driver.get(url);
//        
//        logger.info("Navigate to url");
//    }
	public static void openApplication() {
        driver.get("https://www.flipkart.com/");
        
        logger.info("Navigate to url");
    }
 
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            logger.info("Close  browser");
        }
    }
}
