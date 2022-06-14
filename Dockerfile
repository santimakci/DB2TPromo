#FROM openjdk:16-alpine3.13
#
#WORKDIR /mongodemo
#
#COPY mongodemo/.mvn/ .mvn
#COPY mongodemo/mvnw mongodemo/pom.xml ./
#
#RUN ./mvnw dependency:go-offline
#
#COPY mongodemo/src ./src
#
#CMD ["./mvnw", "spring-boot:run"]

#COPY target/mongodemo-0.0.1-SNAPSHOT mongodemo-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/mongodemo-0.0.1-SNAPSHOT.jar"]
#FROM maven:3.6.3 AS maven
FROM openjdk:16-alpine3.13
FROM maven:3.6.3

WORKDIR /mongodemo

COPY mongodemo/.mvn/ .mvn

COPY mongodemo/mvnw mongodemo/pom.xml ./

COPY mongodemo/src ./src

RUN mvn clean install

EXPOSE 8080
EXPOSE 27017

CMD ["mvn","spring-boot:run"]
