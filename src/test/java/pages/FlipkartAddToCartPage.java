package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableFunctions;

public class FlipkartAddToCartPage {
	private WebDriver driver;
	ReusableFunctions re;
	
//	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")
	
	@FindBy(xpath = "//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
	WebElement addCartButton;
	
	@FindBy(xpath="//span[text()='Cart']")
	WebElement cart;
	
	public FlipkartAddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddToCart() {
		addCartButton.click();
	}
	
	public void goToCart() {
		driver.navigate().back();
		try {
		Thread.sleep(2000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		cart.click();
		
	}
}
