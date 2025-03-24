# 1. Usar una imagen base con Java 17
FROM openjdk:17-jdk-slim

# 2. Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el archivo JAR generado en la imagen
COPY build/libs/ms-producto-api-g4-1.0.0.jar app.jar

# 4. Exponer el puerto en el que corre la aplicación
EXPOSE 8282

# 5. Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]