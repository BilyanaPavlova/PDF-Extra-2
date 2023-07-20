package utilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.WelcomePage;
import utilities.AlertUtils;


import java.time.Duration;

//this class contains all reusable code for the test classes

public class BasePage {
    public AppiumDriverLocalService appiumService;
    public IOSDriver driver;

    public WelcomePage welcomePage;


    @BeforeClass
    public void startServer() {

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("0.0.0.0");
        serviceBuilder.usingPort(4723);
        serviceBuilder.withArgument(() -> "--use-plugins=execute-driver");
//        serviceBuilder.withArgument(() -> "--clear-system-files");
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();

    }



    //    This is the driver setup for simulator with XCUITestOptions
    @BeforeClass(dependsOnMethods = "startServer")
    public void initialiseDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("APPIUM_VERSION", "2");
        options.setDeviceName("iPhone Xs");
        options.setPlatformVersion("16.4");
        options.setCapability("newCommandTimeout", 300);
//        options.setApp("/Users/bilyana.aneva/Library/Developer/Xcode/DerivedData/Office_Suite_Pro-etmjzctktnpxsmadwmvvnvxbueje/Build/Products/Debug-iphonesimulator/PDFExtra.app");
        options.setApp("/Users/bilyana.aneva/IdeaProjects/newRetireve/PDFExtra/PDFExtra/src/test/java/pdfextra/resources/PDFExtra/PDFExtra.app");
        options.setWdaLaunchTimeout(Duration.ofSeconds(30));
        driver = new IOSDriver(appiumService, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(100));
    }

    @BeforeClass(dependsOnMethods = "initialiseDriver")
    public void openAppFreeUser(){

        try {
            AlertUtils.acceptAlert(driver);
        } catch (NoAlertPresentException e) {
            //handle exception - code for the logs here
//            System.out.println("Alert is not present");
        }

        welcomePage = new WelcomePage(driver);

    }


    @AfterClass
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public void stopServer() {
        if (appiumService != null) {
            appiumService.stop();
        }
    }



}

