# Architecture v5 – WorkOrders and Relationships

## Goal of Version 5

The goal of this version is to transition from a simple CRUD-based system to a domain-driven design approach.

In this version, entities are no longer isolated but interconnected, allowing the system to represent real-world relationships and workflows.

This evolution enables:

- richer domain behavior
- more realistic API operations
- a scalable foundation for future features

## Architecture

The application follows a layered Spring Boot architecture:

Controller → Service → Repository → Database

---

## Domain Model

### Entities

- Worker
- Task
- WorkOrder

---

## Relationships

The system introduces relationships between entities:

- **Worker 1 ─── \* Task**
- **WorkOrder 1 ─── \* Task**

This means:

- A Worker can have multiple Tasks
- A WorkOrder can contain multiple Tasks
- A Task belongs to one Worker and one WorkOrder

---

## Domain Model Diagram

The following UML diagram represents the domain model with relationships.

Domain Model v5

---

## API Endpoints

### Workers

- GET /workers
- GET /workers/{id}
- POST /workers
- PUT /workers/{id}
- DELETE /workers/{id}

---

### Tasks

- GET /tasks
- GET /tasks/{id}
- POST /tasks
- PUT /tasks/{id}
- DELETE /tasks/{id}

#### Domain Operations

- POST /tasks/{id}/assign-worker/{workerId}
- POST /tasks/{id}/assign-workorder/{workOrderId}

---

### WorkOrders

- GET /workorders
- GET /workorders/{id}
- POST /workorders
- PUT /workorders/{id}
- DELETE /workorders/{id}

#### Domain Operations

- POST /workorders/{id}/tasks/{taskId}
- GET /workorders/{id}/tasks

---

## Database

- H2 in-memory database
- Automatic schema generation via JPA/Hibernate
- Data initialization using Faker

---

## Purpose of Version 5

This version evolves the system by:

- introducing WorkOrder entity
- implementing relationships between entities
- adding domain-level operations
- transforming the system from isolated entities to a connected domain model

---

## Postman Testing (optional but recommended)

The API has been tested using Postman, including:

- CRUD operations
- entity relationships
- domain endpoints

Screenshots available in:

docs/images/postman/
