#!/bin/bash
mvn clean install
kill $(lsof -t -i:8080)
java -jar ./target/mini-project-0.0.1-SNAPSHOT.jar &
jobs