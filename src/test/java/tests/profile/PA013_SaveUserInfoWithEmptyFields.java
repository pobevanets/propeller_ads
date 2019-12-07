package tests.profile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class PA013_SaveUserInfoWithEmptyFields extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "PA013 Save user info with empty fields")
    public void PA013_SaveUserInfoWithEmptyFieldsTest() {
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
