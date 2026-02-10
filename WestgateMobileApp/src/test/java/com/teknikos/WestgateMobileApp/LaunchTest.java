
package com.teknikos.WestgateMobileApp;

import org.testng.annotations.Test;

import com.teknikos.WestgateMobileApp.base.BaseTest;
import com.teknikos.WestgateMobileApp.base.pages.LaunchPage;
import com.teknikos.WestgateMobileApp.core.DriverManager;
import com.teknikos.WestgateMobileApp.utils.ExtentReportManager;

public class LaunchTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAppLaunch() {

        ExtentReportManager.startTest(
                "Verify App Launch",
                "Validate application launch screen is displayed"
        );

        LaunchPage launchPage = new LaunchPage(DriverManager.getDriver());
        launchPage.verifyAppLaunchedSuccessfully();
      
    }
}
