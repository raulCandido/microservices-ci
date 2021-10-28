FROM openjdk:11-jdk-slim
ARG JAR_FILE=book-service/target/*.jar
COPY ${JAR_FILE} app.jar
run bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]