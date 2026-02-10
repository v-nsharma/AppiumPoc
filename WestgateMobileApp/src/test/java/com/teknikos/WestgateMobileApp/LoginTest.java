package com.teknikos.WestgateMobileApp;
import org.testng.annotations.Test;

import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.base.pages.LaunchPage;
import com.teknikos.WestgateMobileApp.base.pages.LoginPage;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    @Test(priority = 2)
    public void verifyLoginFunctionality() throws InterruptedException {

        ExtentReportManager.startTest(
                "Verify Login Functionality",
                "Validate user can login with valid credentials"
        );

        LaunchPage launchPage = new LaunchPage(DriverManager.getDriver());
        launchPage.tapContinueAsGuest();

        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.loginAsRegisteredUser(
                "Test101@gmail.com",
                "password"
        );

          
    }
}
