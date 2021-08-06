import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Case2 {
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
        WebElement leftMenu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']"));
        leftMenu.click();
        WebElement babyCare = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Baby Care']"));
        babyCare.click();
        WebElement valueOne = driver.findElement(By.xpath("(//android.widget.TextView[contains(@text,'$')])[3]"));
        String value1 = valueOne.getAttribute("text");
        WebElement sampleItemThree = driver.findElement(By.xpath("(//android.widget.TextView[@text='Sample Item detail'])[3]"));
        sampleItemThree.click();
        WebElement valueTwo = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'$')]"));
        String value2 = valueTwo.getAttribute("text");
        if(value1.equals(value2)){
            System.out.println("Ürünün fiyatı doğru.");
        }
        else System.out.println("Ürünün fiyatı doğru değil.");
        driver.quit();
        //• User goes back to category detail page
        //• User controls page existence ---- Bu adımlar uygulamada geri tuşu veya anasayfaya dönüş olmadığı için gerçekleştireledi.
    }
}



