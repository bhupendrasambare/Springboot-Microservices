FROM openjdk:17
ARG jar_file=target/*.jar
COPY ${jar_file} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
EXPOSE 9191

