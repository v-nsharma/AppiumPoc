package com.teknikos.WestgateMobileApp;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.base.pages.LaunchPage;
import com.teknikos.WestgateMobileApp.base.pages.LoginPage;
import com.teknikos.WestgateMobileApp.base.pages.MyStayPage;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

public class MyStayTest extends BaseTest {

    private LaunchPage launchPage;
    private LoginPage loginPage;
    private MyStayPage myStayPage;

    @BeforeClass
    public void setUp() {
        ExtentReportManager.setupReport();

        launchPage = new LaunchPage(DriverManager.getDriver());
        loginPage  = new LoginPage(DriverManager.getDriver());
        myStayPage = new MyStayPage(DriverManager.getDriver());
    }

    @Test
    public void verifyMyStaySection() throws Exception {
        ExtentReportManager.startTest(
                "Verify My Stay Section",
                "Verify My Stay options are displayed"
        );

        launchPage.tapContinueAsGuest();
        loginPage.loginAsRegisteredUser(
                "Test101@gmail.com",
                "password"
        );

        myStayPage.verifyMyStaySection();
        myStayPage.tapMyStay();
        myStayPage.verifyMyStayOptions();
    }

   
}
