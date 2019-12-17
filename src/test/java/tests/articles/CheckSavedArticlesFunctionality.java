package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

import static org.testng.Assert.*;

public class CheckSavedArticlesFunctionality extends Actions {
    String articleTitle = "Leonel Messi";

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Check Saved Articles functionality")
    public void CheckSavedArticlesFunctionalityTest() {
        MainPage mainPage = new MainPage();
        assertFalse(mainPage.isSavedArticlesBlockDisplayed(), "Saved Articles block is displayed!");

        mainPage.clickTopLevelClientsButton()
                .clickArticleButton(articleTitle);

        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed()
                .scrollToDescriptionBottom()
                .clickMoveToSavedButton();
        assertTrue(mainPage.isSavedArticlesBlockDisplayed(), "Saved Articles block is NOT displayed!");

        mainPage.clickTopLevelClientsButtonInSavedArticles()
                .clickArticleButtonInSavedArticles(articleTitle);
        articlePage.waitForArticlePageIsDisplayed();

        assertEquals(articlePage.getArticleTitle(), articleTitle, "Article title is NOT as expected!");
        assertTrue(mainPage.isSavedArticleInCookies(articleTitle), "Article title is NOT saved in cookies!");
    }
}
