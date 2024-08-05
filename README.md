# Restful API Market
### _This is an API for the basic operation of a Super Market_:
![Static Badge](https://img.shields.io/badge/version-1.0-brightgreen)
![Static Badge](https://img.shields.io/badge/Java-21-brightgreen)
![Static Badge](https://img.shields.io/badge/Spring-3.2-brightgreen)

## Running the API with Docker 🚀
To run the API using Docker, follow these steps:

1. **Clone the Repository** (if you haven't already):

   ```bash
   git clone https://github.com/leiberbertel/Java-Market-API.git
   cd Java-Market

2. **Build the Docker Image**: <br>
Make sure Docker is installed on your machine. Build the Docker image with:
   ```bash
   docker build -t Java-Market
   ```
3. **Run the Docker Container**: <br>
After building the image, run the container with:
    ```bash
    docker run -p 8080:8080 Java-Market
    ```
4. **Access Swagger UI**: <br>
Once the container is running, you can view the Swagger UI documentation at http://localhost:8080/swagger-ui/index.html#/.

## Running the API Without Docker 🚀
To run the API, you will need JDK version 17 installed on your machine.
[Download it here:](https://adoptium.net/es/temurin/releases/?version=17)

1. **Clone the repository** (if you haven't already):
    ```bash
    git clone https://github.com/leiberbertel/Java-Market-API.git
    cd Java-Market
    ```

2. **Build and Run the Application:** <br>
    ```bash
    ./gradlew build
    ./gradlew bootRun
    ```

    **On OS windows**:
    ```bash
    gradlew.bat build
    gradlew.bat bootRun
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
