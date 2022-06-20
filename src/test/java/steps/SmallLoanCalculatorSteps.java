package steps;

import helper.Pages;
import helper.RegexpHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.actions;

public class SmallLoanCalculatorSteps implements Pages {

    @Step("Change the loan sum slider position")
    public void changeLoanSumSliderPosition(int value) {
        actions()
                .moveToElement(smallLoanPage.loanSumSlider)
                .clickAndHold()
                .moveByOffset(value, 0)
                .release()
                .perform();
    }

    @Step("Change the loan term slider position")
    public void changeLoanTermSliderPosition(int value) {
        actions()
                .moveToElement(smallLoanPage.loanTermSlider)
                .clickAndHold()
                .moveByOffset(value, 0)
                .release()
                .perform();
    }

    @Step("Compare sum over slider and in field")
    public void compareSumOverSliderAndInField() {
        String sumOverSlider = smallLoanPage.loanSumOverSlider.getText();
        String sumInRightField = smallLoanPage.loanSumField.getValue();

        Assert.assertEquals(sumOverSlider, sumInRightField);
    }

    @Step("Type sum into 'Choose loan sum' field")
    public void fillLoanSum(String sum) {
        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, sum);
        smallLoanPage.monthlyPaymentField.click();
    }

    @Step("Check that max value of loan sum field is 20000")
    public void checkMaxValueInLoanSumField(Integer sum) {
        Assert.assertNotEquals(RegexpHelper.extractInteger(smallLoanPage.loanSumField.getValue()), sum);
        Assert.assertTrue(smallLoanPage.loanSumField.getValue().contains("20000"));
    }

    @Step("Check that min value of loan sum field is 300")
    public void checkMinValueInLoanSumField(Integer sum) {
        Assert.assertNotEquals(RegexpHelper.extractInteger(smallLoanPage.loanSumField.getValue()), sum);
        Assert.assertTrue(smallLoanPage.loanSumField.getValue().contains("300"));
    }

    @Step("Get agreement fee value")
    public Integer getAgreementFeeValue() {
        return Integer.parseInt(smallLoanPage.agreementFeeField.getText());
    }

    @Step("Get monthly payment sum")
    public Integer getMonthlyPaymentSum() {
        return Integer.parseInt(smallLoanPage.monthlyPaymentField.getText());
    }

    @Step("Get sum over slider")
    public Integer getLoanSumOverSlider() {
        return RegexpHelper.extractInteger(smallLoanPage.loanSumOverSlider.getText());
    }

    @Step("Check that monthly payment sum has been changed")
    public void checkMonthlyPaymentSumAfterAction(Integer monthlyPaymentBeforeAction, Integer monthlyPaymentAfterAction) {
        Assert.assertNotEquals(monthlyPaymentBeforeAction, monthlyPaymentAfterAction);
    }

    @Step("Check that agreement fee has been changed")
    public void checkAgreementFeeAfterAction(Integer agreementFeeBeforeAction, Integer agreementFeeAfterAction) {
        Assert.assertNotEquals(agreementFeeBeforeAction, agreementFeeAfterAction);
        Assert.assertTrue(agreementFeeBeforeAction < agreementFeeAfterAction);
        Assert.assertTrue(agreementFeeAfterAction.equals(300));
    }

    @Step("Compare values over slider action")
    public void checkValuesOverSlider(Integer sliderSumBeforeAction, Integer sliderSumAfterAction, Integer sum) {
        Assert.assertEquals(sliderSumAfterAction, sum);
        Assert.assertNotEquals(sliderSumBeforeAction, sliderSumAfterAction);
    }
}
