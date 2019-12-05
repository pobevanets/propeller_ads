package tests.articles;

import org.testng.annotations.Test;
import pages.MainPage;
import tests.Actions;

public class PA021_CheckArticlesQuantity extends Actions {

    @Test(testName = "PA021 Check articles quantity")
    public void PA021_CheckArticlesQuantityTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAdvertisersButton()
                .checkArticlesButtonsQuantity(2)
                .clickAdvertisersButton()
                .clickPublishersButton()
                .checkArticlesButtonsQuantity(2)
                .clickPublishersButton()
                .clickTopLevelClientsButton()
                .checkArticlesButtonsQuantity(10)
                .clickTopLevelClientsButton();
    }
}
