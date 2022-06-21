FROM maven:3.6.3
FROM openjdk:16-alpine3.13

RUN mkdir /mongodemo

WORKDIR /mongodemo

COPY mongodemo/.mvn/ .mvn

COPY mongodemo/mvnw mongodemo/pom.xml ./

COPY mongodemo/src ./src

RUN mvn clean install

ENTRYPOINT ["mvn", "spring-boot:run"]


