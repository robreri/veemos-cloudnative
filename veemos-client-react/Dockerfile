FROM node:alpine as builder
WORKDIR /app
COPY . .
RUN npm rebuild -g
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html
