package pages;

import org.openqa.selenium.support.PageFactory;

import driver.DriverManager;

public class BasePage {

    @SuppressWarnings("unchecked")
      public <T extends BasePage> T init(){
        PageFactory.initElements(DriverManager.getDriver(), this);
        return (T) this;
      }


}
