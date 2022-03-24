package helper;

import pages.MainPage;
import pages.SmallLoanPage;

import static com.codeborne.selenide.Selenide.page;

public interface CommonPages {

    MainPage mainPage = page(MainPage.class);
    SmallLoanPage smallLoanPage = page(SmallLoanPage.class);
}
