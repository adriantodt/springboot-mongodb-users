# syntax=docker/dockerfile:1
FROM openjdk:17
ARG APP_VERSION
WORKDIR /app
COPY build/libs/users-$APP_VERSION.jar ./users.jar

CMD ["java", "-jar","./users.jar"]
