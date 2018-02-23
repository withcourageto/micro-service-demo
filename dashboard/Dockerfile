FROM java:8-jre

MAINTAINER thomas-lee

COPY ./target/dashboard-0.0.1-SNAPSHOT.jar /app/dashboard.jar
COPY ./wait-for-it.sh /app/wait-for-it.sh

CMD ["bash", "/app/wait-for-it.sh", "config:9001", "-s", "-t", "120", "--", \
    "bash", "/app/wait-for-it.sh", "service-registry:8701", "-t", "120", "--", \
    "java", "-agentlib:jdwp=transport=dt_socket,address=8045,server=y,suspend=n", \
    "-Xmx200m",  "-jar", "/app/dashboard.jar"]

EXPOSE 8040 8045