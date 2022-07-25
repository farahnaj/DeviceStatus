FROM node:14.9
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm i
COPY . ./
RUN npm run build
EXPOSE 3000
CMD ["npx", "serve", "-s", "build" ]