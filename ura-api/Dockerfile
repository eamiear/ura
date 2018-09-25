FROM java:8
EXPOSE 6064

VOLUME /tmp
ADD ura-api.jar /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
