# Stage 1: Build
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

## Stage 2: Run

FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/subscribrVideoUploader-*.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]
