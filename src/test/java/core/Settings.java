package core;

import com.codeborne.selenide.WebDriverRunner;
import helper.Pages;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class Settings implements Pages {

    @BeforeClass(alwaysRun = true)
    public static void webDriverSetup() {
        BaseDriver.setParameters();
    }

    @SneakyThrows
    @BeforeMethod(alwaysRun = true)
    public static void goToMainPage() {
        open("https://www.swedbank.ee/");
        Thread.sleep(3000);
        mainPage.setLanguage();
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

}
