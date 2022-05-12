package tests;

import core.Settings;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Small Loan Calculator")
@Story("Check new features for small loan calculator")
public class SmallLoanCalculatorTest extends Settings {

    @Test(description = "Test-case #1: Check that “Choose loan sum” slider works correctly", groups = "Small Loan Calculator")
    public void checkChooseLoanSumSlider() {
        mainPage.goToSmallLoanPage();
        smallLoanPage.changeLoanSumSliderPosition(100);

        String sumOverSlider = smallLoanPage.loanSumOverSlider.getText();
        String sumInRightField = smallLoanPage.loanSumField.getValue();

        Assert.assertEquals(sumOverSlider, sumInRightField);
    }

    @Test(description = "Test-case #2: Check that you cannot type more than 20 000 in “Choose loan sum” field", groups = "Small Loan Calculator")
    public void checkLoanSumFieldCapacity() {
        mainPage.goToSmallLoanPage();
        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, "21000");
        smallLoanPage.monthlyPaymentField.click();

        Assert.assertNotEquals(smallLoanPage.loanSumField.getValue(), "21000 €");
        Assert.assertTrue(smallLoanPage.loanSumField.getValue().contains("20000 €"));
    }

    @Test(description = "Test-case #3: Check that you cannot type 0 in “Choose loan sum” field", groups = "Small Loan Calculator")
    public void checkZeroInLoanSumField() {
        mainPage.goToSmallLoanPage();
        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, "0");
        smallLoanPage.monthlyPaymentField.click();

        Assert.assertNotEquals(smallLoanPage.loanSumField.getValue(), "0 €");
        Assert.assertTrue(smallLoanPage.loanSumField.getValue().contains("300 €"));
    }

    @Test(description = "Test-case #4: Check that monthly payment changes when you change loan sum", groups = "Small Loan Calculator")
    public void checkThatMonthlyPaymentChanges() {
        mainPage.goToSmallLoanPage();

        String monthlyPaymentBeforeAction = smallLoanPage.monthlyPaymentField.getText();

        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, "20000");
        smallLoanPage.monthlyPaymentField.click();

        String monthlyPaymentAfterAction = smallLoanPage.monthlyPaymentField.getText();

        Assert.assertNotEquals(monthlyPaymentBeforeAction, monthlyPaymentAfterAction);
    }

    @Test(description = "Test-case #5: Check that “Choose loan term” slider works correctly", groups = "Small Loan Calculator")
    public void checkThatLoanTermSliderWorks() {
        mainPage.goToSmallLoanPage();

        Integer monthlyPaymentBeforeAction = Integer.parseInt(smallLoanPage.monthlyPaymentField.getText());

        smallLoanPage.changeLoanTermSliderPosition(500);

        Integer monthlyPaymentAfterAction = Integer.parseInt(smallLoanPage.monthlyPaymentField.getText());

        Assert.assertNotEquals(monthlyPaymentBeforeAction, monthlyPaymentAfterAction);
        Assert.assertTrue(monthlyPaymentBeforeAction > monthlyPaymentAfterAction);
    }

    @Test(description = "Test-case #6: Check that “Agreement fee” changes correctly", groups = "Small Loan Calculator")
    public void checkThatAgreementFeeChanges() {
        mainPage.goToSmallLoanPage();

        Integer agreementFeeBeforeAction = Integer.parseInt(smallLoanPage.agreementFeeField.getText());

        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, "20000");
        smallLoanPage.monthlyPaymentField.click();

        Integer agreementFeeAfterAction = Integer.parseInt(smallLoanPage.agreementFeeField.getText());

        Assert.assertNotEquals(agreementFeeBeforeAction, agreementFeeAfterAction);
        Assert.assertTrue(agreementFeeBeforeAction < agreementFeeAfterAction);
        Assert.assertTrue(agreementFeeAfterAction.equals(300));
    }

    @Test(description = "Test-case #7: Check that slider moves when you change loan sum manually", groups = "Small Loan Calculator")
    public void checkSumOverSliderAfterMove() {
        mainPage.goToSmallLoanPage();

        String sumOverSliderBeforeAction = smallLoanPage.loanSumOverSlider.getText();

        smallLoanPage.loanSumField.doubleClick().sendKeys(Keys.BACK_SPACE, "10000");
        smallLoanPage.monthlyPaymentField.click();

        String sumOverSliderAfterAction = smallLoanPage.loanSumOverSlider.getText();

        Assert.assertEquals(sumOverSliderAfterAction, "10000 €");
        Assert.assertNotEquals(sumOverSliderBeforeAction, sumOverSliderAfterAction);
    }
}
