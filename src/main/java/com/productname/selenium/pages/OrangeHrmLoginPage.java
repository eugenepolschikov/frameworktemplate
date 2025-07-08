package com.productname.selenium.pages;

import com.productname.models.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.productname.selenium.pages.OrangeHrmDashboardPage.DASHBOARD_URL_PATH;
import static com.productname.webdriver.ElementsUtil.*;

public class OrangeHrmLoginPage extends Page {
    public static final String LOGINPAGE_URL_PATH = "/web/index.php/auth/login";

    private final static String USERNAME_INPUT = "username";
    private final static String PASSWORD_INPUT = "password";
    private final static String LOGIN_BUTTON = "//button[@type='submit']";


    @FindBy(name = USERNAME_INPUT)
    private WebElement username;

    @FindBy(name = PASSWORD_INPUT)
    private WebElement password;

    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginButton;

    public OrangeHrmLoginPage(WebDriver driver) {
        super(driver);
    }

    public OrangeHrmDashboardPage login(Credentials credentials) {
        log.info("entering the login credentials");
        waitForPageLoaded(driver);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(LOGINPAGE_URL_PATH));
        fluentWait(driver, By.name(USERNAME_INPUT));
        username.clear();
        username.sendKeys(credentials.getLogin());

        password.clear();
        password.sendKeys(credentials.getPassword());

        loginButton.click();
        waitTillPageUrlChanges(driver, DASHBOARD_URL_PATH);
        return new OrangeHrmDashboardPage(driver);
    }
}
