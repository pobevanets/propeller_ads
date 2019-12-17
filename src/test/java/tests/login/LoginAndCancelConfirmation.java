package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import tests.Actions;
import utils.Urls;

import static org.testng.Assert.*;

public class LoginAndCancelConfirmation extends Actions {

    @Test(testName = "Login and cancel confirmation")
    public void LoginAndCancelConfirmationTest() {
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
