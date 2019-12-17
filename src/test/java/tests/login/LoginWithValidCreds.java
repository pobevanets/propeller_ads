package tests.login;

import org.testng.annotations.Test;
import tests.Actions;

public class LoginWithValidCreds extends Actions {

    @Test(testName = "Login with valid creds")
    public void LoginWithValidCredsTest() {
        signIn("test", "test");
    }
}
