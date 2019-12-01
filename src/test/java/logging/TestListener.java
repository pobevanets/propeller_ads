package logging;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener implements ITestListener {
    private String pathToImageFolder;

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        EventHandler.writeToLogAndConsole("<span style='color:green;font-weight:bold;'>Test passed!</span>");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        EventHandler.writeToLogAndConsole("<span style='color:red;font-weight:bold;'>Test failed!</span>");
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    private void takeScreenshot(){
        WebDriver driver = getWebDriver();
        if (driver == null)
            return;

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            if (pathToImageFolder == null)
                pathToImageFolder = System.clearProperty("reportsDirectory");
            String imageFileName = CurrentTime.getCurrentTimeForFileName() + ".png";
            Path imagePath = Paths.get(pathToImageFolder, imageFileName);
            FileUtils.copyFile(scrFile, new File(imagePath.toUri()));
            Reporter.log("<a href='../" + imageFileName + "'><img src='../" + imageFileName + "' style='width:50%; height:50%'/></a>");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
