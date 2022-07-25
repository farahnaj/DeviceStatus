# README #

Device Status API. 

Houses backend, frontend and the db. 

## Prerequisites

- Java 17
- npm 8.5.2+
- node v14+
- docker engine
- docker-compose v2.6.1+

Install maven wrapper 
----
mvn -N wrapper:wrapper

## Spinning up local
docker-compose down
docker-compose up

## EXISTING FEATURES
* Create, Search device status

## How to run it?
* run the script cleanBuild.sh
* visit localhost:3000

### What is happening?
* It uses docker compose to spin up all the services.
* It will run Backend server with DB and Frontend.
* 2 Users will be craeted "farah" and "rohit"
* Devices with ids {1,2,3,4} will be created
* Health is Enum class: [ERROR, OK, WARNING], comming soon as drop down in UI.
* Some device statuses will be created for demo of search.
