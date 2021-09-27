FROM node:alpine
EXPOSE 3000
COPY samples.json /opt/samples.json
RUN yarn global add json-server
CMD ["json-server", "--watch", "/opt/samples.json", "--host", "0.0.0.0", "--port 3000"]

