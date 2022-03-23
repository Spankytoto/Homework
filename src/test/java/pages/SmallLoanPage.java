package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;

public class SmallLoanPage {

    @FindBy(xpath = "//*[@id='monthly-payment-result']")
    public SelenideElement monthlyPaymentField;

    @FindBy(xpath = "//*[@id='contract-fee-result']")
    public SelenideElement agreementFeeField;

    @FindBy(xpath = "//*[text()='Choose loan sum:']//..//..//button[@role='slider']")
    public SelenideElement loanSumSlider;

    @FindBy(xpath = "//*[text()='Choose loan term:']//..//..//button[@role='slider']")
    public SelenideElement loanTermSlider;

    @FindBy(xpath = "//input[@class='ui-slider__input']")
    public List<SelenideElement> loanSumField;

    public SmallLoanPage changeLoanSumSliderPosition (int value) {
        actions().moveToElement(loanSumSlider).clickAndHold().moveByOffset(value, 0).release().perform();
        return this;
    }

    public SmallLoanPage changeLoanTermSliderPosition (int value) {
        actions().moveToElement(loanTermSlider).clickAndHold().moveByOffset(value, 0).release().perform();
        return this;
    }






}
