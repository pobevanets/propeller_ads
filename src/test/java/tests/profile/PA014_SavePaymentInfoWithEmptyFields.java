package tests.profile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class PA014_SavePaymentInfoWithEmptyFields extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "PA014 Save payment info with empty fields")
    public void PA014_SavePaymentInfoWithEmptyFieldsTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickPaymentInfoTab()
                .clickSavePaymentInfo()
                .errorMessageCardNumberInputIsDisplayed()
                .enterCardNumber("4242424242424242")
                .clickSavePaymentInfo()
                .errorMessageCardNumberInputNotDisplayed()
                .errorMessagePaymentSystemInputIsDisplayed()
                .selectPaymentSystem("Visa")
                .clickSavePaymentInfo()
                .errorMessagePaymentSystemInputNotDisplayed();
    }
}
