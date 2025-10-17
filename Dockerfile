FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y \
    openjdk-17-jdk \
    firefox \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Download and install geckodriver
RUN wget https://github.com/mozilla/geckodriver/releases/download/v0.30.0/geckodriver-v0.30.0-linux64.tar.gz \
    && tar -xzf geckodriver-v0.30.0-linux64.tar.gz -C /usr/local/bin \
    && rm geckodriver-v0.30.0-linux64.tar.gz

# Copy the Spring Boot JAR file into the working directory in the container
COPY target/DHL-Scraper-1.0-SNAPSHOT.jar /app/DHL-Scraper.jar

WORKDIR /app

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "DHL-Scraper.jar"]
