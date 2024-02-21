# Etapa de construcción
FROM maven:3.8.4-openjdk-17 AS builder

# Establece el directorio de trabajo
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Ejecuta el comando 'mvn package'
RUN mvn package

# Etapa de producción
FROM maven:3.8.4-openjdk-17

# Copia el artefacto construido desde la imagen del 'builder'
COPY --from=builder /app/target/*.jar /app/app.jar

# Establece el comando por defecto para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Expone el puerto en el que la aplicación escucha
EXPOSE 8080

