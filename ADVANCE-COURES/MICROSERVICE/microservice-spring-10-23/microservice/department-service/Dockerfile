FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} productserver.jar

ENTRYPOINT ["java","-jar","/productserver.jar"]

EXPOSE 8080