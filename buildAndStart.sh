#!/bin/bash

set -e

mvn clean install
docker build -t microserviceflowvisualizer .

docker run -t --rm --name microserviceflowvisualizer -p 5005:5005 -p 8080:8080 microserviceflowvisualizer

