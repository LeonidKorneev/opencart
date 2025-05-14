package com.opencart.utils;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverConfig {

    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-headless"); // Headless режим
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        options.addArguments("-private"); // Инкогнито

        return options;
    }
}
