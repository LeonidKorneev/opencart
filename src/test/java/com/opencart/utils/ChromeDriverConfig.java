package com.opencart.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverConfig {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
 /*       options.addArguments("--headless"); // Запуск без интерфейса
        options.addArguments("--disable-gpu"); // Отключение GPU-рендеринга
        options.addArguments("--no-sandbox"); // Избегает проблем с правами доступа
        options.addArguments("--disable-dev-shm-usage"); // Решает проблему с памятью в Docker
        options.addArguments("--remote-allow-origins=*"); // Избегает CORS-ошибок
        options.addArguments("--disable-extensions"); // Отключает расширения
        options.addArguments("--disable-popup-blocking"); // Отключает блокировку всплывающих окон
        options.addArguments("--disable-infobars"); // Отключает инфопанель Chrome*/
        options.addArguments("--incognito"); // Запускает браузер в режиме инкогнито
        options.addArguments("--window-size=1920,1080");
        options.setAcceptInsecureCerts(true);
        return options;
    }
}

