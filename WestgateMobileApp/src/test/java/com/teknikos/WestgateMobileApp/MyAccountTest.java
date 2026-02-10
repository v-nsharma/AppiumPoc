package com.teknikos.WestgateMobileApp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.base.pages.LaunchPage;
import com.teknikos.WestgateMobileApp.base.pages.LoginPage;
import com.teknikos.WestgateMobileApp.base.pages.MyAccountPage;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

public class MyAccountTest extends BaseTest {

    private LaunchPage launchPage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    @BeforeClass
    public void setUp() {
        ExtentReportManager.setupReport();

        launchPage     = new LaunchPage(DriverManager.getDriver());
        loginPage      = new LoginPage(DriverManager.getDriver());
        myAccountPage  = new MyAccountPage(DriverManager.getDriver());
    }

    @Test
    public void verifyMyAccountSection() throws Exception {
        ExtentReportManager.startTest(
                "Verify My Account Section",
                "Verify account options and online account manager"
        );

        launchPage.tapContinueAsGuest();
        loginPage.loginAsRegisteredUser(
                "Test101@gmail.com",
                "password"
        );

        myAccountPage.verifyAccountSection();
        myAccountPage.tapMyAccount();
        myAccountPage.verifyAccountOptions();
        myAccountPage.scrollToOnlineAccountManager();
    }

   
    }

