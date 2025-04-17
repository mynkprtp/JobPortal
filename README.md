# 🧑‍💼 JobPortal Microservices Project

A scalable Job Portal backend built with Java and Spring Boot using a microservices architecture. The project is containerized with Docker and ready for deployment in cloud environments.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud (Netflix Eureka)**
- **Docker & Docker Compose**
- **PostgreSQL** (for persistent storage)
- **Maven**

## 📦 Microservices Overview

| Service             | Description                                        |
|---------------------|----------------------------------------------------|
| **API Gateway**      | Routes requests to appropriate services.          |
| **Job Service**      | Manages job postings and job-related operations. |
| **Review Service**   | Handles company reviews.                          |
| **Company Service**  | Stores company information.                       |
| **Discovery Server** | Service registry using Eureka.                   |

---

## 🐳 Docker Setup

All services are containerized using Docker. You can spin up the entire system using Docker Compose.
