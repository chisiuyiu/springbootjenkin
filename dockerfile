# Docker Build Maven Stage
FROM maven AS build
# Copy folder in docker
WORKDIR /opt/app
COPY ./ /opt/app
RUN mvn clean install -DskipTests
# Run spring boot in Docker
FROM openjdk
COPY --from=build /opt/app/target/*.jar app.jar
EXPOSE 8582 3306
ENTRYPOINT ["java","-jar","-Xmx1024M","-Dserver.port=${PORT}","app.jar"]
