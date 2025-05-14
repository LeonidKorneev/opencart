package com.opencart.utils;

import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverConfig {
    public static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Без интерфейса
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        options.addArguments("--inprivate"); // Инкогнито режим (у Edge это "InPrivate")
        options.addArguments("--window-size=1920,1080");
        return options;
    }

}
