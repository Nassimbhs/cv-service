FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/cv-service.jar cv-service.jar
ENV SPRING_DATASOURCE_URL=jdbc:mysql://user-mysql:3306/userdb?useSSL=false
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=
CMD ["java", "-jar", "cv-service.jar"]