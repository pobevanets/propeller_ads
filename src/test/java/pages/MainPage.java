package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.Urls;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    private final SelenideElement avatar = $("#avatar");
    private final SelenideElement advertisersButton = $$("button.tree-main-button").findBy(text("Advertisers"));
    private final SelenideElement publishersButton = $$("button.tree-main-button").findBy(text("Publishers"));
    private final SelenideElement topLevelClientsButton = $$("button.tree-main-button").findBy(text("Top level clients"));
    private final ElementsCollection articlesButtons = $$("button.btn.btn-outline-info.tree-button");
    private final SelenideElement savedArticlesBlock = $$("div.card").findBy(text("Saved articles"));

    public MainPage waitForMainPageIsDisplayed() {
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

    public MainPage clickAdvertisersButton() {
        advertisersButton.click();
        return this;
    }

    public MainPage clickPublishersButton() {
        publishersButton.click();
        return this;
    }

    public MainPage clickTopLevelClientsButton() {
        topLevelClientsButton.click();
        return this;
    }

    public MainPage clickTopLevelClientsButtonInSavedArticles() {
        savedArticlesBlock.$$("button.tree-main-button").findBy(text("Top level clients")).click();
        return this;
    }

    public MainPage clickFirstArticleButton() {
        articlesButtons.filter(visible).first().click();
        return this;
    }

    public MainPage clickArticleButton(String articleTitle) {
        articlesButtons.findBy(text(articleTitle)).click();
        return this;
    }

    public MainPage clickArticleButtonInSavedArticles(String articleTitle) {
        savedArticlesBlock.$$("button.btn.btn-outline-info.tree-button").findBy(text(articleTitle)).click();
        return this;
    }

    public MainPage checkArticlesButtonsQuantity(int expectedSize) {
        articlesButtons.filter(visible).shouldHaveSize(expectedSize);
        return this;
    }

    public MainPage openMainPage() {
        open(Urls.baseUrl + "main.html");
        return this;
    }

    public boolean isSavedArticlesBlockDisplayed() {
        return savedArticlesBlock.is(visible);
    }
}
