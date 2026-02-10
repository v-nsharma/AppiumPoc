package com.teknikos.WestgateMobileApp.base.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.teknikos.WestgateMobileApp.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyStayPage extends ElementUtils {

    private static final Logger logger = LogManager.getLogger(MyStayPage.class);

    public MyStayPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ---------------- LOCATORS ----------------

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Book Now']")
    private WebElement txtBookNow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Stay']")
    private WebElement txtMyStay;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Current']")
    private WebElement btnCurrent;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Past Stays']")
    private WebElement btnPastStays;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='ADD A STAY']")
    private WebElement btnAddAStay;

    // ---------------- ACTION / VALIDATION ----------------

    public void verifyMyStaySection() {
        logger.info("Verifying My Stay section");

        assertTrue(isElementPresent(txtMyStay, 10),
                "My Stay not visible");
    }

    public void tapMyStay() {
        logger.info("Tapping My Stay");
        assertTrue(isElementPresent(txtMyStay, 10));
        txtMyStay.click();
    }

    public void verifyMyStayOptions() {
        logger.info("Verifying My Stay options");

        assertTrue(isElementPresent(btnCurrent, 10),
                "Current button not visible");

        assertTrue(isElementPresent(btnPastStays, 10),
                "Past Stays button not visible");

        assertTrue(isElementPresent(btnAddAStay, 10),
                "Add A Stay button not visible");
    }
}

