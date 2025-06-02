# Using multi-stage builder
FROM maven:3-eclipse-temurin-17-alpine AS builder

WORKDIR /opt/app/build
COPY . /opt/app/build
RUN mvn clean package -DskipTests

FROM openjdk:17-alpine

LABEL maintainer="mahendracandi"

ENV DB_URL  localhostx
ENV DB_USER userx
ENV DB_PASSWORD passwordx
ENV PORT 8080

WORKDIR /opt/app
COPY --from=builder /opt/app/build/target/application.jar /application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/application.jar"]
