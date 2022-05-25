FROM openjdk:16-alpine3.13

WORKDIR /mongodemo

COPY mongodemo/.mvn/ .mvn
COPY mongodemo/mvnw mongodemo/pom.xml ./

RUN ./mvnw dependency:go-offline

COPY mongodemo/src ./src

CMD ["./mvnw", "spring-boot:run"]

#COPY target/mongodemo-0.0.1-SNAPSHOT mongodemo-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/mongodemo-0.0.1-SNAPSHOT.jar"]