FROM adoptopenjdk:11-jre-openj9
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} sprawdz-plan.jar
ENTRYPOINT ["java","-jar","sprawdz-plan.jar"]
#ENTRYPOINT ["java","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005","-jar","sprawdz-plan.jar"]
#ENTRYPOINT ["bash"]