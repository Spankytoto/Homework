package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SmallLoanPage {

    @FindBy(xpath = "//*[@id='monthly-payment-result']")
    public SelenideElement monthlyPaymentField;

    @FindBy(xpath = "//*[@id='contract-fee-result']")
    public SelenideElement agreementFeeField;

    @FindBy(xpath = "(//*[@role='slider'])[1]")
    public SelenideElement loanSumSlider;

    @FindBy(xpath = "(//*[@role='slider'])[2]")
    public SelenideElement loanTermSlider;

    @FindBy(xpath = "(//input[@class='ui-slider__input'])[1]")
    public SelenideElement loanSumField;

    @FindBy(xpath = "(//*[@class='ui-slider__value'])[1]")
    public SelenideElement loanSumOverSlider;
}
