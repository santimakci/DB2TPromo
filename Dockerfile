FROM maven:3.6.3
FROM openjdk:16-alpine3.13

RUN mkdir /app

WORKDIR /app

COPY app/.mvn/ .mvn

COPY app/mvnw app/pom.xml ./

COPY app/src ./src

RUN mvn clean install

ENTRYPOINT ["mvn", "spring-boot:run"]


