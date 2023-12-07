FROM openjdk:17
ARG jar_file=target/*.jar
COPY ${jar_file} api-gateway.jar
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
EXPOSE 9191



# Run api-gateway container on the microservice network


# Run registry container on the microservice network

