import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDemo {

    private static AppiumDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("deviceName","mumu");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testDemo(){
        //处理首页广告，通过显示等待信封图标绕过广告倒计时
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.xueqiu.android:id/action_message")));
        driver.findElementById("com.xueqiu.android:id/home_search").click();
        driver.findElementById("com.xueqiu.android:id/search_input_text").sendKeys("alibaba");
        driver.findElementByXPath("//*[@text='BABA']").click();
        System.out.println(driver.findElementById("com.xueqiu.android:id/current_price").getText());
    }
}
