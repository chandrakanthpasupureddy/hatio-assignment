# 🌍 Currency Converter API

A Spring Boot REST API for currency conversion. It provides real-time exchange rates and allows users to convert amounts between different currencies.

## 🚀 Features
- Fetch exchange rates for a base currency.
- Convert an amount from one currency to another.
- Handles errors gracefully with proper exception handling.

## 🛠️ Tech Stack
- **Spring Boot** (REST API)
- **Java 17+**
- **Lombok** (for reducing boilerplate code)
- **Maven** (for dependency management)
- **Postman** (for API testing)

---

## 📂 Project Structure
currency-converter
│── src/main/java/com/example/currencyconverter
│   ├── controller
│   │   ├── CurrencyController.java
│   ├── dto
│   │   ├── ConversionRequest.java
│   │   ├── ConversionResponse.java
│   ├── exception
│   │   ├── CurrencyConversionException.java
│   │   ├── GlobalExceptionHandler.java
│   ├── service
│   │   ├── CurrencyService.java
│   ├── CurrencyConverterApplication.java
│── src/main/resources
│   ├── application.properties
