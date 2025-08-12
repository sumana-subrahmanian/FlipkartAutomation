package testCases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseClass.LibraryClass;
import pages.FlipkartSearchpage;
import utilities.ReusableFunctions;


public class FlipkartSearchtest extends  LibraryClass{

	ReusableFunctions re;

    FlipkartSearchpage search;
 
    // Constructor

    public FlipkartSearchtest() {

        // Do NOT initialize driver here, because it's null before @BeforeTest

        // Initialization should happen after browser is launched

    }
 
    @BeforeClass

    public void initialize() {

        re = new ReusableFunctions(driver);

        search = new FlipkartSearchpage(driver);

    }
 
    @Test

    public void searchmobile() {

        search.search("Mobiles");

        search.clicksearch(); // Remove null parameter if not required

    }
 
    @AfterClass

    public void last() throws IOException {
		System.out.println("search class");

        re.takescreenshot("src/test/resources/screenshot/flipkartsearch.png");

        re.getTitle();


    }
 
}
