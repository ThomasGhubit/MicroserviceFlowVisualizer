#!/bin/bash

set -e

mvn clean install
docker build -t microserviceflowvisualizer .
docker run -t --rm --name microserviceflowvisualizer -p 8081:8080 microserviceflowvisualizer
