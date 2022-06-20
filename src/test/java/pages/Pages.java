package pages;

import pages.MainPage;
import pages.SmallLoanPage;

import static com.codeborne.selenide.Selenide.page;

public interface Pages {

    MainPage mainPage = page(MainPage.class);
    SmallLoanPage smallLoanPage = page(SmallLoanPage.class);
}
