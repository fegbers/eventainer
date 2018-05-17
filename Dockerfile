FROM openjdk:8-jre-alpine

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "eventainer.jar"]

ADD target/eventainer.jar eventainer.jar
