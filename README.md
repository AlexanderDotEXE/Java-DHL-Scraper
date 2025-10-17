# Java DHL Tracking API Alternative

## 🚚 About
This project is a cost-effective alternative to the official DHL API. It was created as both a learning exercise and a practical solution for tracking DHL shipments without incurring API costs.

## 🎯 Motivation
While DHL offers a professional API for tracking shipments, the associated costs can be prohibitive for small projects or learning purposes. This project demonstrates how to:
- Build a web scraper using Selenium
- Implement a REST API with Spring Boot
- Handle concurrent requests using a WebDriver pool
- Deploy a containerized Java application

## 🛠 Technical Stack
- Java 17
- Spring Boot
- Selenium WebDriver
- Firefox (Geckodriver)
- Docker

## 🚀 Features
- RESTful API endpoint for tracking DHL shipments
- Efficient WebDriver pool management
- Headless browser operation
- Docker support for easy deployment

## 📋 Prerequisites
- Java 17 or higher
- Maven
- Firefox browser
- Docker (optional)

## 🔧 Installation

### Local Setup
1. Clone the repository:
```bash
git clone https://github.com/yourusername/Java-DHL-Scraper.git
```

2. Install dependencies:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

### Docker Setup
1. Build the Docker image:
```bash
docker build -t dhl-scraper .
```

2. Run the container:
```bash
docker run -p 8080:8080 dhl-scraper
```

## 🔍 Usage
Send a GET request to track a shipment:
```bash
curl http://localhost:8080/api/sendungsverfolgung/{tracking-number}
```

## ⚠️ Disclaimer
This project is for educational purposes only. Please be aware that:
- Web scraping might be against DHL's terms of service
- This is not an official DHL service
- For production use, consider using the official DHL API

## 📝 License
This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the issues page.

## 💡 Educational Value
This project serves as a practical example for learning:
- Web scraping techniques
- RESTful API development
- Resource pool management
- Docker containerization
- Java concurrency patterns

---
*Note: This is a learning project. For production environments, please use the official DHL API.*
