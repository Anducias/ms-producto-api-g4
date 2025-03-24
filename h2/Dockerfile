# 1. Usar una imagen base con Java 17
FROM openjdk:17-jdk-slim

# 2. Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el archivo JAR generado en la imagen
COPY h2-2.3.232.jar /app/h2.jar

# 4. Exponer el puerto en el que corre la aplicación
EXPOSE 9092 8082

# 5. Comando para ejecutar la aplicación
CMD ["java", "-cp", "/app/h2.jar", "org.h2.tools.Server", "-tcp", "-tcpPort", "9092", "-tcpAllowOthers", "-web", "-webAllowOthers", "-ifNotExists"]