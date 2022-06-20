package tests;

import core.Retry;
import core.Settings;
import helper.RandomHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Feature("Small Loan Calculator")
@Story("Check new features for small loan calculator")
public class SmallLoanCalculatorTest extends Settings {

    @BeforeMethod
    public void goSmallLoanPage () {
        mainPageSteps.goToSmallLoanPage();
    }

    @Test(description = "Test-case #1: Check that “Choose loan sum” slider works correctly", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkChooseLoanSumSlider() {
        smallLoanCalculatorSteps.changeLoanSumSliderPosition(RandomHelper.getRandomNumber(50, 500));
        smallLoanCalculatorSteps.compareSumOverSliderAndInField();
    }

    @Test(description = "Test-case #2: Check that you cannot type more than 20 000 in “Choose loan sum” field", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkLoanSumFieldCapacity() {
        Integer sum = RandomHelper.getRandomNumber(21000, 100000);

        smallLoanCalculatorSteps.fillLoanSum(sum);
        smallLoanCalculatorSteps.checkMaxValueInLoanSumField(sum);
    }

    @Test(description = "Test-case #3: Check that you cannot get 0 Euro for loan", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkZeroInLoanSumField() {
        smallLoanCalculatorSteps.fillLoanSum(0);
        smallLoanCalculatorSteps.checkMinValueInLoanSumField(0);
    }

    @Test(description = "Test-case #4: Check that monthly payment changes when you change loan sum", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkThatMonthlyPaymentChanges() {
        Integer sum = RandomHelper.getRandomNumber(300, 20000);
        Integer beforeAction = smallLoanCalculatorSteps.getMonthlyPaymentSum();

        smallLoanCalculatorSteps.fillLoanSum(sum);

        Integer afterAction = smallLoanCalculatorSteps.getMonthlyPaymentSum();

        smallLoanCalculatorSteps.checkMonthlyPaymentSumAfterAction(beforeAction, afterAction);
    }

    @Test(description = "Test-case #5: Check that “Choose loan term” slider works correctly", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkThatLoanTermSliderWorks() {
        Integer beforeAction = smallLoanCalculatorSteps.getMonthlyPaymentSum();

        smallLoanCalculatorSteps.changeLoanTermSliderPosition(RandomHelper.getRandomNumber(50, 500));

        Integer afterAction = smallLoanCalculatorSteps.getMonthlyPaymentSum();

        smallLoanCalculatorSteps.checkMonthlyPaymentSumAfterAction(beforeAction, afterAction);
    }

    @Test(description = "Test-case #6: Check that “Agreement fee” changes correctly", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkThatAgreementFeeChanges() {
        Integer sum = RandomHelper.getRandomNumber(300, 20000);
        Integer beforeAction = smallLoanCalculatorSteps.getAgreementFeeValue();

        smallLoanCalculatorSteps.fillLoanSum(sum);

        Integer afterAction = smallLoanCalculatorSteps.getAgreementFeeValue();

        smallLoanCalculatorSteps.checkAgreementFeeAfterAction(beforeAction, afterAction);
    }

    @Test(description = "Test-case #7: Check that slider moves when you change loan sum manually", groups = "Small Loan Calculator", retryAnalyzer = Retry.class)
    public void checkSumOverSliderAfterMove() {
        Integer sum = RandomHelper.getRandomNumber(300, 20000);
        Integer sumOverSliderBeforeAction = smallLoanCalculatorSteps.getLoanSumOverSlider();

        smallLoanCalculatorSteps.fillLoanSum(sum);

        Integer sumOverSliderAfterAction = smallLoanCalculatorSteps.getLoanSumOverSlider();

        smallLoanCalculatorSteps.checkValuesOverSlider(sumOverSliderBeforeAction, sumOverSliderAfterAction, sum);
    }
}
