package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Urls;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    private final SelenideElement loginInputForm = $(".form-group", 0);
    private final SelenideElement loginInput = $("#loginInput");
    private final SelenideElement passwordInputForm = $(".form-group", 1);
    private final SelenideElement passwordInput = $("#passwordInput");
    private final SelenideElement hoverMeFasterButton = $$("button").findBy(text("Hover me faster!"));
    private final SelenideElement signInButton = $("img[src='sign.png']");

    public LoginPage openWebsite() {
        open(Urls.baseUrl);
        return this;
    }

    public LoginPage enterLogin(String login) {
        loginInputForm.click();
        loginInput.setValue(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInputForm.click();
        passwordInput.setValue(password);
        return this;
    }

    public LoginPage hoverButton() {
        hoverMeFasterButton.hover();
        return this;
    }

    public LoginPage clickSignInButton() {
        signInButton.waitUntil(visible, 12000).click();
        return this;
    }

    public LoginPage confirmFirstConfirmationDialogue() {
        confirm("Are you sure you want to login?");
        return this;
    }

    public LoginPage cancelFirstConfirmationDialogue() {
        dismiss("Are you sure you want to login?");
        return this;
    }

    public LoginPage confirmSecondConfirmationDialogue() {
        confirm("Really sure?");
        return this;
    }

    public LoginPage cancelSecondConfirmationDialogue() {
        dismiss("Really sure?");
        return this;
    }

    public String getCurrentUrl() {
        return getURL();
    }

}
