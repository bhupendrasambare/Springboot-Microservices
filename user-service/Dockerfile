FROM openjdk:17
ARG jar_file=target/*.jar
COPY ${jar_file} user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
EXPOSE 9002