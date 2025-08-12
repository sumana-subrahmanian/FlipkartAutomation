package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ReusableFunctions;

public class FlipkartSearchpage {


	private WebDriver driver;

	ReusableFunctions re;

    @FindBy(xpath = "//input[@name='q' and @type='text']")

    WebElement searchBox;
 
    @FindBy(xpath = "//button[@type='submit']")

    WebElement searchbutton;
 
    @FindBy(css = "button._2KpZ6l._2doB4z")

    WebElement closeLoginPopup;
 
    public FlipkartSearchpage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
 
    public void closePopupIfPresent() {

        try {

            if (closeLoginPopup.isDisplayed()) {

                closeLoginPopup.click();

            }

        } catch (NoSuchElementException ignored) {

        }

    }
 
    public void search(String text) {

        closePopupIfPresent();
        searchBox.sendKeys(Keys.CONTROL + "a");
        searchBox.sendKeys(Keys.DELETE);
        try {
        	Thread.sleep(2000);
        }
        catch (Exception e) {
			System.out.println(e);
		}
        searchBox.sendKeys(text);

    }
 
    public void clicksearch() {

        try {

        	re = new ReusableFunctions(driver);

        	re.waitforClickable(searchbutton);

            searchbutton.click();

        } catch (NoSuchElementException e) {

            System.out.println("Search button not found.");

        } catch (ElementNotInteractableException e) {

            System.out.println("Search button found but not interactable.");

        }

    }

 

}
