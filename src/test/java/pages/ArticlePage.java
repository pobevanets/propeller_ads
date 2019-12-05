package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ArticlePage extends BasePage {
    private final SelenideElement articleTitle = $("h5.card-title");
    private final SelenideElement downloadInfoButton = $$("button").findBy(text("Download info"));
    private final SelenideElement articleImage = $("#heroImage");
    private final SelenideElement imageSlider = $("div.ui-slider");
    private final SelenideElement moveToSavedButton = $$("button").findBy(text("Move to saved"));
    private final SelenideElement removedFromSavedButton = $$("button").findBy(text("Removed from saved"));

    public ArticlePage waitForArticlePageIsDisplayed() {
        articleTitle.waitUntil(visible, 12000);
        downloadInfoButton.shouldBe(visible);
        articleImage.shouldBe(visible);
        imageSlider.scrollTo().shouldBe(visible);
        moveToSavedButton.scrollTo().shouldBe(visible);
        removedFromSavedButton.scrollTo().shouldBe(visible);
        return this;
    }

}
