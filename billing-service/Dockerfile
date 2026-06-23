# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .

# Determine architecture to download correct protoc binary
RUN if [ "$(uname -m)" = "aarch64" ]; then \
      export ARCH="linux-aarch_64"; \
    else \
      export ARCH="linux-x86_64"; \
    fi && \
    mvn dependency:go-offline -B -Dos.detected.classifier=$ARCH

COPY src ./src

# Build using the detected architecture classifier
RUN if [ "$(uname -m)" = "aarch64" ]; then \
      export ARCH="linux-aarch_64"; \
    else \
      export ARCH="linux-x86_64"; \
    fi && \
    mvn clean package -DskipTests -Dos.detected.classifier=$ARCH

# Stage 2: Run
# Using JRE instead of JDK to keep the image slim and secure
FROM eclipse-temurin:21-jre-alpine AS runner
WORKDIR /app
# Use a wildcard or specific path to copy the built JAR
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]
