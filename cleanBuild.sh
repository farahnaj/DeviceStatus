#!/bin/zsh
# Use this script if something goes wrong with docker.
# For all practical purposes docker-compose down/up should work.
# Use convenience script run.sh for this 
mvn -N wrapper:wrapper
./mvnw clean
./mvnw install
./mvnw jar:jar
docker-compose down
#TODO This does not work in shell script. Why? 
docker image rm -f devicestatus:latest
docker image rm -f frontend:latest
# To speed up the build commenting. We need to rebuild the frontend and backend though 
# docker image rm -f postgres:14.2-alpine
docker volume rm $(docker volume ls -q)
docker-compose build
docker-compose up 

# Old junk
#./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=taskscrm
#sh run.sh
