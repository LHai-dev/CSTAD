FROM gradle:8.4-jdk17-alpine As builder
ENV SPRING_PROFILES_ACTIVE=native
WORKDIR /app
COPY ./spring-cloud/service-registry/ .
# Build the application
RUN gradle build --no-daemon

FROM openjdk:17
## Copy the jar file from the build/libs directory to the Docker image
COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8761