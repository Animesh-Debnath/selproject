package amazonTests;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driver.DriverFactory;
import driver.DriverManager;
import pages.AmazonHomePage;
import utilities.WindowUtil;

public class HomePageTests {

    private static final Logger log = LoggerFactory.getLogger(HomePageTests.class);
    @Test(description = "This test verifies that the Amazon homepage loads successfully.")
    public void testAmazonHomePage() throws InterruptedException {
        // Test implementation goes here
        AmazonHomePage homePage = new AmazonHomePage().init();
        WindowUtil.getWebpage(DriverManager.getDriver(), "https://www.amazon.in");
        SoftAssert softAssert = new SoftAssert();
        WebElement logo = homePage.getAmazonLogo();
        softAssert.assertNotNull(logo, "Amazon logo should be present on the homepage.");
        log.info("Amazon homepage loaded successfully");
        softAssert.assertAll();
    }

    @AfterTest(alwaysRun=true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }

    @BeforeTest(alwaysRun=true)
    @Parameters("browser")
    public void printParameters(String browser) {
       log.info("Initiating driver for browser: " + browser);
       DriverFactory.initDriver(browser); 
    }  
}
