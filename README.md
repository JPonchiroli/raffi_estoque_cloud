# 📦 Sistema de Gerenciamento de Estoque

Aplicação web para gerenciamento de estoque, com interface amigável, backend robusto e integração com API externa. A arquitetura é baseada em microserviços com containers Docker, facilitando o deploy e a escalabilidade — agora **totalmente hospedada na AWS** com alta disponibilidade e escalabilidade.

[![Java](https://img.shields.io/badge/Java-21-red?logo=java&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Node.js](https://img.shields.io/badge/Node.js-20.x-green?logo=node.js)](https://nodejs.org/)
[![Express](https://img.shields.io/badge/Express.js-4.x-lightgrey?logo=express)](https://expressjs.com/)
[![EJS](https://img.shields.io/badge/EJS-templates-yellow)](https://ejs.co/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue?logo=docker)](https://www.docker.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-blue?logo=mysql&logoColor=white)](https://www.mysql.com/)
[![MapStruct](https://img.shields.io/badge/MapStruct-mapper-blueviolet)](https://mapstruct.org/)
[![ViaCEP](https://img.shields.io/badge/API-ViaCEP-orange)](https://viacep.com.br/)
[![AWS ECR](https://img.shields.io/badge/AWS-ECR-FF9900?logo=amazonaws&logoColor=white)](https://aws.amazon.com/ecr/)
[![AWS ECS Fargate](https://img.shields.io/badge/AWS-ECS_Fargate-232F3E?logo=amazonaws&logoColor=white)](https://aws.amazon.com/ecs/)
[![AWS RDS](https://img.shields.io/badge/AWS-RDS-337AB7?logo=amazonaws&logoColor=white)](https://aws.amazon.com/rds/)

---

## ☁️ Infraestrutura na AWS

Este projeto é implantado na **Amazon Web Services (AWS)**, utilizando os seguintes serviços principais:

### 🖼️ **Amazon ECR (Elastic Container Registry)**
> *Repositório privado de imagens Docker.*

- **O que faz**: Armazena as imagens Docker do `frontend` e `backend` de forma segura e escalável.
- **Aplicação no projeto**: As imagens construídas localmente são enviadas ao ECR e posteriormente consumidas pelo ECS para iniciar as tasks.

---

### 🚀 **Amazon ECS com Fargate**
> *Serviço de orquestração de containers serverless.*

- **O que faz**: Executa e gerencia containers sem a necessidade de provisionar ou gerenciar servidores.
- **Aplicação no projeto**: O serviço `raffi-app-service` roda as tasks que contêm os containers do frontend e backend, garantindo alta disponibilidade e escalabilidade automática.

---

### 💾 **Amazon RDS (Relational Database Service)**
> *Serviço gerenciado de bancos de dados relacionais.*

- **O que faz**: Hospeda o banco de dados MySQL de forma segura, com backups automáticos, monitoramento e escalabilidade.
- **Aplicação no projeto**: Armazena todos os dados da aplicação (produtos, endereços, etc.) com alta confiabilidade e desempenho.

---

## 🧰 Tecnologias Utilizadas

### 🔧 Backend
- Java 21 + Spring Boot
- Spring Data JPA
- MapStruct (mapeamento entre entidades e DTOs)
- MySQL (via container Docker local / RDS na AWS)
- API ViaCEP para busca de endereços por CEP
- DTOs para criação, retorno e atualização de dados

### 🌐 Frontend
- Node.js + Express
- EJS para renderização de páginas
- DataTables para exibição dinâmica e paginada de dados

### 📦 Containers
- Docker + Docker Compose
- Imagens hospedadas no **Amazon ECR**

---

## 🚀 Funcionalidades

- ✅ Cadastro, listagem, atualização e exclusão de produtos
- ✅ Paginação de resultados com DataTables
- ✅ Integração com API ViaCEP para preenchimento automático de endereços
- ✅ Mapeamento automático com MapStruct
- ✅ Separação de responsabilidades com uso de DTOs
- ✅ Deploy contínuo na AWS com ECR + ECS + RDS

---

## 📦 Como Executar o Projeto

### Pré-requisitos

- Docker instalado ([instale aqui](https://docs.docker.com/get-docker/))
- Docker Compose
- AWS CLI configurada com credenciais e permissões para ECS, ECR e RDS

---

### ▶️ Para iniciar o serviço na AWS (ECS Fargate)

```bash
aws ecs update-service \
  --cluster raffi-estoque \
  --service raffi-app-service-ne9zzrwt \
  --desired-count 1 \
  --region us-east-2
```

### ▶️ Para encerrar o serviço na AWS (ECS Fargate)

```bash
aws ecs update-service \
  --cluster raffi-estoque \
  --service raffi-app-service-ne9zzrwt \
  --desired-count 0 \
  --region us-east-2
