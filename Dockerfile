FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Kopieren der Spring Boot Jar-Datei in das Arbeitsverzeichnis im Container
#COPY out/artifacts/DHL_Scraper_jar/DHL-Scraper.jar /app/DHL-Scraper.jar
COPY target/DHL-Scraper-1.0-SNAPSHOT.jar app/DHL-Scraper.jar

WORKDIR /app

# Port freigeben, auf dem Ihre Spring Boot-Anwendung läuft
EXPOSE 8080

# Befehl zum Ausführen der Spring Boot-Anwendung, wenn der Container gestartet wird
CMD ["java", "-jar", "/app/DHL-Scraper.jar"]
