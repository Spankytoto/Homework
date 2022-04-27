package core;

import com.codeborne.selenide.Configuration;
import helper.Pages;

public class BaseDriver implements Pages {

    public static void setParameters() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }
}

