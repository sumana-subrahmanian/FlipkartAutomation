package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.Properties;
import java.util.Comparator; 

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReusableFunctions;

public class LibraryClass {
	
	protected static WebDriver driver;
	protected static Properties config = new Properties();
	static ReusableFunctions re;
	private static final Logger logger = LogManager.getLogger(LibraryClass.class);
	
//	@BeforeTest
	public static void openApp() {
		loadConfig();
		initializeBrowser();
		openApplication();
		re = new ReusableFunctions(driver);
		
	}
	
//	@AfterTest
	public static void closeApp() {
		closeBrowser();
	}
	//load Config.property
	public static void loadConfig() {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/Configuration.Properties/Config.property");
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
//	public static void initializeBrowser() {
//		loadConfig();
//		String browser = config.getProperty("browser","chrome");
//		
//		int implicitWait = Integer.parseInt(config.getProperty("implicitWait","10"));
//		
//		if(browser.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			logger.info("Launching Chrome");
//		}
//		else if(browser.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//			logger.info("Launching Firefox");
//		}
//		else {
//			throw new RuntimeException("Unsupported browser");
//		}
//		
//		driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
//	}
	
	// This method initializes the WebDriver based on the browser specified in the config.
		public static void initializeBrowser() {
			loadConfig();
			String browser = config.getProperty("browser","chrome");
			
			int implicitWait = Integer.parseInt(config.getProperty("implicitWait","10"));
			
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				
				// Creating ChromeOptions to configure the browser for Docker execution.
				ChromeOptions options = new ChromeOptions();
				// This is essential for a standalone Chrome driver in a Docker container.
				options.addArguments("--remote-allow-origins=*");
				// Disables the sandbox, which is necessary when running Chrome as root inside Docker.
				options.addArguments("--no-sandbox");
				// Prevents crashes in a Docker environment by disabling the use of /dev/shm.
				options.addArguments("--disable-dev-shm-usage");
				
				// This block creates a unique, temporary directory for each browser session.
				// This fixes the "user data directory is already in use" error by ensuring
				// that each test has its own isolated profile.
				try {
					Path tempDir = Files.createTempDirectory("chrome-profile-");
					options.addArguments("--user-data-dir=" + tempDir.toAbsolutePath().toString());
					
					// A shutdown hook is added to ensure this temporary directory is deleted when the program exits.
					Runtime.getRuntime().addShutdownHook(new Thread(() -> {
						try {
							// Deletes the directory and all its contents recursively.
							Files.walk(tempDir)
								.sorted(Comparator.reverseOrder())
								.map(Path::toFile)
								.forEach(java.io.File::delete);
						} catch (IOException e) {
							logger.error("Failed to delete temp directory: " + tempDir, e);
						}
					}));
				} catch (IOException e) {
					logger.error("Failed to create temporary user data directory", e);
				}

				driver = new ChromeDriver(options);
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
