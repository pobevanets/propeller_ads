package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Urls;

public class PA002_LoginAndCancelConfirmation extends Actions {

    @Test(testName = "PA002 Login and cancel confirmation")
    public void PA002_LoginAndCancelConfirmationTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openWebsite()
                .enterLogin("test")
                .enterPassword("test")
                .hoverButton()
                .clickSignInButton()
                .cancelFirstConfirmationDialogue()
                .clickSignInButton()
                .confirmFirstConfirmationDialogue()
                .cancelSecondConfirmationDialogue();

        Assert.assertEquals(loginPage.getCurrentUrl(), Urls.baseUrl + "loginError.html",
                "Error page is not as expected");
    }
}
