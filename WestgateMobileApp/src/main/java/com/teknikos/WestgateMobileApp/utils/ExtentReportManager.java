package com.teknikos.WestgateMobileApp.utils;
 
import java.io.File;
import java.nio.file.Paths;
 
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class ExtentReportManager {
 
    private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
 
    // ---------------- INIT ----------------
    public static synchronized void setupReport() {
        if (extent != null) return;
 
        String reportDir = Paths.get(System.getProperty("user.dir"), "reports").toString();
        new File(reportDir).mkdirs();
 
        ExtentSparkReporter spark =
                new ExtentSparkReporter(Paths.get(reportDir, "ExtentReport.html").toString());
 
        spark.config().setDocumentTitle("Westgate Mobile Automation Report");
        spark.config().setReportName("Execution Summary");
        spark.config().setTheme(Theme.STANDARD);
 
        extent = new ExtentReports();
        extent.attachReporter(spark);
 
        extent.setSystemInfo("Project", "Westgate Mobile App");
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java", System.getProperty("java.version"));
    }
 
    // ---------------- TEST ----------------
    public static void startTest(String name, String description) {
        ExtentTest extentTest = extent.createTest(name, description);
        test.set(extentTest);
    }
 
    public static ExtentTest getTest() {
        return test.get();
    }
 
    // ---------------- LOGGING ----------------
    public static void logInfo(String msg) {
        if (getTest() != null) getTest().info(msg);
    }
 
    public static void logPass(String msg) {
        if (getTest() != null) getTest().pass(msg);
    }
 
    public static void logFail(String msg) {
        if (getTest() != null) getTest().fail(msg);
    }
 
    public static void logFail(String msg, Throwable t) {
        if (getTest() != null) getTest().fail(msg).fail(t);
    }
 
    // ---------------- SCREENSHOT ----------------
    public static void logScreenshot(String message, String path) {
        try {
            if (getTest() != null) {
                getTest().info(
                        message,
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build()
                );
            }
        } catch (Exception e) {
            getTest().warning("Screenshot attach failed");
        }
    }
 
    // ---------------- FLUSH ----------------
    public static synchronized void flushReport() {
        if (extent != null) extent.flush();
    }
 
    public static void clearTest() {
        test.remove();
    }
}