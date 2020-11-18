package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public BasePage() {
    }


    public void click(MobileBy by){
        driver.findElement(by).click();
    }

    public void sendKeys(MobileBy by,String content){
        driver.findElement(by).sendKeys(content);
    }

    public void balk(MobileBy by){
        driver.findElement(by).click();
    }

}
