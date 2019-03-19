FROM openjdk:8-stretch as builder

COPY . /code
RUN cd /code && ./gradlew build

FROM openjdk:8-stretch

COPY --from=builder /code/build/libs/content.jar .
ENTRYPOINT exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap $JAVA_OPTS -jar /content.jar
