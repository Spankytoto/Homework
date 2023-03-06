package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//*[@id='language-bar']")
    public SelenideElement languageBar;

    @FindBy(xpath = "//*[@class='button ui-cookie-consent__accept-button']")
    public SelenideElement acceptAllCookiesButton;

    @FindBy(xpath = "(//span[text()='ENG'])[2]")
    public SelenideElement switchToEnglishButton;

    @FindBy(xpath = "//*[text()='Loan, leasing']")
    public SelenideElement mainMenuLoanLeasingButton;

    @FindBy(xpath = "//*[text()='Small loan']")
    public SelenideElement smallLoanSubMenu;
}
