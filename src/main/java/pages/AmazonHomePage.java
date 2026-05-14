package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonHomePage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//span[@class='hm-icon-label']")
    private WebElement allLabel;

    @FindBy(id = "nav-logo-sprites")
    private WebElement amazonLogo;

    public WebElement getAmazonLogo() {
        return wait.until(ignored -> amazonLogo.isDisplayed() ? amazonLogo : null);
    }

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String getAllLabel(){
        String alltext = wait.until(ignored -> allLabel.isDisplayed() ? allLabel.getText() : null);
        return alltext;
    }


    @SuppressWarnings("null")
    WebDriverWait wait = new WebDriverWait(driver.DriverManager.getDriver(), java.time.Duration.ofSeconds(10));

}
