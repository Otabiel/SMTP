FROM openjdk:11
MAINTAINER Nils Basset <nils.basset@heig-vd.ch>

RUN apt-get update && \
  apt-get clean 
  
COPY MockMock.jar /opt/app/MockMock.jar

EXPOSE 25
EXPOSE 8282

CMD ["java", "-jar", "/opt/app/MockMock.jar"]