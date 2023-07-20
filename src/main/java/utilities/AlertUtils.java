package utilities;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

public class AlertUtils {

    private static boolean isAlertPresent(AppiumDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public static void acceptAlert(AppiumDriver driver) {
        if (isAlertPresent(driver)) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }
}

