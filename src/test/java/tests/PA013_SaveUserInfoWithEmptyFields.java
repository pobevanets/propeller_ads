package tests;

import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;

public class PA013_SaveUserInfoWithEmptyFields extends Actions {

    @Test(testName = "PA013 Save user info with empty fields")
    public void PA013_SaveUserInfoWithEmptyFieldsTest() {
        signIn("test", "test");

        MainPage mainPage = new MainPage();
        mainPage.clickAvatar();

        ProfilePage profilePage = new ProfilePage();
        profilePage.clickSaveUserInfo()
                .errorMessageFirstNameInputIsDisplayed()
                .enterFirstName("Roman")
                .clickSaveUserInfo()
                .errorMessageFirstNameInputNotDisplayed()
                .errorMessageLastNameInputIsDisplayed()
                .enterLastName("Pobevanets")
                .clickSaveUserInfo()
                .errorMessageLastNameInputNotDisplayed();
    }
}
