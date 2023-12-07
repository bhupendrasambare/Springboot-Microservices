FROM openjdk:17
ARG jar_file=target/*.jar
COPY ${jar_file} registry.jar
ENTRYPOINT ["java", "-jar", "registry.jar"]
EXPOSE 8761