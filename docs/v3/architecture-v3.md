# Architecture v3 – WorkOrder Management

Version 3 introduces the first fully testable backend layer.

This version allows the application to be executed and tested end-to-end using automatically generated data and API testing tools.

---

## System Architecture

The application follows a classic Spring Boot layered architecture.

---

## Architecture Layers

### Controller Layer

Responsible for handling HTTP requests and returning responses.

Example:

WorkerController

Responsibilities:

- Expose REST endpoints
- Receive requests from the client (Postman)
- Delegate business logic to the service layer

---

### Service Layer

Contains the business logic of the application.

Example:

WorkerService

Responsibilities:

- Process business rules
- Coordinate repository operations
- Prepare data for the controller

---

### Persistence Layer

Uses Spring Data JPA to interact with the database.

Example:

WorkerRepository

Responsibilities:

- CRUD operations
- Database queries
- Communication with Hibernate

---

### Domain Layer

Represents the core business entities.

Current entity:

Worker

| Field  | Type    |
| ------ | ------- |
| id     | Long    |
| name   | String  |
| phone  | String  |
| shift  | String  |
| active | boolean |

---

## Architecture Diagram

The following diagram represents the testable backend architecture introduced in version 3.

![Architecture v3](images/architecture-v3.png)

---

## Database Population

A configuration component automatically populates the database when the application starts.

Location:

## Application Flow

1. Client (Postman)
2. WorkerController
3. WorkerService
4. WorkerRepository
5. H2 Database

---

## Purpose of Version 3

This version introduces a fully testable backend by:

- providing CRUD endpoints for Worker
- enabling API testing through Postman
- preparing the system for future domain expansion
