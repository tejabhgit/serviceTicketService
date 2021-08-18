FROM adoptopenjdk/openjdk8:alpine-jre
EXPOSE 8080
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ONBUILD ADD . /usr/src/app
ONBUILD RUN mvn install
ONBUILD ADD /usr/src/app/target/dockerdemo.jar dockerdemo.jar

CMD ["java","-jar","dockerdemo.jar"]