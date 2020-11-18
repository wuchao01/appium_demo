package pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class MainPage extends BasePage{

    public MainPage() throws MalformedURLException {
        this.setUp();
    }

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","mumu");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appPackage","com.tencent.wework");
        capabilities.setCapability("appActivity",".launch.LaunchSplashActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("com.tencent.wework:id/anx")));
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDown(){
        driver.quit();
    }

    public MemberPage member() {
        click((MobileBy) MobileBy.id("com.tencent.wework:id/egd"));
        return new MemberPage(driver,wait);
    }

}
