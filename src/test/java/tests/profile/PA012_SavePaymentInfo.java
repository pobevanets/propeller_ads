package tests.profile;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class PA012_SavePaymentInfo extends Actions {

    @Test(testName = "PA012 Save payment info")
    public void PA012_SavePaymentInfoTest() {
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
