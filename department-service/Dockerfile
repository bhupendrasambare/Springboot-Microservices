FROM openjdk:17
ARG jar_file=target/*.jar
COPY ${jar_file} department-service.jar
ENTRYPOINT ["java", "-jar", "department-service.jar"]
EXPOSE 9001