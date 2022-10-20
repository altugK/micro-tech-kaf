FROM openjdk:11.0.2-jre-slim
COPY ../jars/consumer.jar .
CMD /usr/bin/java -Xmx400m -Xms400m  -XX:TieredStopAtLevel=1 -noverify -jar consumer.jar
EXPOSE 8082