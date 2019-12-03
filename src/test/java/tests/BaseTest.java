package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import logging.EventHandler;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void browserConf() {
        WebDriver driver;
        if (System.getProperty("browser.type").equals("headless"))
            driver = createHeadlessChromeWebDriver();
        else
            driver = createSelenideWebDriver();
        setEventFiringWebDriver(driver);
        // set false -> do not escape html symbols in reportNG html reports
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    @AfterMethod(alwaysRun = true)
    public void killDriver() {
        Selenide.closeWebDriver();
    }

    private WebDriver createSelenideWebDriver() {
        System.setProperty("webdriver.chrome.driver", provideDriverAccToSystemType());
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 15000;
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        // do not allow notifications (popup from browser)
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);
        // options.addArguments ("headless","disable-gpu");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
    }

    private void setEventFiringWebDriver(WebDriver driver){
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());
        setWebDriver(eventDriver);
    }

    private WebDriver createHeadlessChromeWebDriver() {
        System.setProperty("webdriver.chrome.driver", provideDriverAccToSystemType());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<>();
        // do not allow notifications (popup from browser)
        prefs.put("profile.default_content_setting_values.notifications", 2);
        // allow geolocation (popup from browser)
        prefs.put("profile.default_content_setting_values.geolocation", 1);

        chromeOptions.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().setSize(new Dimension(1920, 1080));
        return driver;
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
