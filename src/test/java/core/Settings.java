package core;

import com.codeborne.selenide.WebDriverRunner;
import helper.ApiHelper;
import pages.Pages;
import steps.Steps;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class Settings implements Pages, Steps {

    public static ConfigData configData = ConfigData.readFileDataConfig();

    @BeforeMethod(alwaysRun = true)
    public static void webDriverSetup() {
        if (ApiHelper.getWebSiteAvailability(configData.host)) {
            BaseDriver.setParameters();
            open(configData.host);
            mainPageSteps.setLanguage();
        } else {
            System.out.println("Website is unavailable");
        }
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @AfterMethod(alwaysRun = true)
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        byte[] screen = ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        return screen;
    }
}
