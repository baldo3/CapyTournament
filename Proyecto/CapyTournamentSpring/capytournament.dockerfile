# Imagen base para el contenedor de compilación
FROM maven:3.8.4-openjdk-17 as builder
COPY /src ./src
COPY pom.xml ./
RUN mvn -B package
# Imagen base para el contenedor de la aplicación
FROM openjdk:17-jdk-slim
COPY --from=builder ./target/*.jar ./
EXPOSE 8080
CMD [ "java", "-jar", "CapyTournament-0.0.1-SNAPSHOT.jar" ]
