package tests;

import com.codeborne.selenide.Selenide;
import logging.EventHandler;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void browserConf() {
        WebDriver driver;
        if (System.getProperty("mode").equals("headless"))
            driver = createHeadlessChromeWebDriver();
        else
            driver = createVisibleChromeWebDriver();
        setEventFiringWebDriver(driver);
        // set false -> do not escape html symbols in reportNG html reports
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver() {
        Selenide.closeWebDriver();
    }

    private WebDriver createVisibleChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", provideDriverAccToSystemType());
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }

    private WebDriver createHeadlessChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", provideDriverAccToSystemType());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }

    private void setEventFiringWebDriver(WebDriver driver){
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());
        setWebDriver(eventDriver);
    }

    private String OS = System.getProperty("os.name").toLowerCase();

    private String provideDriverAccToSystemType() {
        if (isWindows()) {
            return "src\\test\\resources\\chromedriver_win32\\chromedriver.exe";
        } else if (isUnix()) {
            return "src/test/resources/chromedriver_linux64/chromedriver";
        } else {
            throw new RuntimeException("Your system type was not detected! Please download and set chromedriver by yourself");
        }
    }

    private boolean isWindows() {
        return OS.contains("win");
    }

    private boolean isUnix() {
        return OS.contains("nux");
    }
}
