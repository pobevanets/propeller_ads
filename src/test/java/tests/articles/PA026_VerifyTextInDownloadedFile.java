package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

import java.io.File;
import java.io.FileNotFoundException;

import static org.testng.Assert.*;

public class PA026_VerifyTextInDownloadedFile extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "PA026 Verify text in downloaded file")
    public void PA026_VerifyTextInDownloadedFileTest() throws FileNotFoundException {
        MainPage mainPage = new MainPage();
        mainPage.clickTopLevelClientsButton()
                .clickFirstArticleButton();
        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed();

        File downloadedFile = articlePage.downloadInfoButton.download(10000);

        assertTrue(downloadedFile.toString().contains("Jon Snow"));
    }
}
