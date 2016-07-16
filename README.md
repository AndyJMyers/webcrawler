# webcrawler programming test Andy Myers

This is a Java 8 Spring Boot application exposing its single API as a REST endpoint.
The top level for exploring the code base is the REST controller WebCrawlerController

## Build and Test

To build and test:
mvn clean install

To run: 
mvn spring-boot:run

To manually test in a browser:
http://localhost:8080/webcrawler?url=http://www.dilbert.com/ 


## Assumptions and Notes

Using Jsoup for basic get and parsing of websites, this is used by Google's OpenRefine data-wrangling tool amongst others

A basic suite of JUnit/Mockito unit tests is provided, given time this would be expanded. At the moment there are no end to end or integration tests, I would propose writing these in Cucumber.

Checkstyle has been added to perform static analysis to improve code quality.