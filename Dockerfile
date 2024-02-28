FROM maven:3.9.6-amazoncorretto-21
VOLUME /tmp
COPY src/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
