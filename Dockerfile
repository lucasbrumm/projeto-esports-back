#FROM maven:3.8.5-openjdk-17 AS build
#COPY . .
#RUN mvn clean package -DskipTests
#
#FROM openjdk:17.0.1-jdk-slim
#COPY --from=build /target/projetoesports-0.0.1-SNAPSHOT.jar demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "demo.jar"]

# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/projetoesports-0.0.1.jar /usr/local/lib/projetoesports.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/projetoesports.jar"]