# 🌍 Air Pollution Analytics Platform

> A cloud-native, production-oriented analytics platform for collecting, processing, deploying, and serving global air quality data using modern DevOps and Backend engineering practices.

![Java](https://img.shields.io/badge/Java-17-red)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Deployed-326CE5)
![Jenkins](https://img.shields.io/badge/CI-CD2B4A)
![ArgoCD](https://img.shields.io/badge/GitOps-ArgoCD-orange)
![Terraform](https://img.shields.io/badge/Infrastructure-Terraform-844FBA)
![AWS](https://img.shields.io/badge/Cloud-AWS-FF9900)

---

## 📖 Overview

The Air Pollution Analytics Platform is a cloud-native backend application built to demonstrate modern Backend Development and DevOps engineering practices.

The platform ingests raw pollution datasets through an ETL pipeline, transforms them into structured data, stores them in MongoDB, and exposes analytics through REST APIs.

The project is intentionally designed using production-inspired architecture instead of focusing solely on application development. It demonstrates how modern software is built, tested, containerized, deployed, secured, and continuously delivered using Kubernetes and GitOps.

---

# ✨ Features

- REST APIs for pollution analytics
- ETL pipeline processing 23,463+ pollution records
- MongoDB data storage
- Containerized using Docker
- Kubernetes deployment
- Horizontal Pod Autoscaler
- Persistent Volumes & StatefulSets
- ConfigMaps & Secrets
- Jenkins CI Pipeline
- SonarQube Code Analysis
- Trivy Image Scanning
- GitOps deployment using ArgoCD
- ArgoCD Notifications
- Production-ready Kubernetes security hardening
- AWS EC2 deployment

---

# 🏗 Architecture

```

```
                         +-----------------------+
                         |      GitHub Repo      |
                         +-----------+-----------+
                                     |
                                     |
                             Jenkins Pipeline
                                     |
       ----------------------------------------------------
       |                  |                  |             |
  Maven Build      SonarQube Scan     Trivy Scan     Docker Build
       |                  |                  |             |
       ----------------------------------------------------
                                     |
                             Push Docker Image
                                     |
                                     |
                               Git Commit
                                     |
                                 ArgoCD
                                     |
                               Kubernetes
                                     |
        -------------------------------------------------------
        |                         |                          |
   Backend Deployment        ETL Job                MongoDB StatefulSet
        |                         |                          |
        ---------------------------                          |
                    |                                       |
               Backend Service ------------------------------|
                    |
                 REST APIs
```

---

# 🛠 Technology Stack

## Backend

- Java 17
- Spring Boot
- Spring Data MongoDB
- Maven

## Database

- MongoDB

## ETL

- OpenCSV
- Java Streams
- Batch Processing

## Containers

- Docker
- Multi-stage Builds

## Container Orchestration

- Kubernetes
- Deployments
- Jobs
- Services
- ConfigMaps
- Secrets
- StatefulSets
- Persistent Volumes
- Horizontal Pod Autoscaler
- Ingress

## DevOps

- Jenkins
- SonarQube
- Trivy
- ArgoCD
- GitOps

## Cloud

- AWS EC2

---

# 📂 Project Structure

```
Air-Pollution-Analytic-Platform/

├── backend/
│   ├── Spring Boot REST API
│   └── Business Logic
│
├── etl-pipeline/
│   ├── CSV Reader
│   ├── Transformer
│   └── MongoDB Loader
│
├── k8s/
│   ├── backend/
│   ├── database/
│   ├── etl/
│   └── base/
│
├── argoCD/
│   ├── Applications
│   ├── App of Apps
│   └── Notifications
│
├── terraform/
│
├── Jenkinsfile
│
└── docker-compose.yml
```

---

# 🔄 CI/CD Pipeline

Every code change follows the pipeline below:

```
Developer

↓

GitHub Push

↓

Jenkins

↓

Compile

↓

Unit Tests

↓

SonarQube Analysis

↓

Build Docker Image

↓

Trivy Image Scan

↓

Push Image

↓

GitOps Repository Update

↓

ArgoCD Detects Changes

↓

Kubernetes Deployment

↓

Application Updated
```

---

# 🔐 Security Features

The application follows several production-inspired security practices.

### Docker

- Multi-stage builds
- Non-root containers
- Minimal runtime image

### Kubernetes

- Non-root Pods
- Read-only root filesystem
- Linux capability dropping
- Resource requests & limits
- Secrets for sensitive configuration
- ConfigMaps
- Health probes
- Rolling updates

---

# 🚀 Deployment

The application is deployed on:

- AWS EC2
- Docker
- Kubernetes
- ArgoCD GitOps

Deployment follows GitOps principles where every infrastructure change is version-controlled and automatically synchronized by ArgoCD.

---

# 📡 REST API

| Method | Endpoint | Description |
|----------|----------------------------|----------------------------|
| GET | `/pollution` | Get all pollution records |
| GET | `/pollution/country/{country}` | Pollution by country |
| GET | `/pollution/city/{city}` | Pollution by city |
| GET | `/pollution/stats` | Overall statistics |
| GET | `/pollution/top-cities` | Most polluted cities |
| GET | `/pollution/cleanest-cities` | Least polluted cities |

---

# 📊 Dataset

The ETL pipeline processes a global air pollution dataset containing over **23,000** records.

The pipeline performs:

- Data Extraction
- Data Cleaning
- Data Transformation
- Duplicate Detection
- MongoDB Loading

---

# 📈 Future Improvements

- Prometheus Monitoring
- Grafana Dashboards
- Alertmanager
- Loki Logging
- Terraform Infrastructure Provisioning
- Argo Rollouts
- Blue-Green Deployment
- Canary Deployment
- OpenTelemetry
- Distributed Tracing
- Frontend Dashboard (React)

---

# 📷 Screenshots

> Screenshots will be added after deployment.

- Jenkins Pipeline
- ArgoCD Dashboard
- Kubernetes Resources
- SonarQube Report
- Trivy Scan
- API Testing
- Monitoring Dashboard (Upcoming)

---

# 🎯 Purpose

This project was built to learn and implement real-world Backend and DevOps practices rather than simply deploying an application.

The focus is on understanding how modern production systems are built, automated, secured, and deployed using industry-standard tools and workflows.

---

# 👨‍💻 Author

**Arpanel Franklin**

Backend & DevOps Engineer

LinkedIn:
https://linkedin.com/in/arpanel-franklin-a5613a368

Portfolio:
https://arpanelfranklin.in

GitHub:
https://github.com/arpanelfranklin

---

# ⭐ If you found this project helpful, consider giving it a star.