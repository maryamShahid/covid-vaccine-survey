import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class test {

    private static final String APP_PACKAGE = "com.example.covid19vaccinesurvey";
    private static final String APP_ACTIVITY = ".MainActivity";
    private static final String  APPIUM_PORT = "4723";      // this may vary in your PC



    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); // emulator-5554 may vary in your PC
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", APP_PACKAGE);
        dc.setCapability("appActivity", APP_ACTIVITY);


        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub"), dc);

        MobileElement el2 = driver.findElementById("com.example.covid19vaccinesurvey:id/name_surname");
        el2.click();
        el2.sendKeys("Murat Sevinç");

    }
}
