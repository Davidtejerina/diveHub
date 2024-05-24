FROM openjdk:17-jdk-alpine as build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos de configuración de Maven y el código fuente
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

# Cambiar los permisos del script Maven Wrapper
RUN chmod +x ./mvnw

# Instalar dos2unix y convertir los finales de línea del script Maven Wrapper
RUN apk update && apk add dos2unix
RUN dos2unix ./mvnw

# Resolver las dependencias de Maven y compilar el proyecto
RUN ./mvnw clean package

# Comando por defecto para ejecutar la aplicación Spring Boot
CMD ["java", "-jar", "/app/target/diveHub-0.0.1-SNAPSHOT.jar"]



