package core;

import com.codeborne.selenide.WebDriverRunner;
import helper.CommonPages;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class Hook implements CommonPages {

    @BeforeClass(alwaysRun = true)
    public static void webDriverSetup() {
        BaseDriver.setParameters();
    }

    @BeforeMethod(alwaysRun = true)
    public static void goToMainPage() {
        open("https://www.swedbank.ee/");
        mainPage.acceptAllCookiesButton.click();
        mainPage.languageBar.click();
        mainPage.switchToEnglishButton.click();
    }

    @AfterMethod(alwaysRun = true)
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }


}
