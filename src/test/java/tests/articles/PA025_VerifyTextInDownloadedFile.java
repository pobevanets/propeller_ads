package tests.articles;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ArticlePage;
import pages.MainPage;
import tests.Actions;

import java.io.File;
import java.io.FileNotFoundException;

public class PA025_VerifyTextInDownloadedFile extends Actions {

    @Test(testName = "PA025 Verify text in downloaded file")
    public void PA025_VerifyTextInDownloadedFileTest() throws FileNotFoundException {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickTopLevelClientsButton()
                .clickFirstArticleButton();
        ArticlePage articlePage = new ArticlePage();
        articlePage.waitForArticlePageIsDisplayed();


        File downloadedFile = articlePage.downloadInfoButton.download(10000);

        Assert.assertTrue(downloadedFile.toString().contains("Jon Snow"));
    }
}
