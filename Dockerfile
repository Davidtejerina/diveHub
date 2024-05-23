#FROM openjdk:17-jdk-alpine
#ARG JAR_FILE=target/*.jar
#COPY ./target/test-classes/diveHub-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "/app.jar"]

# Usa una imagen base de Java con JDK 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado en el directorio de trabajo del contenedor
ARG JAR_FILE=target/*.jar
COPY ./target/diveHub-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
