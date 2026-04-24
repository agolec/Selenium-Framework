# Selenium Automation Framework

## Overview

This project is a Selenium-based UI automation framework built using **Java, Maven, and TestNG**.

It is designed with scalability and maintainability in mind, following standard automation architecture patterns such as separation of concerns between test logic, data handling, and configuration.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Chrome (via Selenium Manager)
* Docker (for CI environment)
* Jenkins (CI/CD)

---

## Project Structure

```
docker/                 # Contains the Dockerfile for this project to the Jenkins CI container
src/            
  main/
    java/
      ag/framework/
        base/          # BasePage, which all other page objects are made from
        config/        # ConfigReader and configuration logic
        driver/        # DriverFactory BrowserType, and browser setup
        enums/       
        utils/         # Test data models (POJOs), and wait utilities for the driver.
      resources/       # Configuration files
  test/
    java/
      ag/framework/
        tests/         # Test classes (e.g. LoginTest)
        base/          # BaseTest setup/teardown
        utils/         # DataProviders for use in Test classes
    resources/
      config.properties
```

---

## Key Design Concepts

### 1. Separation of Concerns

* `main` → framework code (reusable, no test annotations)
* `test` → test execution layer (TestNG, DataProviders)

### 2. Driver Management

* Uses **Selenium Manager** (no manual driver setup required)
* No hardcoded driver paths

### 3. Configuration Management

* Config loaded via classpath (`config.properties`)
* Avoids filesystem dependencies for CI compatibility

### 4. Data-Driven Testing

* Test data modeled as objects (e.g. `LoginTestData`)
* TestNG `@DataProvider` used for parameterized tests

---

## How to Run Tests

### Run all tests

```
mvn clean test
```

### Run specific group

```
mvn clean test -Dgroups=smoke
```

---

## Configuration

Located at:

```
src/test/resources/config.properties
```

Example:

```
browser=chrome
headless=false
```

---

## Headless Execution

Headless mode can be enabled via:

```
mvn clean test -Dheadless=true
```

This is required for CI environments such as Jenkins.

---

## CI/CD Considerations

This framework is designed for execution in CI environments:

* No hardcoded file paths
* No local driver dependencies (uses Selenium Manager)
* Supports headless execution for containerized environments
* Environment-specific behavior controlled via Java system properties
* Compatible with Linux-based execution (Docker/Jenkins)

---
## CI Execution (Docker + Jenkins)
This setup resolves environment parity issues between local development (Windows) and CI execution (Linux) by externalizing configuration via runtime parameters.

Note: The Chromium binary path is provided at runtime to support Linux-based execution environments.

This framework is designed to run in a fully containerized CI environment.

### Jenkins Setup (Docker)

A custom Jenkins image is used to support Selenium execution in a Linux environment:

- Installs Chromium browser
- Enables headless execution
- Supports Maven-based test execution
### Build Jenkins Image
```bash
docker build -t jenkins-with-chrome -f docker/jenkins.Dockerfile .
```
---
### Run Jenkins
```bash
docker run -p 8080:8080 -p 50000:50000 jenkins-with-chrome 
```
### Test Execution

Tests are executed via Jenkins using runtime parameters: 
```
mvn clean test \
    -Dgroups=smoke \
    -Dheadless=true \
    -Dchrome.binary=/usr/bin/chromium-browser
```
### Key CI Features

- Parameterized test execution (TestNG groups)
- Headless browser support for containerized environments
- Environment-specific configuration via Java system properties
- Fully reproducible CI environment via Docker

## Future Improvements

* Parallel test execution
* Reporting (ExtentReports / Allure)
* Cross-browser support
* Environment-based configuration

---

## Achievements

* Built a containerized CI pipeline using Jenkins and Docker
* Enabled headless Selenium execution in a Linux-based environment
* Implemented runtime configuration using Java system properties (`-Dheadless`, `-Dchrome.binary`)
* Supported dynamic test execution via TestNG groups (smoke/regression)
* Ensured cross-environment compatibility (local Windows vs CI Linux)

## Author

Adam Golec
