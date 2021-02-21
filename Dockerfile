FROM alpine/git as clone 
WORKDIR /app
RUN git clone https://github.com/maciej-zygmunt/sprawdz-plan/sprawdz-plan.git

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
COPY --from=clone /app/sprawdz-plan /app 
RUN mvn install

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=build /app/target/sprawdz-plan-0.0.1-SNAPSHOT.jar /app
CMD ["java -jar sprawdz-plan-0.0.1-SNAPSHOT.jar"]
