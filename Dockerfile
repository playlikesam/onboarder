# ---- build stage ----
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /build

# copy maven wrapper and pom first for fast layer caching
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# copy source and build
COPY src src

# allow mvnw to run (if present)
RUN chmod +x mvnw || true

# build the jar (skip tests to speed up)
RUN ./mvnw -B -DskipTests package

# ---- runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# copy the built jar from builder stage
COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
