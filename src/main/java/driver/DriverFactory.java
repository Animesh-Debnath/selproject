package driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    public static void initDriver(String browser){
        try {
           if(DriverManager.getDriver() == null){
           String hubURL = "http://127.0.0.1:4444/wd/hub"; // URL of the Selenium Grid hub
           WebDriver driver; 
             if(browser.equalsIgnoreCase("chrome")){
               ChromeOptions options = new ChromeOptions();
               options.setScriptTimeout(Duration.of(5, ChronoUnit.SECONDS));
               options.setPageLoadTimeout(Duration.ofSeconds(5));
               options.addArguments("--no-sandbox");
               options.addArguments("--disable-dev-shm-usage");
               options.addArguments("--disable-gpu");
               options.addArguments("--window-size=1920,1080");
               options.addArguments("--remote-allow-origins=*");
               options.addArguments("--start-maximized");
               options.addArguments("--headless=new");
               options.addArguments("--disable-extensions");
               options.addArguments("--disable-popup-blocking");
               options.setScriptTimeout(Duration.of(60, ChronoUnit.SECONDS));
               options.setPageLoadTimeout(Duration.ofSeconds(60));
               driver = new RemoteWebDriver(new URL(hubURL), options);
               
           } else if (browser.equalsIgnoreCase("firefox")) {
               FirefoxOptions options = new FirefoxOptions();
               options.setScriptTimeout(Duration.of(60, ChronoUnit.SECONDS));
               options.setPageLoadTimeout(Duration.ofSeconds(60));
               driver = new RemoteWebDriver(new URL(hubURL), options);

           } else {
               throw new IllegalArgumentException("Unsupported browser: " + browser);
           }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            DriverManager.setDriver(driver);    
         }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
        }

    }

    public static void quitDriver(){
        if(DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }

}
