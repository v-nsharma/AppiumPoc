package com.teknikos.WestgateMobileApp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.base.pages.LaunchPage;
import com.teknikos.WestgateMobileApp.base.pages.LoginPage;
import com.teknikos.WestgateMobileApp.base.pages.MyStayPage;
import com.teknikos.WestgateMobileApp.base.pages.MyAccountPage;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

public class WestgateRegressionTest extends BaseTest {

    private LaunchPage launchPage;
    private LoginPage loginPage;
    private MyStayPage myStayPage;
    private MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp() {
        ExtentReportManager.setupReport();

        launchPage    = new LaunchPage(DriverManager.getDriver());
        loginPage     = new LoginPage(DriverManager.getDriver());
        myStayPage    = new MyStayPage(DriverManager.getDriver());
        myAccountPage = new MyAccountPage(DriverManager.getDriver());
    }

    @Test(priority = 1)
    public void verifyAppLaunch() {
        ExtentReportManager.startTest(
                "Verify App Launch",
                "Verify application launches successfully"
        );
        launchPage.verifyAppLaunchedSuccessfully();
    }

    @Test(priority = 2)
    public void verifyLoginFunctionality() throws Exception {
        ExtentReportManager.startTest(
                "Verify Login Functionality",
                "Verify user can login with valid credentials"
        );

        launchPage.tapContinueAsGuest();
        loginPage.loginAsRegisteredUser(
                "Test101@gmail.com",
                "password"
        );
    }

    @Test(priority = 3)
    public void verifyMyStaySection() {
        ExtentReportManager.startTest(
                "Verify My Stay Section",
                "Verify My Stay options are displayed"
        );

        myStayPage.verifyMyStaySection();
        myStayPage.tapMyStay();
        myStayPage.verifyMyStayOptions();
    }

    @Test(priority = 4)
    public void verifyMyAccountSection() {
        ExtentReportManager.startTest(
                "Verify My Account Section",
                "Verify account options and online account manager"
        );

        myAccountPage.verifyAccountSection();
        myAccountPage.tapMyAccount();
        myAccountPage.verifyAccountOptions();
        myAccountPage.scrollToOnlineAccountManager();
    }

   
}
