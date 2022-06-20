package core;

import com.codeborne.selenide.Configuration;
import pages.Pages;

public class BaseDriver extends Settings {

    public static void setParameters() {
        Configuration.browser = configData.browser;
        Configuration.headless = configData.headless;
        Configuration.startMaximized = configData.startMaximized;
        Configuration.browserSize = configData.browserSize;
        Configuration.reportsFolder = configData.reportFolder;
    }
}

