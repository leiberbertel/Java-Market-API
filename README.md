# Restful API Market
### _This is an API for the basic operation of a Super Market_:
![Static Badge](https://img.shields.io/badge/version-1.0-brightgreen)
![Static Badge](https://img.shields.io/badge/Java-21-brightgreen)
![Static Badge](https://img.shields.io/badge/Spring-3.2-brightgreen)

## Running the API 🚀

To run the API, you will need JDK version 17+ installed on your machine.
[Download it here:](https://adoptium.net/es/temurin/releases/?version=17)

First, clone the repository :

```bash
git clone https://github.com/leiberbertel/Java-Market-API.git
cd Java-Market
```

Next, open your command terminal and located in the project root, execute the commands:

```bash
mvn clean package
```

```bash 
java -jar target/nombre-de-tu-aplicacion.jar
```

The Spring Boot application will launch and be running on port 8080

All endpoints and schemas are documented using Swagger UI. You can view the documentation at http://localhost:8080/swagger-ui/index.html#/, which is the default endpoint for the Swagger UI.

## Built with 🛠
* Gradle - Dependency Handler
* Java version 17 - Language used
* Lombok - Tertiary dependency
* PostgreSQL - Database Engine
* Spring Framework - Framework used
* Spring Data JPA - Dependency on data manipulation
* Springdoc - Dependency on API documentation
