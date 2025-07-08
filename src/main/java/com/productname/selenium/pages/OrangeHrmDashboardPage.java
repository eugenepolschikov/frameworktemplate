package com.productname.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrangeHrmDashboardPage extends Page {
    public static final String DASHBOARD_URL_PATH = "/web/index.php/dashboard/index";

    private final static String USER_THUMBNAIL_CSS = " header.oxd-topbar li.oxd-userdropdown";


    @FindBy(css = USER_THUMBNAIL_CSS)
    private WebElement userThumbnail;

    public OrangeHrmDashboardPage(WebDriver driver) {
        super(driver);
    }

    public OrangeHrmDashboardPage validateUserLoggedIn() {
        Assert.assertTrue(userThumbnail.isDisplayed());
        return this;
    }

    public void validatePageTitle() {
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }


}
