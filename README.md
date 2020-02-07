# Weather Forecaster Webservice

This is a simple **ongoing project** of a Weather Forecast built with SpringBoot.

There's only one endpoint (or primitive) that will receive a POST or a GET
if it's a POST it will persist a new city if valid (by openweathermaps stardand) and if so 
the city will be stored in the database.

## How to run

- Import the project into your IDE (it's preferable to be IntelliJ)
- Install Lombok Plugin for @Getter and @Setter annotation (not necessary, I have wrote all getter and setters)
- Enable annotation process at ```Editor > Compiler > Annotation Processors```
- bootRun the application (with Gradle)

When you bootRun for the first time the application will read db.changelog-master.yaml file @
resources/db folder and create the table and it's columns automatically, so you don't need to 
worry about SQL syntax for different databases, I chose PostgreSQL, **it's the same for MongoDB, 
Liquibase and Hibernate will abstract it, check database README.md**, just because I am used to it, but it would work with MySQL or Oracle for example.

## Notes

If I had more time I would install and config Grafana or Spring Actuator to 'keep and eye' on the
server health. And also let it runnning at AWS, but my free tier is over :/

Since the microservice does not have user authentication it is stateless, or does not keep sessions,
but if auth would be need to keep it stateless I would use OAuth2 to avoid creating sessions and use 
JWT token instead.

## Doubts?
Just send me a message at rmkoszalka@gmail.com