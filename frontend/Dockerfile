FROM node:10 as builder

COPY . /code
RUN cd /code && npm install && npm run build

FROM nginx

COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /code/build /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
