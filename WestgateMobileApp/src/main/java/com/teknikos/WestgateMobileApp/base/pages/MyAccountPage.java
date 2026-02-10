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

public class MyAccountPage extends ElementUtils {

    private static final Logger logger = LogManager.getLogger(MyAccountPage.class);

    public MyAccountPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // ---------------- LOCATORS ----------------

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Account']")
    private WebElement txtMyAccount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Book Now']")
    private WebElement txtBookNow;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add An Account Number']")
    private WebElement txtAddAccountNumber;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Payment Wallet']")
    private WebElement txtPaymentWallet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Go To Online Account Manager']")
    private WebElement txtOnlineAccountManager;

    // ---------------- ACTION / VALIDATION ----------------

    public void verifyAccountSection() {
        logger.info("Verifying Account section entry");

        assertTrue(isElementPresent(txtMyAccount, 10),
                "My Account not visible");
    }

    public void tapMyAccount() {
        logger.info("Tapping My Account");
        txtMyAccount.click();
    }

    public void verifyAccountOptions() {
        logger.info("Verifying Account options");

        assertTrue(isElementPresent(txtBookNow, 10),
                "Book Now not visible");

        assertTrue(isElementPresent(txtAddAccountNumber, 10),
                "Add An Account Number not visible");

        assertTrue(isElementPresent(txtPaymentWallet, 10),
                "Payment Wallet not visible");
    }

    public void scrollToOnlineAccountManager() {
        logger.info("Scrolling to Online Account Manager");

        scrollUntilElementVisible(txtOnlineAccountManager, 4);

        assertTrue(isElementPresent(txtOnlineAccountManager, 10),
                "Online Account Manager not visible");
    }
}
