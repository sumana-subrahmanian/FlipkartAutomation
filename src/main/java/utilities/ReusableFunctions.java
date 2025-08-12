package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableFunctions {
	WebDriver driver;
	 
    public ReusableFunctions(WebDriver driver) {
        this.driver = driver;
    }
 
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
 
    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element);
        element.click();
    }
 
    public void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }
    public void takescreenshot(String path) throws IOException {
    	TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
 
        // Now copy the screenshot to desired location using copyFile method
        FileUtils.copyFile(src, new File(path));
    }
    public void scrolldown(int x, int y) throws InterruptedException {
 
		   JavascriptExecutor js =(JavascriptExecutor)driver;
		   String scrollby = "window.scrollBy("+x+","+y+")";
		   js.executeScript(scrollby);
		   Thread.sleep(5000);
		   

    }

    public void windowhandling() {
    	
    	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

		// assuming you started with only 1 tab, the new one is at index 1
		driver.switchTo().window(windowHandles.get(1));
		System.out.println("window "+driver.getTitle());
    }
    public void alerthandling(String value) throws InterruptedException {
    	 Alert alert = driver.switchTo().alert();
		   Thread.sleep(4000);
		   alert.sendKeys(value);
		   alert.accept();
    }

    public void waitforClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void getTitle() {
		System.out.println("Page title : "+driver.getTitle());
		
	}
}
