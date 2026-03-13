# Architecture V3 – WorkOrder Management

Version 3 introduces the first fully testable backend layer.

New elements added in this version:

- Database population on application startup
- Postman collection for API testing
- Complete CRUD verification for Worker
- Updated architecture documentation

---

# System Architecture

<p align="center">
  <img src="images/architecture-v3.png" width="650"/>
</p>

---

# Architecture Layers

The application follows a classic Spring Boot layered architecture.

## Controller Layer

Responsible for handling HTTP requests and returning responses.

Example:

WorkerController

Responsibilities:

- Expose REST endpoints
- Receive requests from the client (Postman)
- Delegate business logic to the service layer

---

## Service Layer

Contains the business logic of the application.

Example:

WorkerService

Responsibilities:

- Process business rules
- Coordinate repository operations
- Prepare data for the controller

---

## Persistence Layer

Uses Spring Data JPA to interact with the database.

Example:

WorkerRepository

Responsibilities:

- CRUD operations
- Database queries
- Communication with Hibernate

---

## Domain Layer

Represents the core business entities.

Current entity:

Worker

Attributes:

| Field | Type |
|------|------|
| id | Long |
| name | String |
| phone | String |
| shift | String |
| active | boolean |

---

# Database Population

A configuration component automatically populates the database when the application starts.

Location:

src/main/java/com/paulo/workorder/config/DataInitializer.java

Purpose:

- Generate sample workers automatically
- Allow immediate API testing
- Avoid manual data creation

Example generated records:

Worker 1  
Worker 2  
Worker 3  
Worker 4  
Worker 5  

---

# API Testing

The API can be tested using the included Postman collection.

Location:

docs/postman/workorder-api.postman_collection.json

Available endpoints:

| Method | Endpoint | Description |
|------|------|------|
| GET | /workers | Get all workers |
| GET | /workers/{id} | Get worker by id |
| POST | /workers | Create worker |
| PUT | /workers/{id} | Update worker |
| DELETE | /workers/{id} | Delete worker |

---

# Application Flow

Client (Postman)
↓
WorkerController
↓
WorkerService
↓
WorkerRepository
↓
H2 Database

---

# Purpose of Version 3

This version prepares the backend for the next evolution of the system:

- Introduction of the WorkOrder entity
- Worker–WorkOrder relationships
- More advanced business logic