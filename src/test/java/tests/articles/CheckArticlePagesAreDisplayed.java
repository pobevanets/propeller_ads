package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class CheckArticlePagesAreDisplayed extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Check article pages are displayed")
    public void CheckArticlePagesAreDisplayedTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .clickFirstArticleButton();
        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed();

        mainPage.openMainPage()
                .clickPublishersButton()
                .clickFirstArticleButton();
        articlePage.waitForArticlePageIsDisplayed();

        mainPage.openMainPage()
                .clickTopLevelClientsButton()
                .clickFirstArticleButton();
        articlePage.waitForArticlePageIsDisplayed();
    }
}
