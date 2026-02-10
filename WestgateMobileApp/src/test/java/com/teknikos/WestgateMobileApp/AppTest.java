package com.teknikos.WestgateMobileApp;


import org.testng.annotations.Test;
import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public class AppTest extends BaseTest {

    @Test
    public void verifyAppLaunch() {
        AndroidDriver driver = DriverManager.getDriver();

        // Simple validation to confirm app launch
        System.out.println("Current Package: " + driver.getCurrentPackage());

        // Optional assertion
        assert driver != null : "Driver is NULL, app not launched!";
    }
}
