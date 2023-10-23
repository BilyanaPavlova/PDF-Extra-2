package service;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.CommonActions;
import pages.WelcomePage;



import java.time.Duration;

//this class contains all reusable code for the test classes

public class BaseTest extends CommonActions {
//    public AppiumDriverLocalService appiumService;
//    public IOSDriver driver;



    public WelcomePage welcomePage;

    @BeforeClass
    public void startService(){
       startServer();
       initialiseDriver();
       welcomePage = new WelcomePage(driver);
    }

    @AfterClass
    public void stopService(){
        quitDriver();
        stopServer();
    }



}

