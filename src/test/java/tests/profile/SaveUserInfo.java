package tests.profile;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.ProfilePage;
import tests.Actions;

import static org.testng.Assert.*;

public class SaveUserInfo extends Actions {
    String firstName = "Roman";
    String lastName = "Pobevanets";

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Save user info")
    public void SaveUserInfoTest() {
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
        assertEquals(profilePage.getHighlightedText(), firstName, "First name is not as expected!");
        assertTrue(profilePage.isFirstNameSavedInCookies(firstName), "First Name is NOT saved in cookies!");

        profilePage.selectTextInLastNameInput();
        assertEquals(profilePage.getHighlightedText(), lastName, "Last name is not as expected!");
        assertTrue(profilePage.isLastNameSavedInCookies(lastName), "Last Name is NOT saved in cookies!");
    }
}
