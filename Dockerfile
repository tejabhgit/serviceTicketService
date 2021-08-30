FROM adoptopenjdk/openjdk8:alpine-jre
ADD target/support-ticketservice.jar support-ticketservice.jar
ENTRYPOINT ["java","-jar","support-ticketservice.jar"]