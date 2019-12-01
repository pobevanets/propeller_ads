package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage extends BasePage {
    private final SelenideElement firstNameInput = $("#firstNameInput");
    private final SelenideElement lastNameInput = $("#lastNameInput");
    private final SelenideElement saveUserInfoButton = $$("button").findBy(text("Save user info"));
    private final SelenideElement successUserInfoSaveNotification = $("#successUserInfoSaveInfo");
    private final SelenideElement paymentInfoTab = $$("#v-pills-messages-tab").findBy(text("Payment info"));
    private final SelenideElement cardNumberInput = $("#cardNumberInput");
    private final SelenideElement paymentSystemSelect = $("#paymentSystemSelect");
    private final SelenideElement savePaymentInfoButton = $$("button").findBy(text("Save payment info"));
    private final SelenideElement successPaymentInfoSaveNotification = $("#successPaymentInfoSaveInfo");

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

    public ProfilePage clickSavePaymentInfo() {
        savePaymentInfoButton.click();
        return this;
    }

    public ProfilePage successPaymentInfoSaveNotificationIsDisplayed() {
        successPaymentInfoSaveNotification.should(appear);
        return this;
    }

}
