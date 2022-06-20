package steps;

import com.codeborne.selenide.Condition;
import pages.Pages;
import io.qameta.allure.Step;

import java.time.Duration;

public class MainPageSteps implements Pages {

    @Step("Switch language to English")
    public void setLanguage () {
        mainPage.acceptAllCookiesButton.should(Condition.enabled, Duration.ofSeconds(60)).click();
        mainPage.languageBar.click();
        mainPage.switchToEnglishButton.click();
    }

    @Step("Go to small loan page")
    public void goToSmallLoanPage () {
        mainPage.mainMenuLoanLeasingButton.click();
        mainPage.smallLoanSubMenu.click();
    }
}
