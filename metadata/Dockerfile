FROM openjdk:8-stretch as builder

COPY . /code
RUN cd /code && ./gradlew build

FROM openjdk:8-stretch

COPY --from=builder /code/build/libs/metadata.jar .
ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /metadata.jar
