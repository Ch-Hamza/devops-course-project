#!/bin/bash
mvn clean install
java -jar ./target/mini-project-0.0.1-SNAPSHOT.jar &
jobs