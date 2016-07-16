# webcrawler programming test Andy Myers

This is a Spring Boot application exposing its API as REST endpoints 

## Build and Test

To run: 
mvn spring-boot:run

To manually test in a browser:
http://localhost:8080/webcrawler?site=http://www.bbc.co.uk 


## Assumptions and Notes
Using Jsoup for basic get and parsing of websites, this is used by Google's OpenRefine data-wrangling tool amongst others
