package tests.articles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import tests.Actions;

public class VerifyTextsFromPageAndFromFileMatch extends Actions {
    SoftAssert softAssert = new SoftAssert();

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        signInWithCookies();
    }

    @Test(testName = "Verify texts from page and from file match")
    public void VerifyTextsFromPageAndFromFileMatchTest() {
        compareTextsFromPageAndFile("test_advert/test_advert.txt", "test_advert/test_advert_file_data.txt");
        compareTextsFromPageAndFile("adidas/adidas.txt", "adidas/adidas_file_data.txt");
        compareTextsFromPageAndFile("youtube/youtube.txt", "youtube/youtube_file_data.txt");
        compareTextsFromPageAndFile("instagram/instagram.txt", "instagram/instagram_file_data.txt");
        compareTextsFromPageAndFile("john_snow/john_snow.txt", "john_snow/john_snow_file_data.txt");
        compareTextsFromPageAndFile("artur_fleck/artur_fleck.txt", "artur_fleck/artur_fleck_file_data.txt");
        compareTextsFromPageAndFile("tim_cook/tim_cook.txt", "tim_cook/tim_cook_file_data.txt");
        compareTextsFromPageAndFile("bugs_bunny/bugs_bunny.txt", "bugs_bunny/bugs_bunny_file_data.txt");
        compareTextsFromPageAndFile("sasha_gray/sasha_gray.txt", "sasha_gray/sasha_gray_file_data.txt");
        compareTextsFromPageAndFile("you/you.txt", "you/you_file_data.txt");
        compareTextsFromPageAndFile("leonel_messi/leonel_messi.txt", "leonel_messi/leonel_messi_file_data.txt");
        compareTextsFromPageAndFile("tony_stark/tony_stark.txt", "tony_stark/tony_stark_file_data.txt");
        compareTextsFromPageAndFile("elon_musk/elon_musk.txt", "elon_musk/elon_musk_file_data.txt");
        compareTextsFromPageAndFile("darth_vader/darth_vader.txt", "darth_vader/darth_vader_file_data.txt");
        softAssert.assertAll();
    }

    private void compareTextsFromPageAndFile(String urlPage, String urlFile) {
        MainPage mainPage = new MainPage();
        mainPage.openUrl("data/" + urlPage);
        String textFromThePage = mainPage.getBodyText();

        mainPage.openUrl("data/" + urlFile);
        String textFromTheFile = mainPage.getBodyText();

        softAssert.assertEquals(textFromThePage, textFromTheFile, "Texts from the page " + urlPage + " and from the file mismatch!");
    }
}
