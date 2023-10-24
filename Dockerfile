FROM openjdk:17-alpine3.14

COPY build/libs/leiber-market-1.0.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
