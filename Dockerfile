# Build stage
FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

# Instalar dependencias necesarias
RUN apk add --no-cache gradle

# Copiar los archivos del proyecto
COPY gradle/ gradle/
COPY build.gradle settings.gradle ./
COPY gradlew ./
COPY src/ src/

# Dar permisos de ejecución al gradlew
RUN chmod +x ./gradlew

# Construir el proyecto
RUN ./gradlew bootJar --no-daemon

# Runtime stage
FROM eclipse-temurin:17-jre-alpine

# Instalar dependencias necesarias para producción
RUN apk add --no-cache tzdata

# Configurar la zona horaria
ENV TZ=America/Bogota

# Crear un usuario no root
RUN addgroup -S spring && adduser -S spring -G spring

# Crear directorios necesarios y establecer permisos
WORKDIR /app
RUN mkdir -p /app/logs && \
    mkdir -p /tmp && \
    chown -R spring:spring /app && \
    chown -R spring:spring /tmp

# Copiar el JAR construido
COPY --from=build /workspace/app/build/libs/*.jar app.jar
RUN chown spring:spring /app/app.jar

# Cambiar al usuario no root
USER spring:spring

# Configurar el punto de entrada
ENTRYPOINT ["java", \
            "-XX:+UnlockExperimentalVMOptions", \
            "-Djava.security.egd=file:/dev/./urandom", \
            "-jar", \
            "app.jar"]

# Exponer el puerto de la aplicación
EXPOSE 8080

# Documentar los volúmenes
VOLUME ["/tmp", "/app/logs"]