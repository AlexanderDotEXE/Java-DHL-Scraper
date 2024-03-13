FROM ubuntu:latest AS build
LABEL authors="cuzim"

RUN apt-get update

# Verwenden des OpenJDK-Basisimages
FROM adoptopenjdk/openjdk21:alpine-jre

# Kopieren der Spring Boot Jar-Datei in das Arbeitsverzeichnis im Container
COPY out/artifacts/DHL_Scraper_jar/DHL-Scraper.jar /app/DHL-Scraper.jar

# Port freigeben, auf dem Ihre Spring Boot-Anwendung läuft
EXPOSE 8080

# Befehl zum Ausführen der Spring Boot-Anwendung, wenn der Container gestartet wird
CMD ["java", "-jar", "/app/DHL-Scraper.jar"]


ENTRYPOINT ["top", "-b"]