#!/bin/bash

# Ask maven to build the executable jar file from the source files
# mvn clean install --file ./MailRobot/pom.xml

# Copy the executable jar file in the current directory
# cp ./MailRobot/target/MailRobot-1.0-SNAPSHOT.jar .

# Build the Docker image locally
docker build -t mockmock .