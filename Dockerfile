FROM maven:3.8.4-openjdk-11 AS builder
RUN apk add --no-cache maven
VOLUME /tmp
# Ejecuta el comando 'mvn package'
RUN mvn package
COPY --from=builder target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
