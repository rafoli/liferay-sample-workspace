FROM node:alpine

RUN mkdir /db

VOLUME /db

EXPOSE 3000

RUN yarn global add json-server

CMD ["json-server","--id", "resId", "--watch", "/db/samples.json", "--host", "0.0.0.0", "--port 3000"]
