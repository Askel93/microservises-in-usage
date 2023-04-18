FROM openjdk:11-slim as build
LABEL maintainer = "askel93"
ARG JAR_FILE=target/licensing-service-0.0.1-SNAPSHOT.jar
#ARG JAR_FILE
COPY ${JAR_FILE} app.jar

#распаковка jar
RUN mkdir -p target/dependency && \
(cd target/dependency; jar -xf /app.jar)

FROM openjdk:11-slim
VOLUME /tmp

ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.optimagrowth.license.LicenseServiceApplication"]

#ENTRYPOINT ["java","-jar","/app.jar"]