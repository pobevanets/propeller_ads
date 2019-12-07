package tests.profile;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class PA012_SavePaymentInfo extends Actions {
    String cardNumber = "4242424242424242";
    String paymentSystem = "Visa";
    int paymentDay = 19;

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "PA012 Save payment info")
    public void PA012_SavePaymentInfoTest() {
        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickPaymentInfoTab()
                .enterCardNumber(cardNumber)
                .selectPaymentSystem(paymentSystem)
                .selectPaymentDay(paymentDay)
                .clickSavePaymentInfo()
                .successPaymentInfoSaveNotificationIsDisplayed();

        mainPage.openMainPage()
                .clickAvatar();

        profilePage.clickPaymentInfoTab()
                .selectTextInCardNumberInput();
        Assert.assertEquals(profilePage.getHighlightedText(), cardNumber, "Card Number is not as expected!");
        Assert.assertEquals(profilePage.getSelectedPaymentSystem(), paymentSystem, "Payment System is not as expected!");
        Assert.assertEquals(profilePage.getSelectedPaymentDay(), paymentDay, "Payment Day is not as expected!");
    }
}
