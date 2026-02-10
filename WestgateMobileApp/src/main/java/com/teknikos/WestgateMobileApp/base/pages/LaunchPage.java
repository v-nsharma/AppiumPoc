package com.teknikos.WestgateMobileApp.base.pages;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.teknikos.WestgateMobileApp.utils.ElementUtils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchPage extends ElementUtils {

    private static final Logger logger = LogManager.getLogger(LaunchPage.class);

    public LaunchPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // -------- LOCATORS --------

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue as a Guest']")
    private WebElement txtContinueAsGuest;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login or Sign Up']")
    private WebElement btnLoginOrSignUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vacation More. Get More.']")
    private WebElement txtVacationMore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement txtHome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private WebElement txtMyAccount;

    // -------- VALIDATIONS / ACTIONS --------

    // Validate launch screen elements
    public void verifyAppLaunchedSuccessfully() {
        logger.info("Verifying launch screen elements");
        assertTrue(isElementPresent(txtVacationMore, 10), "Launch title not visible");
        assertTrue(isElementPresent(txtContinueAsGuest, 10), "Continue as Guest not visible");
        assertTrue(isElementPresent(btnLoginOrSignUp, 10), "Login or Sign Up button not visible");
    }

    // Tap Continue as Guest
    public void tapContinueAsGuest() {
        logger.info("Tapping Continue as Guest");
        assertTrue(isElementPresent(txtContinueAsGuest, 10), "Continue as Guest not visible");
        txtContinueAsGuest.click();
    }

    // Validate Home tab
    public void verifyHomeTabVisible() {
        logger.info("Verifying Home tab");
        assertTrue(isElementPresent(txtHome, 10), "Home tab not visible");
    }

    // Validate My Account tab
    public void verifyMyAccountTabVisible() {
        logger.info("Verifying My Account tab");
        assertTrue(isElementPresent(txtMyAccount, 10), "My Account tab not visible");
    }
}
