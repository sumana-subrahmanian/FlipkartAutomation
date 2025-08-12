package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.ReusableFunctions;

public class FlipkartFilterPage {
	ReusableFunctions re;
	WebDriver driver;
	
	public FlipkartFilterPage(WebDriver driver) {
		this.driver=driver;
	}
	public void filterBrand() {
		driver.findElement(By.xpath("//div[contains(text(),'MOTOROLA')]")).click();
	}
	public void filterRAM() {
		driver.findElement(By.xpath("//div[text()='4 GB']")).click();		
	}
//	public void scrollDown() throws InterruptedException {
//		re.scrolldown(0, 300);
//	}
}
