FROM openjdk:8-jdk-alpine
VOLUME /tmp
RUN mkdir app
COPY target/myRetail-1.0.1-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/myRetail-1.0.1-SNAPSHOT.jar"]