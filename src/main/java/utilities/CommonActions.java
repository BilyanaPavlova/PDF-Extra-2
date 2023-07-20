package utilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActions {

    private IOSDriver driver;

    public CommonActions(IOSDriver driver) {
        this.driver = driver;
    }

    private TouchAction touchAction;

    public WebDriverWait wait;


    private int startX;
    private int startY;
    private int endX;
    private int endY;


        public void swipeLeft(){
            getScreenSize();
            touchAction = new TouchAction(driver);
            // Perform the swipe gesture
            touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

        }

    // generic method - can return whatever object we pass as a .class
    public <T> T swipeLeft(Class<T> pageClass) {
        getScreenSize();
        touchAction = new TouchAction(driver);
        // Perform the swipe gesture
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform()
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(5000)));

        try {
            return pageClass.getDeclaredConstructor(IOSDriver.class).newInstance(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void getScreenSize() {
        // Get the size of the screen
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        // Define the starting and ending coordinates for the swipe gesture
        startX = (int) (screenWidth * 0.9);
        startY = screenHeight / 2;
        endX = (int) (screenWidth * 0.1);
        endY = screenHeight / 2;
    }

    public int getScreenHeight() {
        return driver.manage().window().getSize().getHeight();
    }

    public int getScreenWidth() {
        return driver.manage().window().getSize().getWidth();
    }

    private void killApp() {
        driver.terminateApp("com.mobisystems.PDFExtra");
    }

    public void launchApp() {
        if (isAppRunning()) {
            killApp();
        }
            driver.launchApp();
    }

    private boolean isAppRunning() {
        boolean isAppRunning = driver.isAppInstalled("com.mobisystems.PDFExtra");
        return isAppRunning;
    }

    public void close(WebElement closeElement){
        closeElement.click();
    }

    public void waitToElement(WebElement element){
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));
    }



}

