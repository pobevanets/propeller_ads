package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class PA003_SavePaymentInfo extends Actions {

    @Test(testName = "PA002 Save payment info", groups = {"full", "smoke"})
    public void PA002_SavePaymentInfoTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickPaymentInfoTab()
                .enterCardNumber("4242424242424242")
                .selectPaymentSystem("Visa")
                //.selectDayOfPayment(16);
                .clickSavePaymentInfo()
                .successPaymentInfoSaveNotificationIsDisplayed();
    }
}
