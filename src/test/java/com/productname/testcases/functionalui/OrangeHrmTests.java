package com.productname.testcases.functionalui;

import com.productname.core.Screen;
import com.productname.selenium.pages.OrangeHrmLoginPage;
import com.productname.testcases.TestSuitesBase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class OrangeHrmTests extends TestSuitesBase implements Screen {
    private final static Logger log = LoggerFactory.getLogger(OrangeHrmTests.class);


    @Test(groups = {"E2E"})
    public void orangeHrmLoginTest() {
        log.info("executing login end-to-end test");
        new OrangeHrmLoginPage(driver)
            .login(configs.getOrangeHrmCredentials())
            .validateUserLoggedIn()
            .validatePageTitle();
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

}
