# -------- 1. Build Stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom and download dependencies first (use build cache)
COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# Copy source
COPY src ./src

# Build Spring Boot JAR
RUN mvn clean package -DskipTests

# -------- 2. Run Stage --------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy built jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
