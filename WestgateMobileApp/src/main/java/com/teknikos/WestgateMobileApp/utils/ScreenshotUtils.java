package com.teknikos.WestgateMobileApp.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.teknikos.WestgateMobileApp.core.DriverManager;

import io.appium.java_client.android.AndroidDriver;

public class ScreenshotUtils {

    /**
     * Captures screenshot using DriverManager
     *
     * @param testName Test method name
     * @return screenshot file path
     */
    public static String captureScreenshot(String testName) {

        AndroidDriver driver = DriverManager.getDriver();

        if (driver == null) {
            System.err.println("❌ Screenshot capture failed: Driver is NULL");
            return null;
        }

        try {
            String screenshotsDir = Paths.get(
                    System.getProperty("user.dir"),
                    "reports",
                    "screenshots"
            ).toString();

            File dir = new File(screenshotsDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File srcFile = driver.getScreenshotAs(OutputType.FILE);
            String screenshotPath = Paths.get(
                    screenshotsDir,
                    testName + "_" + System.currentTimeMillis() + ".png"
            ).toString();

            FileUtils.copyFile(srcFile, new File(screenshotPath));

            return screenshotPath;

        } catch (IOException e) {
            System.err.println("❌ Screenshot IO error: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("❌ Screenshot unexpected error: " + e.getMessage());
            return null;
        }
    }
}
