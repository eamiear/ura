FROM java:8

VOLUME /tmp
ADD ura-common.jar /common.jar
RUN bash -c 'touch /common.jar'
ENTRYPOINT ["java","-jar","/common.jar"]
