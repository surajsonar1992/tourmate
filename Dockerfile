# Start from a lightweight JDK 21 image
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# Copy Maven wrapper & pom first (to leverage caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline -B

# Copy project source
COPY src src

# Package the application
RUN ./mvnw clean package -DskipTests

# ---- Runtime image ----
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the jar from builder
COPY --from=builder /app/target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]