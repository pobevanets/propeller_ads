package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class CheckImageSizeCanBeChangedBySlider extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Check image size can be changed by slider")
    public void CheckImageSizeCanBeChangedBySliderTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .clickFirstArticleButton();

        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed()
                .checkImageSizeIsCorrect("width: 300px; height: 300px;")
                .increaseImageToMaximum()
                .checkImageSizeIsCorrect("width: 500px; height: 500px;")
                .decreaseImageToMinimum()
                .checkImageSizeIsCorrect("width: 300px; height: 300px;");
    }
}
