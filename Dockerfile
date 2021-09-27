FROM adoptopenjdk/openjdk8:alpine-jre
ADD target/svc-rps-support-ticket.jar svc-rps-support-ticket.jar
ENTRYPOINT ["java","-jar","svc-rps-support-ticket.jar"]
