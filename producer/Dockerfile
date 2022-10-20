FROM openjdk:11.0.2-jre-slim
COPY ./target/producer-0.1.jar .
CMD /usr/bin/java -Xmx400m -Xms400m  -XX:TieredStopAtLevel=1 -noverify -jar producer-0.1.jar
EXPOSE 8081