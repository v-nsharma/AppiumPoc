package com.teknikos.WestgateMobileApp.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

/**
 * Central manager for AndroidDriver and AppiumDriverLocalService.
 */
public class DriverManager {

    private static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setDriver(AndroidDriver androidDriver) {
        driver = androidDriver;
    }

    public static AppiumDriverLocalService getService() {
        return service;
    }

    public static void setService(AppiumDriverLocalService localService) {
        service = localService;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("🛑 Driver quit.");
        }
    }

    public static void stopService() {
        if (service != null && service.isRunning()) {
            service.stop();
            service = null;
            System.out.println("🛑 Appium service stopped.");
        }
    }
}

