#!/bin/bash

ACCOUNT_ID="905418468011"
REGION="us-east-2"
ECR_URL="$ACCOUNT_ID.dkr.ecr.$REGION.amazonaws.com"
VERSION="v1.0.1"  # <-- Atualize esta versão a cada mudança

echo "🔑 Autenticando no ECR..."
aws ecr get-login-password --region $REGION | docker login --username AWS --password-stdin $ECR_URL

echo "🏗️  Construindo backend..."
docker build -t backend -f ./backend/Dockerfile ./backend

echo "🏷️  Marcando e enviando backend..."
docker tag backend:latest $ECR_URL/backend:$VERSION
docker push $ECR_URL/backend:$VERSION
docker tag backend:latest $ECR_URL/backend:latest
docker push $ECR_URL/backend:latest

echo "🏗️  Construindo frontend..."
docker build -t frontend -f ./frontend/Dockerfile ./frontend

echo "🏷️  Marcando e enviando frontend..."
docker tag frontend:latest $ECR_URL/frontend:$VERSION
docker push $ECR_URL/frontend:$VERSION
docker tag frontend:latest $ECR_URL/frontend:latest
docker push $ECR_URL/frontend:latest

echo "✅ Imagens enviadas com sucesso para o ECR!"
echo "📌 Use a versão: $VERSION para referência estável."