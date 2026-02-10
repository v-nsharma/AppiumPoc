package com.teknikos.WestgateMobileApp.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.teknikos.WestgateMobileApp.config.ConfigReader;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    // -------------------- EXTENT SETUP --------------------
    /*@BeforeSuite(alwaysRun = true)
    public void setupExtentReport() {
        ExtentReportManager.setupReport();
    }*/
    
    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.setupReport();
    }

    // -------------------- APPIUM SETUP --------------------
    @BeforeClass(alwaysRun = true)
    public void configureAppium() throws MalformedURLException {

        System.out.println("Initializing Appium driver...");

        String appiumServerUrl = ConfigReader.get("appiumServerUrl");
        String platformName = ConfigReader.get("platformName");
        String deviceName = ConfigReader.get("deviceName");
        String appPath = ConfigReader.get("appPath");

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(platformName)
                .setAutomationName("UiAutomator2")
                .setDeviceName(deviceName)
                .setApp(appPath)
                .setAutoGrantPermissions(true);

        AndroidDriver driver =
                new AndroidDriver(new URL(appiumServerUrl), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.setDriver(driver);

        System.out.println("App launched successfully.");
    }

    // -------------------- DRIVER TEARDOWN --------------------
    @AfterClass(alwaysRun = true)
    public void tearDownDriver() {
        DriverManager.quitDriver();
    }

    
    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReport();
    }
    // -------------------- EXTENT FLUSH --------------------
    /*@AfterSuite(alwaysRun = true)
    public void tearDownExtentReport() {
        ExtentReportManager.tearDownReport();
    }*/
}
