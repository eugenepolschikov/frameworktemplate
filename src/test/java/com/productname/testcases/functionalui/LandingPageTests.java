package com.productname.testcases.functionalui;

import com.productname.core.Screen;
import com.productname.testcases.TestSuitesBase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.productname.models.objectmappers.JsonToPersons.parseResponseToPersons;
import static com.productname.testcases.api.ApiClient.restAssuredGet;


public class LandingPageTests extends TestSuitesBase implements Screen {
    private final static Logger log = LoggerFactory.getLogger(LandingPageTests.class);


    @Test(groups = {"E2E"})
    @Parameters({"browser"})
    public void landingPageSearchTest() throws IOException {


        String apiServiceUrl = "https://jsonplaceholder.typicode.com/posts";
        String myJson = restAssuredGet(apiServiceUrl);
        parseResponseToPersons(myJson);


    }


    @Override
    public WebDriver getDriver() {
        return driver;
    }
}