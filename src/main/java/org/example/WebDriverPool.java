package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.stereotype.Component;

@Component
public class WebDriverPool {
    private final int poolSize;
    private final WebDriver[] webDrivers;
    private int index = 0;

    public WebDriverPool() {
        this.poolSize = 5; // Adjust pool size as needed
        this.webDrivers = new WebDriver[poolSize];
        for (int i = 0; i < poolSize; i++) {
            webDrivers[i] = createNewWebDriver();
        }
    }

    private WebDriver createNewWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    public synchronized WebDriver getWebDriver() {
        WebDriver driver = webDrivers[index];
        index = (index + 1) % poolSize;
        return driver;
    }

    public synchronized void returnWebDriver(WebDriver driver) {
        // Reset the driver state if necessary
    }
}