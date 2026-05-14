package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class WindowUtil {

    private WindowUtil(){} // Creating singleton

    private static final Map<String, String> windowHandles = new HashMap<>();

    public static void createNewWindow(WebDriver driver){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public static void getWebpage(WebDriver driver, String url){
        driver.get(url);
        String windowHandle = driver.getWindowHandle();
        windowHandles.put(url, windowHandle);
    }

    public static Map<String, String> getWindowHandles(){
        return windowHandles;
    }

    public static void switchToWindow(WebDriver driver, String url){
        String windowHandle = windowHandles.get(url);
        if(windowHandle != null){
            driver.switchTo().window(windowHandle);
        } else {
            throw new IllegalArgumentException("No window found for URL: " + url);
        }
    }

}
