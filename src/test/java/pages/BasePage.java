package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

public abstract class BasePage {

    protected void open(String Url) {
        Selenide.open(Url);
    }

    public String getURL() {
        return WebDriverRunner.url();
    }

}
