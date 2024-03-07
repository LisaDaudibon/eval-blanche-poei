#!/usr/bin/env bash

# exit on error
set -e

TAG_NAME="amis-maison-du-vin"

echo "Nettoyage du target et package de notre application"
./mvnw clean verify

echo "Création de notre image docker avec le tag $TAG_NAME à partir du Dockerfile"
docker image build -t $TAG_NAME -f Dockerfile .
