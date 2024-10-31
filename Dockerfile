# Stage 1: Build
FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

## Stage 2: Run
#FROM openjdk:latest
#WORKDIR /app
#COPY --from=build /app/target/subscribrVideoUploader-*.jar app.jar
#RUN ls -al /app
#EXPOSE 9000
#ENTRYPOINT ["java", "-jar", "/app.jar"]

FROM openjdk:21
ARG JAR_FILE=target/*.jar
COPY ./target/subscribrVideoUploader-*.jar app.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]
