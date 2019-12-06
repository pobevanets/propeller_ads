package tests.articles;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class PA025_CheckImageSizeCanBeChangedBySlider extends Actions {
    @Test(testName = "PA025 Check image size can be changed by slider")
    public void PA025_CheckImageSizeCanBeChangedBySliderTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .clickFirstArticleButton();
        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed();

        articlePage.checkImageSizeIsCorrect("width: 300px; height: 300px;");
        Selenide.sleep(5000);
        articlePage.checkImageSizeIsCorrect("width: 500px; height: 500px;");
    }
}
