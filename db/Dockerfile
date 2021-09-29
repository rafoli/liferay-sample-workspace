FROM node:alpine

RUN mkdir /db

EXPOSE 3000

COPY samples.json /db/samples.json

RUN yarn global add json-server

CMD ["json-server", "--watch", "/db/samples.json", "--host", "0.0.0.0", "--port 3000"]
