package tests.profile;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class PA011_SaveUserInfo extends Actions {
    String firstName = "Roman";
    String lastName = "Pobevanets";

    @Test(testName = "PA011 Save user info")
    public void PA011_SaveUserInfoTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.enterFirstName(firstName)
                .enterLastName(lastName)
                .clickSaveUserInfo()
                .successUserInfoSaveNotificationIsDisplayed();

        mainPage.openMainPage()
                .clickAvatar();

        profilePage.selectTextInFirstNameInput();
        Assert.assertEquals(profilePage.getHighlightedText(), firstName,
                "First name is not as expected!");

        profilePage.selectTextInLastNameInput();
        Assert.assertEquals(profilePage.getHighlightedText(), lastName,
                "Last name is not as expected!");
    }
}
