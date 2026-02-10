package com.teknikos.WestgateMobileApp.utils;
 
import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
 
public class Listeners implements ITestListener {
 
    @Override

    public void onStart(ITestContext context) {

        ExtentReportManager.setupReport();

    }
 
    @Override

    public void onFinish(ITestContext context) {

        ExtentReportManager.flushReport();   

    }
 
    @Override

    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        String description =

                result.getMethod().getDescription() != null

                        ? result.getMethod().getDescription()

                        : "";
 
        ExtentReportManager.startTest(testName, description);

        ExtentReportManager.logInfo("Test started: " + testName);

    }
 
    @Override

    public void onTestSuccess(ITestResult result) {

        ExtentReportManager.logPass(

                "Test passed: " + result.getMethod().getMethodName()

        );

        ExtentReportManager.clearTest();

    }
 
    @Override

    public void onTestFailure(ITestResult result) {

        String testName = result.getMethod().getMethodName();
 
        if (result.getThrowable() != null) {

            ExtentReportManager.logFail(

                    "Test failed: " + testName,

                    result.getThrowable()

            );

        } else {

            ExtentReportManager.logFail("Test failed: " + testName);

        }
 
        // 🔥 Screenshot on failure (if utility exists)

        try {

            String screenshotPath =

                    ScreenshotUtils.captureScreenshot(testName);

            ExtentReportManager.logScreenshot(

                    "Failure Screenshot",

                    screenshotPath

            );

        } catch (Exception e) {

            ExtentReportManager.logInfo("Screenshot capture failed");

        }
 
        ExtentReportManager.clearTest();

    }
 
    @Override

    public void onTestSkipped(ITestResult result) {

        ExtentReportManager.logInfo(

                "Test skipped: " + result.getMethod().getMethodName()

        );

        ExtentReportManager.clearTest();

    }
 
    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        // Not used

    }

}

 