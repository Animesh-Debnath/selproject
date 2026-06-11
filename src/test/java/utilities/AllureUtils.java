package utilities;
import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Allure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllureUtils {
    private AllureUtils(){}
    protected static final Logger log = LoggerFactory.getLogger(AllureUtils.class); 

    public static void step(String message){
        Allure.step(message);
    }

    public static void attachText(String title, String message){
        Allure.addAttachment(title, message);       
    }

    public static void attachScreenshot(String desc, WebDriver driver){
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        log.info("Byte size is: " + bytes.length);
        Allure.getLifecycle().addAttachment(desc, "image/png", "png", new ByteArrayInputStream(bytes));
    }
}
