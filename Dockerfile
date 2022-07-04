FROM gradle:7.4.2-jdk11 AS build
WORKDIR /build
RUN gradle clean build --no-daemon > /dev/null 2>&1 || true
COPY ./ /build/
RUN gradle build --no-daemon

FROM openjdk:11-jre-slim-buster
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/ /app/
ENTRYPOINT ["java","-jar","app.jar"]