package tests;

import org.testng.annotations.Test;

public class PA001_LoginWithValidCreds extends Actions {

    @Test(testName = "PA001 Login with valid creds", groups = {"full", "smoke"})
    public void PA001_LoginWithValidCredsTest() {
        signIn("test", "test");
    }
}
