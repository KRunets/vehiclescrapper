FROM openjdk:13-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/vehiclescrapper-0.0.1-SNAPSHOT.war
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]