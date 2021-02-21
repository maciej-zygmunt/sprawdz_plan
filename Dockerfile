FROM adoptopenjdk:11-jre-openj9
VOLUME /tmp
COPY ./target/sprawdz-plan-0.0.1-SNAPSHOT.jar sprawdz-plan.jar
ENTRYPOINT ["java","-jar","sprawdz-plan.jar"]
#ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","sprawdz-plan.jar"]
#ENTRYPOINT ["bash"]
