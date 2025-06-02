# This docker file is using multi-stage builds

# FROM the command to use which base image will be used
# ________________________________________________________________________________________________
# | Part                 | Meaning                                                                |
# | -------------------- | ---------------------------------------------------------------------- |
# | `maven`              | The official Docker image for Apache Maven                             |
# | `3`                  | Maven version `3.x` (latest 3.x at time of build — e.g., 3.9.x)        |
# | `eclipse-temurin-17` | Uses **Eclipse Temurin JDK 17** (a popular, open-source OpenJDK build) |
# | `alpine`             | Based on **Alpine Linux**, a minimal and lightweight Linux distro      |
# -------------------------------------------------------------------------------------------------
FROM maven:3-eclipse-temurin-17-alpine AS builder

# This sets the working directory inside the container.
WORKDIR /opt/app/build

# This copies all files from the build context
# (usually your local project directory where you run docker build)
# into the /opt/app/build directory inside the container.
COPY . /opt/app/build

RUN mvn clean package -DskipTests


# |   Part        |  Meaning                                                                      |
# | ------------- | ----------------------------------------------------------------------------- |
# | `openjdk`     | Refers to the **official OpenJDK image** maintained on Docker Hub.            |
# | `17`          | Specifies the **Java version** to use, in this case **Java 17** (LTS).        |
# | `alpine`      | Uses the **Alpine Linux** variant — a minimal, security-oriented base distro. |
FROM openjdk:17-alpine

LABEL maintainer="mahendracandi"

ENV DB_URL  localhostx
ENV DB_USER userx
ENV DB_PASSWORD passwordx
ENV PORT 8080

WORKDIR /opt/app

# |   Part                                  |   Meaning                                                                              |
# | --------------------------------------- | -------------------------------------------------------------------------------------- |
# | `COPY`                                  | Docker instruction to copy files or directories from source to destination.            |
# | `--from=builder`                        | Indicates that the source file is from the **`builder` stage** in a multi-stage build. |
# | `/opt/app/build/target/application.jar` | The **source path** inside the `builder` stage (where the JAR was built).              |
# | `/application.jar`                      | The **destination path** inside the **current stage/container**.                       |
COPY --from=builder /opt/app/build/target/application.jar /application.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/application.jar"]
