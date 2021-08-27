FROM maven:3.6.3-jdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean && mvn package -Dmaven.test.skip=true

FROM builder as test
ENTRYPOINT ["mvn", "test"]

FROM bellsoft/liberica-openjdk-alpine:11.0.8-10
WORKDIR /app
COPY --from=builder /app/target/task02-0.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]