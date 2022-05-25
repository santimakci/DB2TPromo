FROM openjdk:11-jdk-alpine
COPY target/docker-mongodemo-0.0.1-SNAPSHOT message-mongodemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/mongodemo-0.0.1-SNAPSHOT.jar"]