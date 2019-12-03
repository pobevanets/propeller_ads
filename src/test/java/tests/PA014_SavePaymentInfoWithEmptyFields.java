package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class PA014_SavePaymentInfoWithEmptyFields extends Actions {

    @Test(testName = "PA014 Save payment info with empty fields")
    public void PA014_SavePaymentInfoWithEmptyFieldsTest() {
        signIn("test", "test");

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
