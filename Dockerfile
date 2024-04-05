FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Copy the Spring Boot JAR file into the working directory in the container
COPY target/DHL-Scraper-1.0-SNAPSHOT.jar /app/DHL-Scraper.jar

WORKDIR /app

# Expose the port on which your Spring Boot application runs
EXPOSE 8080

# Command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "/DHL-Scraper.jar"]
