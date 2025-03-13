package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesManager {
    private static final String PLATFORM = System.getProperty("platform", "Android");

    public AppiumDriver getDriver() throws MalformedURLException {
        switch (PLATFORM.toLowerCase()) {
            case "android":
                return getAndroidDriver();
            case "ios":
                return getIOSDriver();
            case "farm_android":
                return getFarmAndroid();
            case "farm_ios":
                return getFarmIOS();
            default:
                return null;
        }
    }

    private AppiumDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel_9_Pro_API_35"); // Device emulador
        capabilities.setCapability("app", "/Users/savioholanda/Documents/apps/cuidar/cuidar.apk");
        capabilities.setCapability("automationName", "UiAutomator2");

        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    private AppiumDriver getIOSDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\RepositórioNHG\\apps\\homolog-container\\2.build_61\\cuidar_homolog_new_sdk.apk");
        capabilities.setCapability("deviceName", "ZF5245R8X4");
        capabilities.setCapability("platformName", "iOS");

        return new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    private AppiumDriver getFarmAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "svioholanda_3Z914P");
        capabilities.setCapability("browserstack.key", "N2LmsoWZaNZCagYiPnue");
        capabilities.setCapability("app", "bs://824f7cac084e4162b083d05a566ef5b997629131");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");

        return new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }

    private AppiumDriver getFarmIOS() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "svioholanda_3Z914P");
        capabilities.setCapability("browserstack.key", "N2LmsoWZaNZCagYiPnue");
        capabilities.setCapability("app", "bs://824f7cac084e4162b083d05a566ef5b997629131");
        capabilities.setCapability("device", "iPhone 11");
        capabilities.setCapability("os_version", "14");

        return new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }
}