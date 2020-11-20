package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class MemberPage extends BasePage{

    public MemberPage(AppiumDriver driver, WebDriverWait wait) {
        super(driver,wait);
    }

    public MemberPage addMember(String name, String mobile){
        click(By.xpath("//*[@text='添加成员']"));
        click(By.id("com.tencent.wework:id/cox"));
        sendKeys(By.id("com.tencent.wework:id/b4t"),name);
        sendKeys(By.id("com.tencent.wework:id/fow"),mobile);
        click(By.xpath("//*[@text='设置部门']"));
        //这里还没找到元素
        click(By.xpath("(//*[@resource-id='com.tencent.wework:id/gsi'])[2]"));
        click(By.id("com.tencent.wework:id/gsh"));
        click(By.id("com.tencent.wework:id/fco"));
        click(By.xpath("//*[@text='保存']"));
        //返回元素不知道为啥没找到
        driver.navigate().back();
//        back(By.id("com.tencent.wework:id/i63"));
        return this;
    }

    public MemberPage updateMember(String updateName,String updateMobile){
        //这里还没找到元素
        click(By.xpath("//*[@text='小天']"));
        click(By.id("com.tencent.wework:id/i6d"));
        click(By.xpath("//*[@text='编辑成员']"));
        sendKeys(By.xpath("//*[@text='小吴']"),updateName);
        sendKeys(By.xpath("//*[@text='XiaoWu']"),updateMobile);
        click(By.xpath("//*[@text='设置部门']"));
        click(By.id("com.tencent.wework:id/e3v"));
        click(By.id("com.tencent.wework:id/gsh"));
        click(By.xpath("//*[@text='保存']"));
        return this;
    }

    public MemberPage deleteMember(){
        //这里还没找到元素
        click(By.id("com.tencent.wework:id/i6d"));
        click(By.xpath("//*[@text='编辑成员']"));
        //这里应该在加一句下滑后删除
        click(By.xpath("//*[@text='删除成员']"));
        click(By.xpath("//*[@text='确定']"));
        return this;
//        driver.findElement(MobileBy.linkText("添加成员"));
    }

    public String getContactInfo(){
        return driver.findElement(By.xpath("//*[@text='企业通讯录']")).getText();
    }

}
