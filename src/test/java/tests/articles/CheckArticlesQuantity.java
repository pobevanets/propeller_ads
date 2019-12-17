package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import tests.Actions;

public class CheckArticlesQuantity extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Check articles quantity")
    public void CheckArticlesQuantityTest() {
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
