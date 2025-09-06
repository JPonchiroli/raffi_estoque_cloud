#!/bin/bash

# Configurações
ACCOUNT_ID="905418468011"
REGION="us-east-2"
TASK_FAMILY="raffi-app"
EXECUTION_ROLE_ARN="arn:aws:iam::$ACCOUNT_ID:role/ecsTaskExecutionRole"

# Registra a task definition
aws ecs register-task-definition \
  --family $TASK_FAMILY \
  --network-mode awsvpc \
  --requires-compatibilities FARGATE \
  --cpu "512" \
  --memory "1024" \
  --execution-role-arn $EXECUTION_ROLE_ARN \
  --container-definitions '[
    {
      "name": "backend",
      "image": "'$ACCOUNT_ID'.dkr.ecr.'$REGION'.amazonaws.com/backend:latest",
      "portMappings": [
        {
          "containerPort": 8080,
          "protocol": "tcp"
        }
      ],
      "cpu": 256,
      "memory": 512,
      "essential": true
    },
    {
      "name": "frontend",
      "image": "'$ACCOUNT_ID'.dkr.ecr.'$REGION'.amazonaws.com/frontend:latest",
      "portMappings": [
        {
          "containerPort": 3000,
          "protocol": "tcp"
        }
      ],
      "cpu": 256,
      "memory": 512,
      "essential": true
    }
  ]' \
  --region $REGION

echo "✅ Task Definition '$TASK_FAMILY' criada com sucesso!"