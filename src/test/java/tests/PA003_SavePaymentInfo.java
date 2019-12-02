package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class PA003_SavePaymentInfo extends Actions {

    @Test(testName = "PA003 Save payment info")
    public void PA003_SavePaymentInfoTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickPaymentInfoTab()
                .enterCardNumber("4242424242424242")
                .selectPaymentSystem("Visa")
                .selectPaymentDay(19)
                .clickSavePaymentInfo()
                .successPaymentInfoSaveNotificationIsDisplayed();
    }
}
