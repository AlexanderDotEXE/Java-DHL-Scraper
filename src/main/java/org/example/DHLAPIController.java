package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.*;

import java.io.IOException;
import java.time.Duration;

@RestController
@RequestMapping("/api")
public class DHLAPIController {
    private final WebDriverPool webDriverPool;

    @Autowired
    public DHLAPIController(WebDriverPool webDriverPool) {
        this.webDriverPool = webDriverPool;
    }

    @GetMapping("/sendungsverfolgung/{trackingNumber}")
    public String getSendungsverfolgung(@PathVariable String trackingNumber) throws IOException {
        WebDriver driver = webDriverPool.getWebDriver();
        try {
            final String url = "https://www.dhl.de/de/privatkunden/pakete-empfangen/verfolgen.html?piececode=" + trackingNumber;

            driver.get(url);

            By spanLocator = By.className("infoText");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));

            WebElement infoText = wait.until(ExpectedConditions.visibilityOfElementLocated(spanLocator));
            return infoText.getText();
        } finally {
            webDriverPool.returnWebDriver(driver);
        }
    }
}

