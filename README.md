# API-RestAssured-Full-E2E-Framework

This project includes the following key functionalities:

- ## Service Object Model:
  All the web services are separated into different classes and objects of these services are created during test execution
- ## Abstraction over Rest Assured API Methods:
  A `BaseService` class is used that contains wrapper methods over actual REST API method calls
- ## Builder Design Pattern:
  This pattern is used in the Request POJOs. A static inner class is defined within the Request POJO class that enables method chaining while creating request payload
- ## Log4j Loggers:
  A logger is configured in the `log4j2.xml` file that logs the test details in the Console and text File
- ## Listeners:
  A `TestListener` class is used that implements `ITestListener` interface to track the test execution and log results on Test Started/Passed/Failed/Skipped
- ## Rest Assured Filters:
  Rest Assured `Filter` interface is used. `LoggingFilter` class implements this interface and defines the abstract method - `filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx)`.
  This filter intercepts the `request` and `response` and logs the details using logger.
- ## GitHub Actions:
  This is integrated with GitHub Actions workflow
