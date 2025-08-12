package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableFunctions;

public class FlipkartResultPage {
	private WebDriver driver;
	ReusableFunctions re;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")
	WebElement firstSearch;
	
	public FlipkartResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickResult() {
		re = new ReusableFunctions(driver);
		re.waitforClickable(firstSearch);
		firstSearch.click();
	}
	
	public void productDetails(String details, WebElement element) {
		System.out.println(details+" : "+element.getText());
	}
}
