FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/customers-microservice-rest-api.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]