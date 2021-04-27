# Build
FROM maven:3.8.1-openjdk-15 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

# Assembly
FROM openjdk:15
COPY --from=build /usr/src/app/target/*.jar /usr/app/console-app.jar
ENTRYPOINT ["java","-jar","/usr/app/console-app.jar"]