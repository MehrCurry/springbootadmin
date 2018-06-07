FROM maven:3-jdk-8 as builder

ARG MAVEN_REPOS=http://diskstation:8081/repository/maven-public/

COPY . /usr/src/myapp
RUN mvn -f /usr/src/myapp/pom.xml clean package -Dmaven.repo.remote=http://diskstation:8081/repository/maven-public/

FROM openjdk:8-jre-slim

COPY --from=builder /usr/src/myapp/target/*.jar /app/

CMD java -jar -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2 -XshowSettings:vm /app/*.jar
