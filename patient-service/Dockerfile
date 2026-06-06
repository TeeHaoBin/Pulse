# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
# Cache dependencies
RUN mvn dependency:go-offline -B
COPY src ./src
# Build without running tests to speed up image creation
RUN mvn clean package -DskipTests

# Stage 2: Run
# Using JRE instead of JDK to keep the image slim and secure
FROM eclipse-temurin:21-jre-alpine AS runner
WORKDIR /app
# Use a wildcard or specific path to copy the built JAR
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 4000

# Environment variables with defaults (can be overridden in IntelliJ/Compose)
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/db
ENV SPRING_DATASOURCE_USERNAME=admin_user
ENV SPRING_DATASOURCE_PASSWORD=password

ENTRYPOINT ["java", "-jar", "app.jar"]
