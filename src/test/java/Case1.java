import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Case1 {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.allandroidprojects.getirsample");
        caps.setCapability("appActivity", "com.allandroidprojects.getirsample.startup.SplashActivity");
        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        Thread.sleep(Long.parseLong("10000"));
        for (int i=0;i<4;i++){
        WebElement nextButton = driver.findElement(By.id("com.allandroidprojects.getirsample:id/btn_next"));
        nextButton.click();
        Thread.sleep(Long.parseLong("1000"));}
        WebElement getirSample = driver.findElement(By.xpath("//android.widget.TextView[@text='GetirSample']"));
        WebElement water = driver.findElement(By.xpath("//android.widget.TextView[@text='WATER']"));
        water.click();
        WebElement itemOne = driver.findElement(By.xpath("(//android.widget.TextView[@text='Sample Item detail'])[1]"));
        itemOne.click();
        WebElement sampleItemOne = driver.findElement(By.xpath("//*[@text='Sample Item']"));
        String firstItem = sampleItemOne.getAttribute("text");
        WebElement value = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'$')]"));
        String value1 = value.getAttribute("text");
        WebElement buyNow = driver.findElement(By.id("com.allandroidprojects.getirsample:id/text_action_bottom2"));
        buyNow.click();
        WebElement sampleItemTwo = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample Item']"));
        WebElement valueTwo = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.allandroidprojects.getirsample:id/layout_item_desc\"]//parent::*/*[contains(@text,'$')]"));
        String secondItem = sampleItemTwo.getAttribute("text");
        String value2 = valueTwo.getAttribute("text");
        if(firstItem.equals(secondItem) && value1.equals(value2)){
            System.out.println("Ürün isimleri ve fiyatı doğru.");
        }
        else System.out.println("Ürün isimleri ve fiyatı yanlış.");
        WebElement remove = driver.findElement(By.xpath("//android.widget.TextView[@text='Remove']"));
        remove.click();
        driver.quit();
    }
}



