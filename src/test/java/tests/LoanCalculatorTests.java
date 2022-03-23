package tests;

import core.Hook;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoanCalculatorTests extends Hook {

    @Test
    public void newTest() {
        mainPage.goToSmallLoanPage();
        smallLoanPage.changeLoanSumSliderPosition(1000)
                     .changeLoanTermSliderPosition(1000)
                     .loanSumField.get(0).doubleClick().sendKeys(Keys.BACK_SPACE, "10000");

    }

    @Test
    public void newTest2() {
        mainPage.goToSmallLoanPage();
        smallLoanPage.changeLoanSumSliderPosition(100)
                     .changeLoanTermSliderPosition(100)
                     .loanSumField.get(0).doubleClick().sendKeys(Keys.BACK_SPACE, "10000");
        int i = 0;

    }

}
