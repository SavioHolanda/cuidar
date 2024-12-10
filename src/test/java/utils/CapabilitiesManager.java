package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class CapabilitiesManager {
    private static final String PLATFORM = System.getProperty("platform", "Android");

    public AppiumDriver<RemoteWebElement> getDriver() throws MalformedURLException {
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

    private AppiumDriver<RemoteWebElement> getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\RepositórioNHG\\apps\\homolog-container\\2.build_61\\cuidar_homolog.apk");
        //capabilities.setCapability("deviceName", "ZF5245R8X4"); // Device Fisico
        capabilities.setCapability("deviceName", "emulator-5554"); // Device emulador
        capabilities.setCapability("platformName", "Android");

        return new AndroidDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    private AppiumDriver<RemoteWebElement> getIOSDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\RepositórioNHG\\apps\\homolog-container\\2.build_61\\cuidar_homolog_new_sdk.apk");
        capabilities.setCapability("deviceName", "ZF5245R8X4");
        capabilities.setCapability("platformName", "iOS");

        return new IOSDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    private AppiumDriver<RemoteWebElement> getFarmAndroid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "svioholanda_3Z914P");
        capabilities.setCapability("browserstack.key", "N2LmsoWZaNZCagYiPnue");
        capabilities.setCapability("app", "bs://824f7cac084e4162b083d05a566ef5b997629131");
        capabilities.setCapability("device", "Google Pixel 3");
        capabilities.setCapability("os_version", "9.0");

        return new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }

    private AppiumDriver<RemoteWebElement> getFarmIOS() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", "svioholanda_3Z914P");
        capabilities.setCapability("browserstack.key", "N2LmsoWZaNZCagYiPnue");
        capabilities.setCapability("app", "bs://824f7cac084e4162b083d05a566ef5b997629131");
        capabilities.setCapability("device", "iPhone 11");
        capabilities.setCapability("os_version", "14");

        return new AndroidDriver<RemoteWebElement>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
    }
}