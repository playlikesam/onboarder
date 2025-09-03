# 🚀 Customer Onboarder API

[![Java](https://img.shields.io/badge/Java-17-orange?logo=java)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)  
[![Build Tool](https://img.shields.io/badge/Build-Maven-blue?logo=apachemaven)](https://maven.apache.org/)  
[![Database](https://img.shields.io/badge/Database-PostgreSQL-blue?logo=postgresql)](https://www.postgresql.org/)  
[![Deployment](https://img.shields.io/badge/Deploy-Render-purple?logo=render)](https://render.com/)  

This project is a Spring Boot–based Customer Onboarding API designed to manage the complete customer lifecycle with features like create, read, update, delete (CRUD) and an approval workflow. The application is structured into clear layers: the Controller exposes REST endpoints, DTOs handle request/response formats, Models define the database schema, Repositories manage database queries via JPA, the Service layer contains business logic, and custom Exceptions ensure graceful error handling. Development initially began with the H2 in-memory database for quick setup and testing. When migrating to a production-ready environment on Render, we switched to PostgreSQL for persistent storage. During deployment, we faced a series of challenges: first, database driver issues due to missing dependencies; second, connectivity errors caused by incomplete or misconfigured environment variables; and third, application startup timeouts while Render scanned for the correct exposed port. Each of these was resolved step by step—by explicitly defining the PostgreSQL driver, configuring all sensitive credentials through environment variables and referencing them in application.properties, and ensuring the correct port binding. We also introduced a multi-stage Docker build, which packaged the app more efficiently for deployment. After these fixes, the API was successfully deployed on Render, fully connected to PostgreSQL, and verified through Postman tests. The live API is now available at: [![Onboarder](https://github.com/user-attachments/assets/8c8a92d2-cf7f-4a59-8011-108bd3a6d331)](https://onboarder-uqjd.onrender.com)  


## ✅ Status

 1. Local dev with H2 DB
 2. CRUD APIs tested with Postman
 3. Connected to Render PostgreSQL
 4. Deployment via Docker on Render
---

## 📌 Features

- Create a new customer (registration).
- Retrieve all customers or a single customer by ID.
- Approve customers (status change: `PENDING → APPROVED`).
- Delete customers.
- Built-in validation (email, phone, etc.).
- REST API tested with **Postman**.
- Deployed live on **Render** with free PostgreSQL DB.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.5**
- **Spring Data JPA**
- **PostgreSQL** (via Render)
- **Maven**
- **Docker** (for deployment)

---

## 📂 Project Structure

```
src/main/java/com/example/onboarder
│── OnboarderApplication.java # Main Spring Boot App
│
├── controller
│ └── CustomerController.java
│
├── dto
│ ├── RegisterCustomerRequest.java
│ └── CustomerResponse.java
│
├── model
│ ├── Customer.java
│ └── OnboardingStatus.java
│
├── repository
│ └── CustomerRepository.java
│
├── service
│ └── CustomerService.java
│
└── exception
├── ResourceNotFoundException.java
└── ResourceAlreadyExistsException.java

```


---

## ⚡ Getting Started

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/onboarder.git
cd onboarder
```
### Configure application.properties
```src/main/resources/application.properties

spring.application.name=onboarder
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

### Build and run 
```
mvn spring-boot:run
```

####Currently using H2 in-memory DB for testing. For free hosting with persistent DB (no credit card required), options include:
1. Neon PostgreSQL
2. Supabase
3. Render free Postgres

### Deployment on Render
_environment varibles render pe hi dalna so that if you want to change the DB so there's no need to make changes in your current file_
```
spring.application.name=onboarder

# PostgreSQL (from Render env variables)
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate & JPA
spring.jpa.hibernate.ddl-auto=${SPRING_JPA_HIBERNATE_DDL_AUTO:update}
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
