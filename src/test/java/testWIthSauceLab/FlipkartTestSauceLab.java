package testWIthSauceLab;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class FlipkartTestSauceLab {
	
	@Test
    public void runOnSauceLabs() throws Exception {

		String sauceUserName = System.getenv("SAUCE_USERNAME");
		String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
		
		
//		System.out.println("Sauce Username: " + sauceUserName);
//		System.out.println("Sauce Access Key length: " + (sauceAccessKey != null ? sauceAccessKey.length() : "null"));

        // Sauce Labs URL

        String sauceURL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.eu-central-1.saucelabs.com/wd/hub";

        // Desired capabilities

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("browserName", "chrome");

        caps.setCapability("platformName", "Windows 11");

        caps.setCapability("browserVersion", "latest");

        // Sauce-specific options

        caps.setCapability("sauce:options", new java.util.HashMap<String, Object>() {{

            put("name", "Filpkart Test");

            put("build", "Build-102");

        }});

        // Start remote driver

        WebDriver driver = new RemoteWebDriver(new URL(sauceURL), caps);

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/div/input")).sendKeys("mobiles");	        

        System.out.println("Title: " + driver.getTitle());

        driver.quit();

    }

}
