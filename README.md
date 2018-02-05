# part-inventory

Simple Spring Boot based CRUD for parts and compatibility between them.

## Requirements

- Maven
- either standalone PostgreSQL database or Docker with docker-compose
- JDK8

## Setup

Copy `src/main/resources/application-dev.properties.example` to `src/main/resources/application-dev.properties`.
Modify database credentials to match yours.

If you're using Docker for database, copy `.env-example` to `.env` and change database credentials to match
those in `application-dev.properties`.

## Running

### Database

If you're using Docker, start the database container first.

```bash
docker-compose -f docker-compose.db.yml up
```

### Application

You can either run it as a Spring Boot application:

```bash
mvn spring-boot:run
```

Or build the jar file and run it either as a stand-alone Java application or from Tomcat.

```bash
mvn clean install
java -jar target/inventory-0.0.1-SNAPSHOT.jar
```

The application will by default bind to port 8080 - http://localhost:8080 .

Endpoints aren't secured.

## Swagger

There's a Swagger instance for API listing and testing at http://localhost:8080/swagger-ui.html .

## Licence

MIT