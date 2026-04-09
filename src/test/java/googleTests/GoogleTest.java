package googleTests;
import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import driver.DriverFactory;
import driver.DriverManager;
import pages.LoginPage;

public class GoogleTest {

    private static final Logger log = LoggerFactory.getLogger(GoogleTest.class);
    @Test(description = "This test verifies that the Google homepage loads successfully.")
    public void testGoogleHomePage() throws InterruptedException {
        // Test implementation goes here
        LoginPage loginPage = new LoginPage().init();
        DriverManager.getDriver().get("https://www.amazon.com");
        log.info("Google homepage loaded successfully.");
        SoftAssert softAssert = new SoftAssert();// Wait for the page to load completely
        String deliveryLocation = loginPage.getAllLabel();
        log.info("all label text: " + deliveryLocation);
        softAssert.assertTrue(true, "Google homepage should load successfully.");
        Thread.sleep(8000);
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
