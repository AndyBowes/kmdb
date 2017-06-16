FROM openjdk:alpine
MAINTAINER info@andybowes.me.uk
EXPOSE 8080
CMD java -jar kmdb-restful-service.jar
ADD build/kmdb-restful-service.jar .
