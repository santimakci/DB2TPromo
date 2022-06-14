FROM openjdk:16-alpine3.13
FROM maven:3.6.3

WORKDIR /mongodemo

COPY mongodemo/.mvn/ .mvn

COPY mongodemo/mvnw mongodemo/pom.xml ./

COPY mongodemo/src ./src

RUN mvn clean install

EXPOSE 8080

CMD ["mvn","spring-boot:run"]


