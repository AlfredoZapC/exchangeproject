FROM openjdk:11-jre-slim
LABEL maintainer="Alfredo Zapata"
COPY /target/*.jar exchange-project-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT exec java -jar /exchange-project-0.0.1-SNAPSHOT.jar