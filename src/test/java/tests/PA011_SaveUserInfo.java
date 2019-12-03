package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class PA011_SaveUserInfo extends Actions {

    @Test(testName = "PA011 Save user info")
    public void PA011_SaveUserInfoTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.enterFirstName("Roman")
                .enterLastName("Pobevanets")
                .clickSaveUserInfo()
                .successUserInfoSaveNotificationIsDisplayed();
    }
}
