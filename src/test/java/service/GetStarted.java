package service;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Onboarding;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;

public class GetStarted extends BaseTest {

    Onboarding onboarding;

    @Test
    public void getStarted() throws InterruptedException {
        acceptAlert();
        onboarding = welcomePage.getStarted();
        assertEquals(onboarding.getFirstSlideTitle(), "Edit PDFs");
        swipeLeft();
//        assertEquals(onboarding.getSecondSlideTitle(), "Welcome to PDF Extra");
        onboarding.close();

        swipeLeft();
        onboarding.close();

        acceptAlert();
        Thread.sleep(5000);
    }




}
