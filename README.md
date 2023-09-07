# Patronus Service

### Prerequisites

This repository was builded using the following technologies:

* Java SDK 17
* Spring Boot 2.7.13
* Gradle 8.1.1

Having the JDK 11, Docker, Docker compose are mandatory to be able to build and run the App.

### Build

* Clone the project
* Navigate to the root directory of the project
* Execute the command `./gradlew clean build`


### Running

First:
* The JAR file will be located in the `./build/libs` folder. There will be two `.jar` files:
    * `patronus-service-1.0.0.jar` stand alone `jar` with all dependencies included.
    * `patronus-service-1.0.0-plain.jar` skim `jar` without dependencies, used as external dependency.
* To run the JAR, use the following command in a console `java -jar .\patronus-service-1.0.0.jar`.

Alternative:
* Navigate to the root directory of the project
* Execute the command `docker compose build`
* Execute the command `docker compose up -d`

### Test

* Navigate to the root directory of the project
* Execute the command `./gradlew clean test`

### Usage

* The app will deploy by default in the `port:8080` so please make sure to have it free or change it
  before compilation inside the `application.yml` config file.
