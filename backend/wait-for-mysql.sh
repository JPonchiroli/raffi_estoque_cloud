#!/bin/sh

set -e

HOST="db"
PORT=3306
RETRIES=60

echo "⏳ Aguardando MySQL em $HOST:$PORT (timeout: ${RETRIES}s)..."

for i in $(seq 1 $RETRIES); do
  if nc -z "$HOST" "$PORT"; then
    echo "✅ MySQL está disponível!"
    break
  fi
  echo "Tentativa $i/$RETRIES: aguardando..."
  sleep 1
done

if ! nc -z "$HOST" "$PORT"; then
  echo "❌ Falha ao conectar ao MySQL em $HOST:$PORT após $RETRIES segundos."
  exit 1
fi

echo "🚀 Subindo aplicação..."
exec java -jar app.jar "--spring.profiles.active=docker"
