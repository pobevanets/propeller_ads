package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    private final SelenideElement avatar = $("#avatar");
    private final SelenideElement advertisersButton = $$("button.tree-main-button").findBy(text("Advertisers"));
    private final SelenideElement publishersButton = $$("button.tree-main-button").findBy(text("Publishers"));
    private final SelenideElement topLevelClientsButton = $$("button.tree-main-button").findBy(text("Top level clients"));

    public MainPage waitForMainPage() {
        avatar.waitUntil(visible, 6000);
        advertisersButton.shouldBe(visible);
        publishersButton.shouldBe(visible);
        topLevelClientsButton.shouldBe(visible);
        return this;
    }

    public MainPage clickAvatar() {
        avatar.click();
        return this;
    }

    public MainPage openMainPage() {
        open("http://localhost:8080/main.html");
        return this;
    }
}
