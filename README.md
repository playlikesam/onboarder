# 🚀 Customer Onboarder API

A simple **Spring Boot** project for customer onboarding, supporting full **CRUD operations** and customer approval flow.  
Built with **Spring Boot 3**, **Spring Data JPA**, and **H2 Database** (with flexibility to connect to free cloud databases).  

---

## 📌 Features

- Create a new customer (registration).
- Retrieve all customers or a single customer by ID.
- Approve customers (status change: PENDING → APPROVED).
- Delete customers.
- Built-in validation (email, phone, etc.).
- REST API tested with **Postman**.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.5**
- **Spring Data JPA**
- **H2 Database** (runtime, can be swapped with Postgres/MySQL cloud DB)
- **Maven**

---

## 📂 Project Structure

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

