FROM logstash:5.4-alpine
MAINTAINER architecture@gft.com

LABEL vendor="Ipman1971" \
      com.ipman.is-dev="true" \
      com.ipman.is-production="false" \
      com.ipman.version="1.0"

ENV URL_MYSQL_DRIVER=http://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.9
ENV MYSQL_DRIVER_JAR=mysql-connector-java-5.1.9.jar
ENV JDBC_VENDOR_DIR=/usr/share/logstash/vendor/jdbc

RUN set -x && \
    mkdir -p $JDBC_VENDOR_DIR

RUN wget $URL_MYSQL_DRIVER/$MYSQL_DRIVER_JAR -O $JDBC_VENDOR_DIR/mysql-driver.jar
