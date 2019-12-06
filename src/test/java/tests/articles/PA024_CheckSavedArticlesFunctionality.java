package tests.articles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class PA024_CheckSavedArticlesFunctionality extends Actions {
    String articleTitle = "Leonel Messi";

    @Test(testName = "PA024 Check Saved Articles functionality")
    public void PA024_CheckSavedArticlesFunctionalityTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        Assert.assertFalse(mainPage.isSavedArticlesBlockDisplayed(), "Saved Articles block is displayed!");

        mainPage.clickTopLevelClientsButton()
                .clickArticleButton(articleTitle);

        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed()
                .scrollToDescriptionBottom()
                .clickMoveToSavedButton();
        Assert.assertTrue(mainPage.isSavedArticlesBlockDisplayed(), "Saved Articles block is NOT displayed!");

        mainPage.clickTopLevelClientsButtonInSavedArticles()
                .clickArticleButtonInSavedArticles(articleTitle);
        articlePage.waitForArticlePageIsDisplayed();

        Assert.assertEquals(articlePage.getArticleTitle(), articleTitle, "Article title is NOT as expected!");
    }
}
