FROM maven:3.8.4-openjdk-11 AS builder
VOLUME /tmp
# Ejecuta el comando 'mvn package'
RUN mvn package
FROM openjdk:11-jre-slim
COPY --from=builder target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
