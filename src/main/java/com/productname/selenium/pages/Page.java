package com.productname.selenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Step;

import static com.productname.utils.CaptureSnapshot.captureSnapshotForAllure;
import static com.productname.webdriver.ElementsUtil.getLongTimeIntervalSec;
import static com.productname.webdriver.ElementsUtil.getShortestTimeIntervalSec;
import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final static Logger log = LoggerFactory.getLogger(Page.class);


    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, getLongTimeIntervalSec() * 4);
        driver.manage().timeouts().implicitlyWait(getShortestTimeIntervalSec() * 2, SECONDS);
        PageFactory.initElements(driver, this);
    }

    @Step("allure page screenshot")
    public Page doScreenshotOfPage() {
        captureSnapshotForAllure(driver);
        return this;
    }

    protected void switchToDefaultContent() {
        log.info("swithching back to default content , i.e moving out from frame");
        driver.switchTo().defaultContent();
    }
}
