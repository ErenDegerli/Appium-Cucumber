package com.getir.driver;

import com.getir.core.PropKey;
import com.getir.core.PropertyReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;

public class Driver {

    public static AndroidDriver<MobileElement> setDriver() throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Pixel 3 XL API 30");
        cap.setCapability("udid", PropertyReader.getInstance().getProperty(PropKey.EMULATOR.getPropVal()));
        cap.setCapability("platformName", PropertyReader.getInstance().getProperty(PropKey.PLATFORM.getPropVal()));
        cap.setCapability("platformVersion", PropertyReader.getInstance().getProperty(PropKey.PLATFORM_VERSION.getPropVal()));
        cap.setCapability("autoGrantPermissions", "true");
        cap.setCapability("appPackage", "com.getir.casestudy.dev");
        cap.setCapability("appActivity", "com.getir.casestudy.modules.splash.ui.SplashActivity");

        return new AndroidDriver<MobileElement>(new URL(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal())), cap);
    }
}
