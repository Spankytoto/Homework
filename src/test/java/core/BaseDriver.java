package core;

import com.codeborne.selenide.Configuration;
import helper.CommonPages;

public class BaseDriver implements CommonPages {

    public static void setParameters() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
    }
}

