package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import logging.EventHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.function.Predicate;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {
    private int SELENIUM_TIMEOUT_10s = 10;
    protected int SELENIDE_TIMEOUT_4s = 4000;
    protected int SELENIDE_TIMEOUT_10s = 10000;
    protected int SELENIDE_TIMEOUT_30s = 30000;

    protected void open(String Url) {
        //Selenide.clearBrowserCookies();
        Selenide.open(Url);
    }

    public void openInNewTab(String url){
        ((JavascriptExecutor)getWebDriver()).executeScript(String.format("window.open('%s','_blank');", url));
        switchTab(1);
    }

    public String getURL() {
        return WebDriverRunner.url();
    }

    protected int getIndexOf(String collectionLocator, String name) {
        return $$(collectionLocator).shouldBe(sizeGreaterThan(0)).texts().indexOf(name);
    }

    protected void uploadImageFile(String fileName, String fileInputLocator){
        File image = new File(BasePage.class.getResource("/" + fileName).getFile());
        try {
            getWebDriver().findElement(By.cssSelector(fileInputLocator)).sendKeys(image.getAbsolutePath());
        }
        catch (StaleElementReferenceException ex){
            EventHandler.writeToLogAndConsole(ex.getMessage());
        }
    }

    public void refreshPage() {
        refresh();
    }

    protected void waitForCollectionChange(List<String> col1, String locatorCol2) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), SELENIUM_TIMEOUT_10s);
        wait.until(collectionsAreNotTheSame(col1, locatorCol2));
    }

    protected void waitForCssValue(SelenideElement element, String value, String expected){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), SELENIUM_TIMEOUT_10s);
        wait.until(myExpectedConditions(driver -> element.getCssValue(value).equals(expected)));
    }

    protected void clearInputWithKeys(SelenideElement element){
        element.click();
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.BACK_SPACE);
    }

    protected void typeSlowly(String text, SelenideElement element){
        for (int i = 0; i < text.length(); i++){
            element.sendKeys(String.valueOf(text.charAt(i)));
            Selenide.sleep(10);
        }
    }

    public void switchTab(int index){
        switchTo().window(index);
    }

    private ExpectedCondition<Boolean> collectionsAreNotTheSame(List<String> col1, String locatorCol2) {
        return driver -> {
            List<String> col2 = $$(locatorCol2).texts();
            return !areCollectionsEqualsIgnoreCase(col1, col2);
        };
    }

    private boolean areCollectionsEqualsIgnoreCase(List<String> col1, List<String> col2) {
        if(col1.size() != col2.size())
            return false;
        for (int i=0; i < col1.size(); i++) {
            if (!col1.get(i).equalsIgnoreCase(col2.get(i)))
                return false;
        }
        return true;
    }

    private ExpectedCondition<Boolean> myExpectedConditions(Predicate func) {
        return driver -> func.test(driver);
    }
}
