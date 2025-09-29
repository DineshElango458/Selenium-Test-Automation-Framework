
# Test Automation Framework

A robust Java-based test automation framework designed for web application testing with cloud execution capabilities and comprehensive reporting.


## Authors

- [@DineshElango458](https://github.com/DineshElango458)


## Prerequisites

Before running the tests, ensure you have the following installed:

- Java 11 or higher
- Maven 3.6 or higher
- Valid LambdaTest credentials (if running on cloud)

## Features
**Core Technologies**
- Java 11 - Primary programming language
- TestNG - Testing framework for test execution and management
- Maven - Build automation and dependency management

**Testing Capabilities**

- Data-Driven Testing with OpenCSV, GSON, and Apache POI
- Fake Data Generation using Faker library
- Cross-Browser Testing with configurable browser options
- Headless Mode for faster test execution
- Cloud Testing integration with LambdaTes


## Installation

**Clone the Repo**

git clone https://github.com/DineshElango458/Selenium-Test-Automation-Framework.git

cd Selenium-Test-Automation-Framework

**LambdaTest cloud execution:**

mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false

**Reporting & Logging**
- Extent Reports - Detailed HTML test reports
- Log4j - Comprehensive logging throughout test execution

    
