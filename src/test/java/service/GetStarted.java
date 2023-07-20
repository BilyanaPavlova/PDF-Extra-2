package service;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BasePage;

public class GetStarted extends BasePage {

    @Test
    public void openApp(){

        String button = welcomePage.getButtonText();
        Assert.assertEquals(button, "Get Started");

    }


}
