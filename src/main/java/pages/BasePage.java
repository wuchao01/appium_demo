package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    AppiumDriver driver;
    WebDriverWait wait;
    AndroidDriver androidDriver;

    public BasePage(AppiumDriver driver,AndroidDriver androidDriver,WebDriverWait wait) {
        this.driver = driver;
        this.androidDriver = androidDriver;
        this.wait = wait;
    }

    public BasePage() {
    }


    public void click(By by){
        driver.findElement(by).click();
    }

    public void sendKeys(By by,String content){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(content);
    }

    public void back(By by){
        driver.findElement(by).click();
    }

}
