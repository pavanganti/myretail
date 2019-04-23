#!/bin/bash

echo "start the mongodb as daemon"
docker-compose -f docker-compose.yml up mongodb -d

echo "run the myretail app as java service"
nohup java -jar target/myRetail-1.0.1-SNAPSHOT.jar &