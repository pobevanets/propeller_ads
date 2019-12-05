package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage extends BasePage {
    private final SelenideElement firstNameInput = $("#firstNameInput");
    private final SelenideElement lastNameInput = $("#lastNameInput");
    private final SelenideElement saveUserInfoButton = $$("button").findBy(text("Save user info"));
    private final SelenideElement successUserInfoSaveNotification = $("#successUserInfoSaveInfo");
    private final SelenideElement paymentInfoTab = $$("#v-pills-messages-tab").findBy(text("Payment info"));
    private final SelenideElement cardNumberInput = $("#cardNumberInput");
    private final SelenideElement paymentSystemSelect = $("#paymentSystemSelect");
    private final SelenideElement paymentDaySlider = $("#paymentRange");
    private final SelenideElement savePaymentInfoButton = $$("button").findBy(text("Save payment info"));
    private final SelenideElement successPaymentInfoSaveNotification = $("#successPaymentInfoSaveInfo");
    private final ElementsCollection errorMessages = $$(".invalid-feedback");
    private final SelenideElement paymentDayValue = $("h6");

    public ProfilePage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public ProfilePage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public ProfilePage clickSaveUserInfo() {
        saveUserInfoButton.click();
        return this;
    }

    public ProfilePage successUserInfoSaveNotificationIsDisplayed() {
        successUserInfoSaveNotification.should(appear);
        return this;
    }

    public ProfilePage clickPaymentInfoTab() {
        paymentInfoTab.click();
        return this;
    }

    public ProfilePage enterCardNumber(String cardNumber) {
        cardNumberInput.setValue(cardNumber);
        return this;
    }

    public ProfilePage selectPaymentSystem(String paymentSystem) {
        paymentSystemSelect.selectOptionContainingText(paymentSystem);
        return this;
    }

    public ProfilePage selectPaymentDay(int day) {
        paymentSystemSelect.pressTab();
        if (day == 1) {
            paymentDaySlider.sendKeys(Keys.ARROW_RIGHT);
            paymentDaySlider.sendKeys(Keys.ARROW_LEFT);
        }
        for (int i = 1; i<day; i++) {
            paymentDaySlider.sendKeys(Keys.ARROW_RIGHT);
        }
        return this;
    }

    public ProfilePage clickSavePaymentInfo() {
        savePaymentInfoButton.click();
        return this;
    }

    public ProfilePage successPaymentInfoSaveNotificationIsDisplayed() {
        successPaymentInfoSaveNotification.should(appear);
        return this;
    }

    public ProfilePage errorMessageFirstNameInputIsDisplayed() {
        errorMessages.findBy(text("Please set your first name.")).shouldBe(visible);
        return this;
    }

    public ProfilePage errorMessageLastNameInputIsDisplayed() {
        errorMessages.findBy(text("Please set your last name.")).shouldBe(visible);
        return this;
    }

    public ProfilePage errorMessageCardNumberInputIsDisplayed() {
        errorMessages.findBy(text("Please set your card number.")).shouldBe(visible);
        return this;
    }

    public ProfilePage errorMessagePaymentSystemInputIsDisplayed() {
        errorMessages.findBy(text("Please select your payment system.")).shouldBe(visible);
        return this;
    }

    public ProfilePage errorMessageFirstNameInputNotDisplayed() {
        errorMessages.findBy(text("Please set your first name.")).shouldNotBe(visible);
        return this;
    }


    public ProfilePage errorMessageLastNameInputNotDisplayed() {
        errorMessages.findBy(text("Please set your last name.")).shouldNotBe(visible);
        return this;
    }

    public ProfilePage errorMessageCardNumberInputNotDisplayed() {
        errorMessages.findBy(text("Please set your card number.")).shouldNotBe(visible);
        return this;
    }

    public ProfilePage errorMessagePaymentSystemInputNotDisplayed() {
        errorMessages.findBy(text("Please select your payment system.")).shouldNotBe(visible);
        return this;
    }


    public ProfilePage selectTextInFirstNameInput() {
        firstNameInput.doubleClick();
        return this;
    }

    public ProfilePage selectTextInLastNameInput() {
        lastNameInput.doubleClick();
        return this;
    }

    public ProfilePage selectTextInCardNumberInput() {
        cardNumberInput.doubleClick();
        return this;
    }

    public String getSelectedPaymentSystem() {
        return paymentSystemSelect.getSelectedOption().text();
    }

    public int getSelectedPaymentDay() {
        return Integer.parseInt(paymentDayValue.text().replaceAll("\\D+",""));
    }

    public String getHighlightedText() {
        return executeJavaScript("return window.getSelection().toString();");
    }

}
