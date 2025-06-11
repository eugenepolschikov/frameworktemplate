package com.productname.testcases.functionalui;

import com.productname.core.Screen;
import com.productname.selenium.pages.LandingPage;
import com.productname.testcases.TestSuitesBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;


public class LandingPageTests extends TestSuitesBase implements Screen {

    @Title("landing page search test")
    @Features("user is able to navigate and open landing page and do something there")
    @Stories("User is able to abracadabra actions on landingoage of the product")
    @Test(groups = {"E2E"})
    @Parameters({"browser"})
    public void landingPageSearchTest() {

        LandingPage tripSummarySetStepOne = new LandingPage(driver);

    }


    @Override
    public WebDriver getDriver() {
        return driver;
    }
}