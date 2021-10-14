# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.hp.svc-rps-support-ticket' is invalid and this project uses 'com.hp.supportTicket' instead.

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* 
# Getting Started

* docker compose up -d
* Start the application in debug/run mode
* docker compose down -v
* docker logs mongodb -f

### Reference Documentation

###Docker commands:
* build image jar in docker:
######docker build -t support-ticketservice:1.0 .
* run mongodb in docker:
######docker run -d -p 27017:27017 --name rpssupportticketdb mongo:latest
* run both containers in docker from $PATH\src\main\resources
######docker-compose up
if error check docker ps -a # and stop container by "docker container prune" and then perform "docker-componse up"

### Open CMD and perform MongoDB verify commands:
######docker exec -it rpssupportticketdb bash
######mongo
######show dbs;
######use TicketService
######show collections
######db.Ticket.find().pretty()

#### db.Ticket.dropIndexes()
#### db.Ticket.getIndexes()


###useful docker commands
* docker ps -a
* docker stop jshdbjshdbv


####remove all containers and images from power shell:
docker stop $(docker ps -q)
docker container prune
docker rmi $(docker images -q)
######
docker rm -vf $(docker ps -a -q)
-v: Remove all associated volumes
-f: Forces the removal. Like, if any containers is running, you need -f to remove them.
To remove all images,
docker rmi -f $(docker images -a -q)
####prometheus metrics
* http://localhost:8080/actuator/prometheus
####Jaeger
*docker run -d --name jaeger-ui -p 16686:16686 -p 6831:6831/udp jaegertracing/all-in-one:1.9
http://localhost:16686/search
http://localhost:9192/jaeger/client/3
https://medium.com/swlh/tracing-in-spring-boot-with-opentracing-opentelemetry-dd724134ca93
