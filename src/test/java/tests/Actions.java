package tests;

import pages.LoginPage;
import pages.MainPage;

public class Actions extends BaseTest {
    void signIn(String login, String password) {
        new LoginPage().openWebsite()
                .enterLogin(login)
                .enterPassword(password)
                .hoverButton()
                .clickSignInButton()
                .confirmFirstConfirmationDialogue()
                .confirmSecondConfirmationDialogue();
        new MainPage().waitForMainPage();
    }
}