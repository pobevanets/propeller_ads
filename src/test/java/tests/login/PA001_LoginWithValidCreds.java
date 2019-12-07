package tests.login;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import tests.Actions;

public class PA001_LoginWithValidCreds extends Actions {

    @Test(testName = "PA001 Login with valid creds")
    public void PA001_LoginWithValidCredsTest() {
        signIn("test", "test");
    }
}
