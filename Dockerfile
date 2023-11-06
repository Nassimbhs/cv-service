FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/cv-service.jar cv-service.jar
CMD ["java", "-jar", "cv-service.jar"]