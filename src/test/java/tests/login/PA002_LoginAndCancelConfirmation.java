package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.Actions;
import utils.Urls;

import static org.testng.Assert.*;

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

        assertEquals(loginPage.getCurrentUrl(), Urls.baseUrl + "loginError.html",
                "Error page is not as expected");
    }
}
