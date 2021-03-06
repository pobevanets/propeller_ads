package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;
import pages.LoginPage;

public class Actions extends BaseTest {
    public void signIn(String login, String password) {
        new LoginPage().openWebsite()
                .enterLogin(login)
                .enterPassword(password)
                .hoverButton()
                .clickSignInButton()
                .confirmFirstConfirmationDialogue()
                .confirmSecondConfirmationDialogue();
    }

    public void signInWithCookies() {
        new LoginPage().openWebsite();
        Cookie cookie = new Cookie("secret", "IAmSuperSeleniumMaster");
        WebDriverRunner.driver().getWebDriver().manage().addCookie(cookie);
        new LoginPage().openWebsite();
    }
}
