FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-mysql.sh .
RUN apk update && apk add netcat-openbsd && chmod +x wait-for-mysql.sh
EXPOSE 8080
ENTRYPOINT ["sh", "wait-for-mysql.sh"]
