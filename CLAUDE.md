# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java-based Selenium WebDriver automation project focused on demonstrating different wait strategies for web automation testing. The project is structured as educational examples teaching Selenium wait patterns using TestNG framework and targeting the Magento demo site.

## Build System & Dependencies

- **Build Tool**: Maven (Java 21)
- **Testing Framework**: TestNG 7.10.2
- **WebDriver**: Selenium 4.22.0 with WebDriverManager 5.9.1
- **Target Site**: https://magento.softwaretestingboard.com/

### Common Commands

```bash
# Compile the project
mvn compile

# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=LoginTest

# Clean and compile
mvn clean compile

# Package the project
mvn package
```

## Code Architecture

### Package Structure
- `section01/` - Basic wait examples and login tests
- `section02/` - Intermediate wait patterns (implicit, explicit, fluent)
- `section03/` - Advanced ExpectedConditions examples
- `*/advanced/` - More complex wait scenarios and base test patterns

### Test Patterns

**Base Test Pattern**: Use `Ex01BaseTest` class for WebDriver setup/teardown:
- Extends this class to inherit browser management
- Provides `driver` instance with 5-second implicit wait
- Automatically handles browser lifecycle

**Standalone Test Pattern**: Individual test classes with their own setup:
- Include `@BeforeMethod` and `@AfterMethod` for browser management
- Use WebDriverManager for driver setup
- Include `main()` method for direct execution

### Wait Strategy Examples

- **Implicit Wait**: Global timeout for element location
- **Explicit Wait**: WebDriverWait with ExpectedConditions
- **Fluent Wait**: Custom polling intervals and exception handling
- **Expected Conditions**: Various wait conditions (visibility, staleness, text presence)

### Test Credentials
Standard test account for Magento demo site:
- Email: `selenium.tester@gmail.com`
- Password: `qyq*nbp.zcw2apq4ZQW`

## Running Individual Examples

Most example classes include `main()` methods for direct execution. You can run specific examples either:
1. Through TestNG annotations using Maven
2. Directly via the main method in IDEs
3. Using `java -cp` with compiled classes