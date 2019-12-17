package tests.profile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

public class SaveUserInfoWithEmptyFields extends Actions {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Save user info with empty fields")
    public void SaveUserInfoWithEmptyFieldsTest() {
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
