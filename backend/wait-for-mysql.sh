#!/bin/sh

echo "Aguardando MySQL iniciar..."

while ! nc -z db 3306; do
  sleep 1
done

echo "MySQL iniciado! Subindo app..."

exec java -jar /home/target/backend-0.0.1-SNAPSHOT.jar
