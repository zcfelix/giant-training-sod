FROM java:8
ADD picture-sod-0.0.1-SNAPSHOT.jar app.jar
ADD wrapper.sh wrapper.sh
RUN bash -c 'chmod +x /wrapper.sh'
RUN bash -c 'touch /app.jar'
RUN bash -c 'mkdir /tmp/uploading'
ENTRYPOINT ["bin/bash", "/wrapper.sh"]