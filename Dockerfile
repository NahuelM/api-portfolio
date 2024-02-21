FROM eclipse-temurin:17-jdk-alpine
RUN apk add --no-cache maven
VOLUME /tmp
# Ejecuta el comando 'mvn package'
RUN mvn package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
