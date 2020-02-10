# Weather Forecaster Webservice

This is a simple **ongoing project** of a Weather Forecast built with SpringBoot.

There's only one endpoint (or primitive) that will receive a POST or a GET
if it's a POST it will persist a new city if valid (by openweathermaps stardand) and if so 
the city will be stored in the database.

## Endpoints

### GET 

#### /v1/cities

Will retrieve all cities stored in the database in the following array list of City objects.

```json
[
    {
        "city": "Blumenau",
        "lat": "-26.893090",
        "lng": "-49.075084"
    },
    {
        "city": "Guarapuava",
        "lat": "-25.386091",
        "lng": "-51.479243"
    },
    {
        "city": "Lages",
        "lat": "-27.859365",
        "lng": "-50.312228"
    }
]
```
#### /v1/city/{cityName}

Will retrieve one city object, if persisted in the database, by it's name.

````json
{
    "city": "Blumenau",
    "lat": "-26.893090",
    "lng": "-49.075084"
}
````


### POST

#### /v1/new

This post route will check if the city is already persisted in the database, if not will persist it and then return
a 201 code (HttpResponse.CREATED) or if find the same city already store will return a 409 code (HttpResponse.CONFLICT)^.

PS: The front-end will check if the city exists at the OpenWeatherMap database and only if it exists there will perform
this POST to the microservice, this way we can mitigate computer power and also cloud requests (meaning money).

##### Payload

````json
{
    "city": "{cityName}",
    "lat": "{cityLat}",
    "lng": "{cityLng}"
}
````

### DELETE

##### /v1/delete/{city}

Will delete specified city from database.


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