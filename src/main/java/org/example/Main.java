package org.example;

import java.io.IOException;
import java.time.Duration;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) throws IOException {

        final String url = "https://www.dhl.de/de/privatkunden/pakete-empfangen/verfolgen.html?piececode=";

        String sendungsVerfolgungsnummer = "00340434453020967639";

        WebDriver driver = new FirefoxDriver();

        // Öffne die Website
        driver.get(url + sendungsVerfolgungsnummer);

        // Warte darauf, dass das <span> Element mit der Klasse "infoText" sichtbar ist
        By spanLocator = By.className("infoText");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));

        WebElement infoText = wait.until(ExpectedConditions.visibilityOfElementLocated(spanLocator));

        // Führe Aktionen durch, nachdem das Element gefunden wurde
        System.out.println("Das <span> Element mit der Klasse 'infoText' wurde gefunden.");

        System.out.println(infoText.getText());

        // Schließe den WebDriver
        driver.quit();
    }
}