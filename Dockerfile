FROM amazoncorretto:11-alpine-jdk
MAINTAINER lgimenez
COPY target/springboot-demo-1.0.0-SNAPSHOT.jar springboot-demo-1.0.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/springboot-demo-1.0.0-SNAPSHOT.jar"] 
