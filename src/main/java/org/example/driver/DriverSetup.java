package org.example.driver;

import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.example.AndroidDevice;
import org.example.config.AppConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    AppConfig config = ConfigFactory.create(AppConfig.class);
    private AndroidDriver driver;

    public AndroidDriver init(AndroidDevice androidDevice) throws MalformedURLException {
        driver = new AndroidDriver(new URL(androidDevice.getURL()),
                addCapabilities(androidDevice.getDeviceName(), androidDevice.getAndroidVersion()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }

    public AndroidDriver getDriverInstance() {
        return driver;
    }

    private DesiredCapabilities addCapabilities(String devicename, String androidVersion) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("appium:deviceName", devicename);
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:platformVersion", androidVersion);
        caps.setCapability("appium:app", config.pathToApk());
        caps.setCapability("appium:automationName", "UIAutomator2");
        caps.setCapability("appium:appActivity", "com.wdiodemoapp.MainActivity");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 8600);
        caps.setCapability("appium:connectHardwareKeyboard", true);
        caps.setCapability("–session-override", true);
        return caps;
    }
}
