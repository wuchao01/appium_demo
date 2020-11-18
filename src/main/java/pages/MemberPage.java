package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberPage extends BasePage{

    public MemberPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public MemberPage addMember(String name, String mobile){
        click((MobileBy) MobileBy.linkText("添加成员"));
        click((MobileBy) MobileBy.linkText("手动输入添加"));
        sendKeys((MobileBy) MobileBy.id("com.tencent.wework:id/b4t"),"小吴");
        click((MobileBy) MobileBy.linkText("设置部门"));
        click((MobileBy) MobileBy.id("com.tencent.wework:id/gsi"));
        click((MobileBy) MobileBy.id("com.tencent.wework:id/gsh"));
        click((MobileBy) MobileBy.linkText("保存"));
        balk((MobileBy) MobileBy.id("com.tencent.wework:id/i63"));
        return this;
//        driver.findElement(MobileBy.linkText("添加成员"));
    }

    public String getContactInfo(){
        return driver.findElement(MobileBy.linkText("企业通讯录")).getText();
    }

}
