package core;

import com.codeborne.selenide.Configuration;
import helper.Pages;

public class BaseDriver implements Pages {

    public static void setParameters() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.startMaximized = false;
        Configuration.browserSize = "1920x1080";
        Configuration.reportsFolder = "allure-results/reports";
    }
}

