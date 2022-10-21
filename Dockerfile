FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

COPY . /build

WORKDIR /build

RUN mvn clean install -Dmaven.test.skip=true -Dmaven.javadoc.skip=true

FROM openjdk:8-jre-alpine

WORKDIR /src

RUN echo 'Asia/Shanghai' > /etc/timezone

#ENV JAVA_TOOL_OPTIONS="-Xmx3072m -Xms3072m -XX:NewRatio=4 -XX:SurvivorRatio=8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -XX:CompressedClassSpaceSize=256m -Xss256k -XX:ThreadStackSize=128k -XX:-ReduceInitialCardMarks -XX:+DisableExplicitGC -XX:+UseG1GC -XX:ParallelGCThreads=4 -XX:+UseCompressedOops"

COPY --from=MAVEN_BUILD /build/sentinel-dashboard/target/sentinel-dashboard.jar /src

ENTRYPOINT ["sh", "-c", "java -jar sentinel-dashboard.jar"]