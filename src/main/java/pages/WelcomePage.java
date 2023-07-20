package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonActions;

public class WelcomePage extends CommonActions {

    IOSDriver driver;
    public WelcomePage(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(id = "Welcome to PDF Extra")
//    public WebElement title;

    @iOSXCUITFindBy(accessibility = "Welcome to PDF Extra")
    public WebElement title;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Get Started']")
    public WebElement getStartedButton;

    public String getButtonText(){
        return getStartedButton.getText();
    }

    public boolean isTitleDisplayed(){
        return title.isDisplayed();
    }
}
