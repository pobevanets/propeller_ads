package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

public class MoveToSavedButtonIsDisabledUntilScroll extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Move to Saved button is disabled until scroll")
    public void MoveToSavedButtonIsDisabledUntilScrollTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .clickFirstArticleButton();

        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed()
                .checkMoveToSavedButtonIsDisabled()
                .scrollToDescriptionBottom()
                .checkMoveToSavedButtonIsActive();
    }
}
