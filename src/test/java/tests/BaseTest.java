package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import logging.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void browserConf() {
        Configuration.browserSize = "1920x1080";
        Selenide.open("about:blank");
        WebDriver driver = WebDriverRunner.driver().getWebDriver();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());
        setWebDriver(eventDriver);
        // set false -> do not escape html symbols in reportNG html reports
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver() {
        Selenide.closeWebDriver();
    }

}
