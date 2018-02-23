FROM java:8-jre
MAINTAINER thomas lee <cuitlideng@163.com>

COPY ./target/service-registry-0.0.1-SNAPSHOT.jar /app/service-registry.jar

CMD ["java", "-agentlib:jdwp=transport=dt_socket,address=8705,server=y,suspend=n", \
    "-Xmx200m",  "-jar", "/app/service-registry.jar"]

EXPOSE 8701 8705