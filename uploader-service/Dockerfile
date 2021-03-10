FROM adoptopenjdk:15.0.2_7-jre-hotspot-focal
RUN groupadd -g 999 appgroup &&\
    useradd -r -u 999 -gappgroup appuser
USER appuser
WORKDIR /work/
RUN chmod 750 /work
COPY build/libs/uploader-service-*.jar /work/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]