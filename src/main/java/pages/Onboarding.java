package pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onboarding extends CommonActions{

    IOSDriver driver;

    public Onboarding(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
    public WebElement closeBut;
    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit PDFs']")
    public WebElement firstSlideTitle;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@value='Welcome to PDF Extra']")
    public WebElement secondSlideTitle;



    public void close(){
        closeBut.click();
    }
    public String getFirstSlideTitle() {
        return firstSlideTitle.getText();
    }

    public String getSecondSlideTitle(){
        waitToElement(secondSlideTitle, driver);
        return secondSlideTitle.getText();
    }

}
