package com.productname.testcases.functionalui;

import com.productname.core.Screen;
import com.productname.models.CarDto;
import com.productname.testcases.TestSuitesBase;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LandingPageTests extends TestSuitesBase implements Screen {
    private final static Logger log = LoggerFactory.getLogger(LandingPageTests.class);

    @Title("landing page search test")
    @Features("user is able to navigate and open landing page and do something there")
    @Stories("User is able to abracadabra actions on landingoage of the product")
    @Test(groups = {"E2E"})
    @Parameters({"browser"})
    public void landingPageSearchTest() {

        //LandingPage tripSummarySetStepOne = new LandingPage(driver);
        List<CarDto> carList = new ArrayList<>();
        CarDto carOne = new CarDto("VW", "Jetta", 4);
        CarDto carTwo = new CarDto("AUDI", "80", 5);
        CarDto carThree = new CarDto("MB", "190", 8);
        carList.add(carOne);
        carList.add(carTwo);
        carList.add(carThree);
        log.info("#### before filtering");
        for (CarDto carIter : carList) {
            log.info(carIter.toString());
        }
        log.info("######");
        log.info("######");
        log.info("######");

        log.info("### FILTERRED");
        List<CarDto> filteredwithStream = carList.stream().filter(x -> x.getWheelsNumber() == 4).collect(Collectors.toList());
        for (CarDto car : filteredwithStream) {

            log.info(car.toString());

        }
        log.info("######");
        log.info("######");
        log.info("######");
    }


    @Override
    public WebDriver getDriver() {
        return driver;
    }
}