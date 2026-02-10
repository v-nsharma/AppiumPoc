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

public class LoginPage extends ElementUtils {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ---------------- LOCATORS ----------------

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Login or Sign Up']")
    private WebElement btnLoginOrSignUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue as a Guest']")
    private WebElement txtContinueAsGuest;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vacation More. Get More.']")
    private WebElement txtVacationMore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement txtHome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private WebElement txtMyAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Now']")
    private WebElement txtLoginNow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Gain access to a']")
    private WebElement txtGainAccess;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='customized experience.']")
    private WebElement txtCustomizedExperience;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement txtLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Book Now']")
    private WebElement txtBookNow;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Accept All Cookies']")
    private WebElement btnAcceptAllCookies;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Reject All']")
    private WebElement btnRejectAllCookies;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='user']")
    private WebElement txtUsername;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private WebElement txtPassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOGIN']")
    private WebElement btnLogin;

    // ---------------- ACTION METHODS ----------------

    public void continueAsGuest() {
        logger.info("Tapping Continue as Guest");
        assertTrue(isElementPresent(txtContinueAsGuest, 10));
        txtContinueAsGuest.click();;
    }

    public void scrollToLoginSection() {
        logger.info("Scrolling to Login section");
        scrollUntilElementVisible(txtLogin,3);
        assertTrue(isElementPresent(txtLogin, 10));
    }

    public void tapLoginText() throws InterruptedException {
        logger.info("Tapping Login text");
        assertTrue(isElementPresent(txtLogin, 10));
        txtLogin.click();
        Thread.sleep(20000);

    }

    public void acceptCookiesIfDisplayed() {
        logger.info("Checking for cookie popup");
        if (isElementPresent(btnAcceptAllCookies, 5)) {
            btnAcceptAllCookies.click();
            logger.info("Accepted all cookies");
        } else {
            logger.info("Cookie popup not displayed");
        }
    }

    public void enterLoginCredentials(String username, String password) {
        logger.info("Entering login credentials");
        assertTrue(isElementPresent(txtUsername, 10));
        txtUsername.sendKeys(username);

        assertTrue(isElementPresent(txtPassword, 10));
        txtPassword.sendKeys(password);
    }

    public void tapLoginButton() {
        logger.info("Tapping LOGIN button");
        assertTrue(isElementPresent(btnLogin, 10));
        btnLogin.click();
    }

    // ---------------- COMPLETE LOGIN FLOW ----------------

    public void loginAsRegisteredUser(String username, String password) throws InterruptedException {
       // continueAsGuest();
        scrollToLoginSection();
        tapLoginText();
        acceptCookiesIfDisplayed();
        enterLoginCredentials(username, password);
        tapLoginButton();
        logger.info("Login flow completed");
        Thread.sleep(10000);
    }

   
}
