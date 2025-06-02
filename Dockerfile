FROM openjdk:17-alpine

LABEL maintainer="mahendracandi"

ENV DB_URL  localhost
ENV DB_USER user
ENV DB_PASSWORD password
ENV PORT 8080


WORKDIR /opt/app
COPY target/*.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]
