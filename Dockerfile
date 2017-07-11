FROM openjdk:alpine
MAINTAINER info@andybowes.me.uk
EXPOSE 8080
ADD build/libs/kmdb-0.0.1.jar kmdb.jar
RUN sh -c 'touch /kmdb.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /kmdb.jar" ]