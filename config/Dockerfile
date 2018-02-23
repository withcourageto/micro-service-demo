FROM java:8-jre
MAINTAINER thomas lee <cuitlideng@163.com>

COPY ./target/config-0.0.1-SNAPSHOT.jar /app/config.jar

CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]

EXPOSE 9001:9001