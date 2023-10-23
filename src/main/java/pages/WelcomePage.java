package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage extends CommonActions {

    IOSDriver driver;

    public WelcomePage(IOSDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    @FindBy(id = "Welcome to PDF Extra")
//    public WebElement title;

    @iOSXCUITFindBy(accessibility = "Welcome to PDF Extra")
    public WebElement title;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Get Started']")
    public WebElement getStartedButton;


    public Onboarding getStarted(){
        getStartedButton.click();
        return new Onboarding(driver);
    }


}
