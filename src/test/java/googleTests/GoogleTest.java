package googleTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import driver.DriverFactory;
import driver.DriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import listeners.AllureListener;
import pages.AmazonHomePage;

@Listeners({AllureListener.class})
public class GoogleTest extends BaseTest{

    
    @Test(description = "This test verifies that the Google homepage loads successfully.")
    @Step("get All Label")
    @Severity(SeverityLevel.CRITICAL)
    public void testGoogleHomePage() throws InterruptedException {
        // Test implementation goes here
        AmazonHomePage loginPage = new AmazonHomePage().init();
        DriverManager.getDriver().get("https://www.amazon.com");
        log.info("Google homepage loaded successfully.");
        SoftAssert softAssert = new SoftAssert();// Wait for the page to load completely
        String deliveryLocation = loginPage.getAllLabel();
        log.info("all label text: " + deliveryLocation);
        softAssert.assertTrue(false, "Google homepage should load successfully.");
        Thread.sleep(8000);
        softAssert.assertAll();
    }

    @AfterTest(alwaysRun=true)
    public void tearDown(){
        DriverFactory.quitDriver();
    }
}
