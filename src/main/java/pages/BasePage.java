package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import java.time.Duration;

public class BasePage {

    private AppiumDriverLocalService appiumService;
    public IOSDriver driver;


    public void startServer() {

        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
        serviceBuilder.withIPAddress("0.0.0.0");
        serviceBuilder.usingPort(4723);
        serviceBuilder.withArgument(() -> "--use-plugins=execute-driver");
//        serviceBuilder.withArgument(() -> "--clear-system-files");
        appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
        appiumService.start();

    }

    public void initialiseDriver() {
        XCUITestOptions options = new XCUITestOptions();
        options.setCapability("APPIUM_VERSION", "2");
        options.setDeviceName("iPhone Xs");
        options.setPlatformVersion("16.2");
        options.setCapability("newCommandTimeout", 300);
//        options.setApp("/Users/bilyana.aneva/Library/Developer/Xcode/DerivedData/Office_Suite_Pro-etmjzctktnpxsmadwmvvnvxbueje/Build/Products/Debug-iphonesimulator/PDFExtra.app");
//        options.setApp("/Users/bilyana.aneva/IdeaProjects/newRetireve/PDFExtra/PDFExtra/src/test/java/pdfextra/resources/PDFExtra/PDFExtra.app");
        options.setApp("/Users/bilyana.aneva/Library/Developer/Xcode/DerivedData/Office_Suite_Pro-etmjzctktnpxsmadwmvvnvxbueje/Build/Products/Debug-iphonesimulator/PDFExtra.app");
        driver = new IOSDriver(appiumService, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
//        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(100));
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void stopServer() {
        if (appiumService != null) {
            appiumService.stop();
        }

    }

    public IOSDriver getDriver() {
        return driver;
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public void acceptAlert() {
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }
}
