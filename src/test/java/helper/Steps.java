package helper;

import steps.MainPageSteps;
import steps.SmallLoanCalculatorSteps;

import static com.codeborne.selenide.Selenide.page;

public interface Steps {

    SmallLoanCalculatorSteps smallLoanCalculatorSteps = page(SmallLoanCalculatorSteps.class);
    MainPageSteps mainPageSteps = page(MainPageSteps.class);
}
