package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        // Füge einen Shutdown Hook hinzu, um die Anwendung ordnungsgemäß zu beenden
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            WebDriverPool webDriverPool = context.getBean(WebDriverPool.class);
            if (webDriverPool != null) {
                webDriverPool.destroy();
            }
        }));
    }
}

