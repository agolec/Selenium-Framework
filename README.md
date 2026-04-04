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

---

## Project Structure

```
src/
  main/
    java/
      ag/framework/
        base/          # BasePage, which all other page objects are made from
        config/        # ConfigReader and configuration logic
        driver/        # DriverFactory and browser setup
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

This framework is designed to run in CI environments:

* No hardcoded file paths
* No local driver dependencies
* Supports headless execution

---

## Future Improvements

* Jenkins pipeline integration
* Parallel test execution
* Reporting (ExtentReports / Allure)
* Cross-browser support
* Environment-based configuration

---

## Author

Your Name
