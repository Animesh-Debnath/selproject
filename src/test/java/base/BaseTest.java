package base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import driver.DriverFactory;
import driver.DriverManager;
import googleTests.GoogleTest;
import utilities.AllureUtils;


public class BaseTest {
    protected static final Logger log = LoggerFactory.getLogger(GoogleTest.class);
    @BeforeTest(alwaysRun=true)
    @Parameters("browser")
    public void printParameters(String browser) {
       log.info("Initiating driver for browser: " + browser);
       DriverFactory.initDriver(browser); 
    }  

    @AfterMethod(alwaysRun=true)
    public void attachFailureScreenshot(ITestResult result){
        if(result.isSuccess()) return;
        else{
            AllureUtils.attachScreenshot("Failure Screenshot", DriverManager.getDriver());
        }
    }
}
