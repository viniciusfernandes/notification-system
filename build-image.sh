#!/usr/bin/env sh
./gradlew clean build
docker rmi -f viniciussf/advertisement-notification:latest
docker build . -t viniciussf/advertisement-notification:latest