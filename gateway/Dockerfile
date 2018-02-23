FROM java:8-jre
MAINTAINER thomas lee <cuitlideng@163.com>

COPY ./target/gateway-0.0.1-SNAPSHOT.jar /app/gateway.jar


COPY ./wait-for-it.sh /app/wait-for-it.sh

CMD ["bash", "/app/wait-for-it.sh", "config:9001", "-s", "-t", "120", "--", \
    "bash", "/app/wait-for-it.sh", "service-registry:8701", "-t", "120", "--", \
    "java", "-agentlib:jdwp=transport=dt_socket,address=8015,server=y,suspend=n", \
    "-Xmx200m",  "-jar", "/app/gateway.jar"]

EXPOSE 8010