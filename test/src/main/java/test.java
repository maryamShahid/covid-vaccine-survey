import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class test {

    private static final String APP_PACKAGE = "com.example.covid19vaccinesurvey";
    private static final String APP_ACTIVITY = ".MainActivity";
    private static final String APPIUM_PORT = "4723";                   // this may vary in your PC
    private static final String EMULATOR_NAME = "emulator-5554";        // this may vary in your PC

    private static AndroidDriver<AndroidElement> driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        verifyingTheSendButtonIsActiveOnlyWhenAllInputsAreFilled(); // Test Case 1
        verifyingBirthDateIsEnteredViaCalender();                   // Test Case 2
        verifyingTheSendButtonIsInactiveWhenAnyInfoIsMissing();     // Test Case 3
        verifyingRelevantInformationAreasDoExist();                 // Test Case 4
        verifyingNameCityGenderCannotContainDigits();               // Test Case 5, fails
    }


    private static void verifyingTheSendButtonIsActiveOnlyWhenAllInputsAreFilled() throws InterruptedException, MalformedURLException {
        initializeAndroid();

        MobileElement nameInput = driver.findElementById("com.example.covid19vaccinesurvey:id/name_surname");
        MobileElement birthdateInput = driver.findElementById("com.example.covid19vaccinesurvey:id/tv_date");
        MobileElement birthPlaceInput = driver.findElementById("com.example.covid19vaccinesurvey:id/city");
        MobileElement genderInput = driver.findElementById("com.example.covid19vaccinesurvey:id/gender");
        MobileElement vaccineInput = driver.findElementById("com.example.covid19vaccinesurvey:id/vaccine_type");
        MobileElement sideEffectsInput = driver.findElementById("com.example.covid19vaccinesurvey:id/side_effects");
        MobileElement positivesAfter3rdInput = driver.findElementById("com.example.covid19vaccinesurvey:id/cases_and_symptoms");
        MobileElement sendButton = driver.findElementById("com.example.covid19vaccinesurvey:id/send");

        sideEffectsInput.sendKeys("Soreness in the area that the vaccine is shot");
        positivesAfter3rdInput.sendKeys("Positive PCR after 1 month from the 3rd vaccine shot ");
        vaccineInput.sendKeys("BionTech");
        genderInput.sendKeys("Male");
        birthPlaceInput.sendKeys("Ankara");
        nameInput.sendKeys("Murat Sevinç");
        birthdateInput.click();
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();

        sendButton = driver.findElementById("com.example.covid19vaccinesurvey:id/send");
        assertThat(sendButton.isEnabled())
                .isTrue();
    }

    private static void verifyingBirthDateIsEnteredViaCalender() throws MalformedURLException, InterruptedException {
        initializeAndroid();

        MobileElement birthdateInput = driver.findElementById("com.example.covid19vaccinesurvey:id/tv_date");

        birthdateInput.click();
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();

        birthdateInput = driver.findElementById("com.example.covid19vaccinesurvey:id/tv_date");
        assertThat(birthdateInput.getText())
                .containsPattern("[0-9]+/[0-9]+/[0-9][0-9][0-9][0-9]");
    }

    private static void verifyingNameCityGenderCannotContainDigits() throws MalformedURLException {
        initializeAndroid();
        MobileElement nameInput = driver.findElementById("com.example.covid19vaccinesurvey:id/name_surname");
        MobileElement genderInput = driver.findElementById("com.example.covid19vaccinesurvey:id/gender");
        MobileElement birthPlaceInput = driver.findElementById("com.example.covid19vaccinesurvey:id/city");

        nameInput.sendKeys("123");
        genderInput.sendKeys("123");
        birthPlaceInput.sendKeys("123");

        assertThat(nameInput.getText()).isEmpty();          // Note that test fails here, implementation weakness found.
        assertThat(genderInput.getText()).isEmpty();        // Note that test fails here, implementation weakness found.
        assertThat(birthPlaceInput.getText()).isEmpty();    // Note that test fails here, implementation weakness found.
    }

    private static void verifyingTheSendButtonIsInactiveWhenAnyInfoIsMissing() throws MalformedURLException, InterruptedException {
        initializeAndroid();

        MobileElement nameInput = driver.findElementById("com.example.covid19vaccinesurvey:id/name_surname");
        MobileElement birthdateInput = driver.findElementById("com.example.covid19vaccinesurvey:id/tv_date");
        MobileElement birthPlaceInput = driver.findElementById("com.example.covid19vaccinesurvey:id/city");
        MobileElement genderInput = driver.findElementById("com.example.covid19vaccinesurvey:id/gender");
        MobileElement vaccineInput = driver.findElementById("com.example.covid19vaccinesurvey:id/vaccine_type");
        MobileElement positivesAfter3rdInput = driver.findElementById("com.example.covid19vaccinesurvey:id/cases_and_symptoms");

        positivesAfter3rdInput.sendKeys("Positive PCR after 1 month from the 3rd vaccine shot ");
        vaccineInput.sendKeys("BionTech");
        genderInput.sendKeys("Male");
        birthPlaceInput.sendKeys("Ankara");
        nameInput.sendKeys("Murat Sevinç");
        birthdateInput.click();
        Thread.sleep(2000);
        driver.findElementById("android:id/button1").click();

        MobileElement sendButton = driver.findElementById("com.example.covid19vaccinesurvey:id/send");
        assertThat(sendButton.isEnabled())
                .isFalse();
    }

    private static void verifyingRelevantInformationAreasDoExist() throws MalformedURLException {
        initializeAndroid();

        MobileElement nameInput = driver.findElementById("com.example.covid19vaccinesurvey:id/name_surname");
        MobileElement birthdateInput = driver.findElementById("com.example.covid19vaccinesurvey:id/tv_date");
        MobileElement birthPlaceInput = driver.findElementById("com.example.covid19vaccinesurvey:id/city");
        MobileElement genderInput = driver.findElementById("com.example.covid19vaccinesurvey:id/gender");
        MobileElement vaccineInput = driver.findElementById("com.example.covid19vaccinesurvey:id/vaccine_type");
        MobileElement sideEffectsInput = driver.findElementById("com.example.covid19vaccinesurvey:id/side_effects");
        MobileElement positivesAfter3rdInput = driver.findElementById("com.example.covid19vaccinesurvey:id/cases_and_symptoms");

        assertThat(nameInput.isDisplayed()).isTrue();
        assertThat(birthdateInput.isDisplayed()).isTrue();
        assertThat(birthPlaceInput.isDisplayed()).isTrue();
        assertThat(genderInput.isDisplayed()).isTrue();
        assertThat(vaccineInput.isDisplayed()).isTrue();
        assertThat(sideEffectsInput.isDisplayed()).isTrue();
        assertThat(positivesAfter3rdInput.isDisplayed()).isTrue();
    }

    private static void initializeAndroid() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME, EMULATOR_NAME);
        dc.setCapability("platformName", "android");
        dc.setCapability("appPackage", APP_PACKAGE);
        dc.setCapability("appActivity", APP_ACTIVITY);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + APPIUM_PORT + "/wd/hub"), dc);
    }

}
