FROM openjdk:11.0.2-jre-slim
COPY target/producer.jar .
CMD /usr/bin/java -Xmx400m -Xms400m  -XX:TieredStopAtLevel=1 -noverify -jar producer.jar
EXPOSE 8081