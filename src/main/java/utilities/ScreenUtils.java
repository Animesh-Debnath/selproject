package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenUtils {
    private static final Logger log = LoggerFactory.getLogger(ScreenUtils.class);
    //capture screenshot method
    public static String captureScreenshot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver.DriverManager.getDriver();
            return screenshot.getScreenshotAs(OutputType.BASE64);
        } catch (Exception e) {
            log.error("Failed to capture screenshot: " + e.getMessage());
            return "";
        }

    }
}
